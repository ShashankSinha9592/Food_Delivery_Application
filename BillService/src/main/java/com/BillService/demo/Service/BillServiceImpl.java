package com.BillService.demo.Service;

import com.BillService.demo.DTO.BillDTO;
import com.BillService.demo.Exceptions.BillException;
import com.BillService.demo.Exceptions.OrderException;
import com.BillService.demo.Model.Bill;
import com.BillService.demo.Model.Item;
import com.BillService.demo.Model.OrderDetails;
import com.BillService.demo.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    BillRepository billRepository;

    @Override
    public BillDTO addBill(Bill bill) {

        Bill savedBill = billRepository.save(bill);

        return convertBillDTO(savedBill);

    }

    @Override
    public Bill removeBill(Integer billId) {

        Bill bill = billRepository.findById(billId).orElseThrow(()-> new BillException("Bill does not exists with bill id : "+billId));

        billRepository.delete(bill);

        return bill;

    }

    @Override
    public Bill updateBill(Bill bill) {

        Bill savedBill = billRepository.findById(bill.getBillId()).orElseThrow(()-> new BillException("Bill does not exists with bill id : "+bill.getBillId()));

        return billRepository.save(bill);

    }

    @Override
    public BillDTO viewBill(Integer billId) {

        Bill bill = billRepository.findById(billId).orElseThrow(()-> new BillException("Bill does not exists with bill id : "+billId));

        return convertBillDTO(bill);

    }

    @Override
    public List<BillDTO> viewBillByDate(LocalDateTime startDate, LocalDateTime endDate) {

        List<Bill> bills = billRepository.findBillBetweenDates(startDate, endDate);

        if(bills.isEmpty()) throw new BillException("Bills not found");

        List<BillDTO> billDTOS = new ArrayList<>();

        for (Bill bill : bills){
            BillDTO billDTO = convertBillDTO(bill);
            billDTOS.add(billDTO);
        }

        return billDTOS;

    }

    @Override
    public Bill viewBillOfUser(Integer userId) {
        return null;
    }

    @Override
    public Double calculateBill(Bill bill) {
        return null;
    }

    private BillDTO convertBillDTO(Bill bill){

        BillDTO billDTO = new BillDTO();

        billDTO.setBillId(bill.getBillId());
        billDTO.setTimeSpan(bill.getTimeSpan());

        OrderDetails orderDetails = orderDetailService.getOrderDetails(bill.getOrderDetailId());

        if(orderDetails==null){
            throw new OrderException("Order does not exists with order id : "+bill.getOrderDetailId());
        }

        billDTO.setOrderDetails(orderDetails);

        billDTO.setTotalCost(getTotalCost(orderDetails));

        billDTO.setTotalItem(orderDetails.getCart().getItems().size());

        return billDTO;



    }


    private Double getTotalCost(OrderDetails orderDetails){

        List<Item> items = orderDetails.getCart().getItems();

        Double totalCost=0d;

        for(Item item : items){
            totalCost+=item.getCost();
        }

        return totalCost;


    }


}
