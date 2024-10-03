package com.miqueias.r.camera_servico.service;


import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;

public interface MonitoramentoService {
    MonitoramentoDTO findById(Long id);
    MonitoramentoDTO create(MonitoramentoCreateDTO monitoramentoCreateDTO);
    MonitoramentoDTO update(MonitoramentoUpdateDTO monitoramentoUpdateDTO);
    void delete(Long id);

}
