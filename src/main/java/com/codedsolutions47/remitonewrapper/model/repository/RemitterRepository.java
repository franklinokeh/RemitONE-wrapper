package com.codedsolutions47.remitonewrapper.model.repository;

import com.codedsolutions47.remitonewrapper.model.entity.Remitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RemitterRepository extends JpaRepository<Remitter, Long> {
    Optional<Remitter> findByRemitterId(Long remitterId);
}
