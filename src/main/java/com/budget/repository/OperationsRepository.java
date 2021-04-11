package com.budget.repository;

import com.budget.entity.Balance;
import com.budget.entity.IBalanceInfo;
import com.budget.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OperationsRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByOrderByIdDesc();
    List<Operation> findOperationsByBalanceId(Long balanceId);

    @Query(value = "SELECT to_date(?2, 'YYYY-MM-DD') as createDate, SUM(debit) as debit, SUM(credit) as credit, SUM(debit) - SUM(credit) as amount\n" +
            "    FROM Operations\n" +
            "    WHERE Operations.create_date between to_date(?1, 'YYYY-MM-DD') and to_date(?2, 'YYYY-MM-DD')", nativeQuery = true)
    IBalanceInfo getBalanceInfo(String dateStart, String dateEnd);

    @Modifying
    @Query(value = "UPDATE Operations SET balance_id = :ID" +
            "    WHERE Operations.create_date between to_date(:d1, 'YYYY-MM-DD') and to_date(:d2, 'YYYY-MM-DD')", nativeQuery = true)
    void setBalanceId(@Param("d1") String dateStart, @Param("d2") String dateEnd, @Param("ID") Long ID);

    @Modifying
    @Query(value = "UPDATE Operations SET balance_id = null" +
            "    WHERE balance_id = :ID", nativeQuery = true)
    void removeBalanceId(@Param("ID") Long ID);
}
