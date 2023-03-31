package com.BillService.demo.Service;

import com.BillService.demo.Model.Bill;

import java.time.LocalDate;
import java.util.List;

public interface BillService {

    public Bill addBill(Bill bill);

    public Bill removeBill(Integer billId);

    public Bill updateBill(Bill bill);

    public Bill viewBill(Integer billId);

    public List<Bill> viewBillByDate(LocalDate startDate , LocalDate endDate);

    public List<Bill> viewBillOfUser(Integer userId);

    public Double calculateBill(Bill bill);

}
