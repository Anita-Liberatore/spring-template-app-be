package com.fabrick.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fabrick.test.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>  {

	@Query(
			  value = "select * from transaction t where t.operation_id = :operationId", 
			  nativeQuery = true)
	Transaction findTransactionByOperationId(@Param("operationId") String operationId);
	
}
