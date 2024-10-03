package com.miqueias.r.camera_servico.repository;

import com.miqueias.r.camera_servico.domain.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {
}
