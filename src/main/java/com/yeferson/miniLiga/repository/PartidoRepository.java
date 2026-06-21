package com.yeferson.miniLiga.repository;

import com.yeferson.miniLiga.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByTorneoIdAndFinalizadoTrue(Long torneoId);
}
