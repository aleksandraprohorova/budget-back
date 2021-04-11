package com.budget.repository;

import com.budget.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalancesRepository extends JpaRepository<Balance, Long> {
    List<Balance> findAllByOrderByIdDesc();
    //List<Balance> findAll();
}
