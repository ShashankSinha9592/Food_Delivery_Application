package com.BillService.demo.Controller;

import com.BillService.demo.DTO.BillDTO;
import com.BillService.demo.Model.Bill;
import com.BillService.demo.Service.BillService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/fooddelivery/bill")
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping
    @Operation(summary = "add bill")
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<BillDTO> addBill(Bill bill){

        BillDTO savedBillDTO = billService.addBill(bill);

        return new ResponseEntity<>(savedBillDTO, HttpStatus.CREATED);

    }

    @DeleteMapping("/{billId}")
    @Operation(summary = "remove bill")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<Bill> removeBill(Integer billId){

        Bill removedBill = billService.removeBill(billId);

        return new ResponseEntity<>(removedBill,HttpStatus.OK);

    }

    @PutMapping("/{billId}")
    @Operation(summary = "update bill")
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<Bill> updateBill(Bill bill){

        Bill updatedBill = billService.updateBill(bill);

        return new ResponseEntity<>(updatedBill,HttpStatus.ACCEPTED);

    }

    @GetMapping("/{billId}")
    @Operation(summary = "view bill")
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<BillDTO> viewBill(Integer billId){

        BillDTO billDTO = billService.viewBill(billId);

        return new ResponseEntity<>(billDTO,HttpStatus.OK);

    }

    @GetMapping("/billbydate/{startDate}/{endDate}")
    @Operation(summary = "view bill by date")
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<List<BillDTO>> viewBillByDate(LocalDateTime startDate , LocalDateTime endDate){

        List<BillDTO> billsDTo = billService.viewBillByDate(startDate,endDate);

        return new ResponseEntity<>(billsDTo,HttpStatus.OK);

    }

    @GetMapping("/billsofuser/{userId}")
    @Operation(summary = "view bill of user by user id")
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<List<BillDTO>> viewBillOfUser(Integer userId){

        List<BillDTO> bills = billService.viewBillOfUser(userId);

        return new ResponseEntity<>(bills, HttpStatus.OK);

    }

//    @GetMapping("/calculatebill")
//    @Operation(summary = "calculate bill")
//    public ResponseEntity<Double> calculateBill(Bill bill){
//
//        Double calculatedAmount = billService.calculateBill(bill);
//
//        return new ResponseEntity<>(calculatedAmount,HttpStatus.OK);
//
//    }

}
