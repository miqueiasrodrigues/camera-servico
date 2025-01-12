package com.miqueias.r.camera_servico.service.mapper;

import com.miqueias.r.camera_servico.domain.Camera;
import com.miqueias.r.camera_servico.domain.Monitoramento;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonitoramentoMapper {
    MonitoramentoMapper INSTANCE = Mappers.getMapper(MonitoramentoMapper.class);

    MonitoramentoDTO toMonitoramentoDTO(Monitoramento monitoramento);
    List<MonitoramentoDTO> toMonitoramentosDTO(List<Monitoramento> monitoramentos);

    @Mapping(source = "cameraId", target = "camera.id")
    Monitoramento toMonitoramento(MonitoramentoCreateDTO monitoramentoCreateDTO);

    Monitoramento toMonitoramento(MonitoramentoUpdateDTO monitoramentoUpdateDTO);
}
