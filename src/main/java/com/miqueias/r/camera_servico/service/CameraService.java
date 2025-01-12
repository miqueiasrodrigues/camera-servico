package com.miqueias.r.camera_servico.service;

import com.miqueias.r.camera_servico.domain.dto.ToggleDTO;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraDTO;

import java.util.List;

public interface CameraService {
    CameraDTO findById(Long id);
    List<CameraDTO> findAll(Long usuarioId);
    CameraDTO create(CameraCreateDTO cameraCreateDTO);
    CameraDTO update(CameraDTO cameraDTO);
    CameraDTO toggle(ToggleDTO toggleDTO);
    void delete(Long id);


}
