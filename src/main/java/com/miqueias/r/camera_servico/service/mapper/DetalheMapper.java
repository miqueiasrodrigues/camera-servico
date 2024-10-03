package com.miqueias.r.camera_servico.service.mapper;

import com.miqueias.r.camera_servico.domain.Detalhe;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DetalheMapper {
    DetalheMapper INSTANCE = Mappers.getMapper(DetalheMapper.class);

    DetalheDTO toDetalheDTO(Detalhe detalhe);
    @Mapping(source = "cameraId", target = "camera.id")
    Detalhe toDetalhe(DetalheCreateDTO detalheCreateDTO);
    @Mapping(source = "cameraId", target = "camera.id")
    Detalhe toDetalhe(DetalheUpdateDTO detalheUpdateDTO);

}
