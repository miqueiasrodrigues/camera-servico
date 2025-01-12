package com.miqueias.r.camera_servico.repository;

import com.miqueias.r.camera_servico.domain.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {
    @Query("SELECT c FROM Camera c WHERE c.usuarioId = :usuarioId ORDER BY c.ip ASC")
    List<Camera> findAllByUsuarioIdOrderByIp(Long usuarioId);
}
