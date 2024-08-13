package com.codedsolutions47.remitonewrapper.model.repository;

import com.codedsolutions47.remitonewrapper.model.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
}
