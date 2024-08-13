package com.codedsolutions47.remitonewrapper.model.repository;

import com.codedsolutions47.remitonewrapper.model.entity.Beneficiary
import org.springframework.data.jpa.repository.JpaRepository

interface BeneficiaryRepository : JpaRepository<Beneficiary, Long> {
}
