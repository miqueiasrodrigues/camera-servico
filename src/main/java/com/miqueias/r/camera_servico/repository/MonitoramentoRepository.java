package com.miqueias.r.camera_servico.repository;

import com.miqueias.r.camera_servico.domain.Monitoramento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long> {
    @Query("SELECT m FROM Monitoramento m WHERE m.camera.id = :cameraId")
    List<Monitoramento> findAllByCameraId(Long cameraId);
}
