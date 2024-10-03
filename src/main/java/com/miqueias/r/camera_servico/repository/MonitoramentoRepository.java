package com.miqueias.r.camera_servico.repository;

import com.miqueias.r.camera_servico.domain.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {
}
