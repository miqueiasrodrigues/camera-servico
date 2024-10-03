package com.miqueias.r.camera_servico.service.mapper;

import com.miqueias.r.camera_servico.domain.Monitoramento;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MonitoramentoMapper {
    MonitoramentoMapper INSTANCE = Mappers.getMapper(MonitoramentoMapper.class);

    MonitoramentoDTO toMonitoramentoDTO(Monitoramento monitoramento);
    @Mapping(source = "detalheId", target = "detalhe.id")
    Monitoramento toMonitoramento(MonitoramentoCreateDTO monitoramentoCreateDTO);
    @Mapping(source = "detalheId", target = "detalhe.id")
    Monitoramento toMonitoramento(MonitoramentoUpdateDTO monitoramentoUpdateDTO);
}
