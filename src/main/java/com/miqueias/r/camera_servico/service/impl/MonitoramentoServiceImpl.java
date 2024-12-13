package com.miqueias.r.camera_servico.service.impl;

import com.miqueias.r.camera_servico.domain.Detalhe;
import com.miqueias.r.camera_servico.domain.Monitoramento;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;
import com.miqueias.r.camera_servico.exception.ResourceNotFoundException;
import com.miqueias.r.camera_servico.repository.DetalheRepository;
import com.miqueias.r.camera_servico.repository.MonitoramentoRepository;
import com.miqueias.r.camera_servico.service.MonitoramentoService;
import com.miqueias.r.camera_servico.service.mapper.MonitoramentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoramentoServiceImpl implements MonitoramentoService {

    @Autowired
    private MonitoramentoRepository monitoramentoRepository;
    @Autowired
    private DetalheRepository detalheRepository;

    private final MonitoramentoMapper mapper = MonitoramentoMapper.INSTANCE;

    @Override
    public MonitoramentoDTO findById(Long id) {
        Monitoramento monitoramento = monitoramentoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Monitoramento não encontrado!")
        );

        return mapper.toMonitoramentoDTO(monitoramento);
    }

    @Override
    public MonitoramentoDTO create(MonitoramentoCreateDTO monitoramentoCreateDTO) {
        Monitoramento monitoramentoCreate = mapper.toMonitoramento(monitoramentoCreateDTO);

        Detalhe detalhe = detalheRepository.findById(monitoramentoCreate.getDetalhe().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Detalhes associados não encontrado!")
        );

        monitoramentoCreate.setDetalhe(detalhe);
        Monitoramento monitoramentoCreated = monitoramentoRepository.save(monitoramentoCreate);
        return mapper.toMonitoramentoDTO(monitoramentoCreated);
    }

    @Override
    public MonitoramentoDTO update(MonitoramentoUpdateDTO monitoramentoUpdateDTO) {
        Monitoramento monitoramento = monitoramentoRepository.findById(mapper.toMonitoramento(monitoramentoUpdateDTO).getId()).orElseThrow(
                () -> new ResourceNotFoundException("Monitoramento não encontrado!")
        );

        Detalhe detalhe = detalheRepository.findById(monitoramento.getDetalhe().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Detalhes associados não encontrado!")
        );
        monitoramento.setDetalhe(detalhe);
        monitoramento.setDia(mapper.toMonitoramento(monitoramentoUpdateDTO).getDia());

        Monitoramento monitoramentoUpdated = monitoramentoRepository.save(monitoramento);
        return  mapper.toMonitoramentoDTO(monitoramentoUpdated);
    }

    @Override
    public void delete(Long id) {
        Monitoramento monitoramento = monitoramentoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Monitoramento não encontrado!")
        );

        monitoramentoRepository.delete(monitoramento);
    }
}
