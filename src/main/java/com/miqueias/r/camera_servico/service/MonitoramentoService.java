package com.miqueias.r.camera_servico.service;


import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;

import java.util.List;

public interface MonitoramentoService {
    List<MonitoramentoDTO> findAll(Long cameraId);
    MonitoramentoDTO findById(Long id);
    MonitoramentoDTO create(MonitoramentoCreateDTO monitoramentoCreateDTO);
    MonitoramentoDTO update(MonitoramentoUpdateDTO monitoramentoUpdateDTO);
    void delete(Long id);

}
