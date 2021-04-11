package com.budget.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Operations")
@Getter
@Setter
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "debit")
    private double debit;

    @Column(name = "credit")
    private double credit;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "balance_id")
    private Long balanceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

    public Operation(double debit, double credit, LocalDateTime create_date)
    {
        this.debit = debit;
        this.credit = credit;
        this.create_date = create_date;
    }
}
