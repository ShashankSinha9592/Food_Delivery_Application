package com.BillService.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime timeSpan;

    private Integer orderDetailId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer totalItem;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double totalCost;
}
