package com.codedsolutions47.remitonewrapper.model.repository;

import com.codedsolutions47.remitonewrapper.model.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

    Optional<Beneficiary> findByBeneficiaryId(long beneficiaryId);
}
