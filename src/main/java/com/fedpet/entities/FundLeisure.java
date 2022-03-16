package com.fedpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblfundLeisure",schema = "public")
public class FundLeisure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private User contributor;
    @ManyToOne
    private Group Group;
    private double amount;
    private LocalDateTime timestamp;
    private String transactionId;
    private TransactionMode transactionMode;
    private TransactionType transactionType;
}
