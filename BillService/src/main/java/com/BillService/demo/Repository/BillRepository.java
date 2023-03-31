package com.BillService.demo.Repository;

import com.BillService.demo.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
