package com.miqueias.r.camera_servico.service.mapper;


import com.miqueias.r.camera_servico.domain.Camera;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CameraMapper {
    CameraMapper INSTANCE = Mappers.getMapper(CameraMapper.class);

    CameraDTO toCameraDTO(Camera camera);
    List<CameraDTO> toCamerasDTO(List<Camera> cameras);
    Camera toCamera(CameraCreateDTO cameraCreateDTO);
    Camera toCamera(CameraDTO cameraDTO);


}