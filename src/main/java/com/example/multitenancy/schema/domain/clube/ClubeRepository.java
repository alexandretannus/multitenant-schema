package com.example.multitenancy.schema.domain.clube;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {
/* 
    @Query("select max(atualizado) from Clube")
    public OffsetDateTime getUltimaAtualizacao(); */
}
