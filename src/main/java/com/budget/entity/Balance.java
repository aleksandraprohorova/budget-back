package com.budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Balance")
@Getter
@Setter
@NoArgsConstructor
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "debit")
    private double debit;

    @Column(name = "credit")
    private double credit;

    @Column(name = "amount")
    private double amount;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    public Balance(double debit, double credit, double amount, LocalDateTime create_date)
    {
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
        this.create_date = create_date;
    }
}
