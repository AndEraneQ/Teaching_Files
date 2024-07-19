package com.demo_bank_v1.repository;

import com.demo_bank_v1.models.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

    @Modifying
    @Query(value = "INSERT INTO transactions(account_id, transaction_type, amount, source_, status_, reason_code, created_at) " +
            "VALUES(:account_id, :transaction_type, :amount, :source_, :status_, :reason_code, :created_at)", nativeQuery = true)
    @Transactional
    void logTransaction(@Param("account_id")int account_id,
                        @Param("transaction_type")String transaction_type,
                        @Param("amount")double amount,
                        @Param("source_")String source_,
                        @Param("status_")String status_,
                        @Param("reason_code")String reason_code,
                        @Param("created_at") LocalDateTime created_at
                        );

}
