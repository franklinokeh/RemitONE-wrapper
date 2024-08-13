package com.codedsolutions47.remitonewrapper.model.repository;

import com.codedsolutions47.remitonewrapper.model.entity.Remitter
import org.springframework.data.jpa.repository.JpaRepository

interface RemitterRepository : JpaRepository<Remitter, Long> {
}
