package com.BillService.demo.Repository;

import com.BillService.demo.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {


    @Query("SELECT b FROM Bill b where b.timeSpan between :startDate AND :endDate")
    public List<Bill> findBillBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
