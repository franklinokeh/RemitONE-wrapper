package com.codedsolutions47.remitonewrapper.model.repository;

import com.codedsolutions47.remitonewrapper.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  Transaction findByAgentTransRef(String agentTransRef);
}
