package com.BillService.demo.Controller;

import com.BillService.demo.Model.Bill;
import com.BillService.demo.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/fooddelivery/bill")
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping
    public ResponseEntity<Bill> addBill(Bill bill){

        Bill savedBill = billService.addBill(bill);

        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);

    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<Bill> removeBill(Integer billId){

        Bill removedBill = billService.removeBill(billId);

        return new ResponseEntity<>(removedBill,HttpStatus.OK);

    }

    @PutMapping("/{billId}")
    public ResponseEntity<Bill> updateBill(Bill bill){

        Bill updatedBill = billService.updateBill(bill);

        return new ResponseEntity<>(updatedBill,HttpStatus.ACCEPTED);

    }

    @GetMapping("/{billId}")
    public ResponseEntity<Bill> viewBill(Integer billId){

        Bill bill = billService.viewBill(billId);

        return new ResponseEntity<>(bill,HttpStatus.OK);

    }

    @GetMapping("/billbydate/{startDate}/{endDate}")
    public ResponseEntity<List<Bill>> viewBillByDate(LocalDate startDate , LocalDate endDate){

        List<Bill> bills = billService.viewBillByDate(startDate,endDate);

        return new ResponseEntity<>(bills,HttpStatus.OK);

    }

    @GetMapping("/billsofuser/{userId}")
    public ResponseEntity<List<Bill>> viewBillOfUser(Integer userId){

        List<Bill> bills = billService.viewBillOfUser(userId);

        return new ResponseEntity<>(bills, HttpStatus.OK);

    }

    @GetMapping("/calculatebill")
    public ResponseEntity<Double> calculateBill(Bill bill){

        Double calculatedAmount = billService.calculateBill(bill);

        return new ResponseEntity<>(calculatedAmount,HttpStatus.OK);

    }

}
