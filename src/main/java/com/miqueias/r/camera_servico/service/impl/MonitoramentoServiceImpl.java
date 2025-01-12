package com.miqueias.r.camera_servico.service.impl;

import com.miqueias.r.camera_servico.domain.Camera;
import com.miqueias.r.camera_servico.domain.Monitoramento;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;
import com.miqueias.r.camera_servico.exception.ResourceNotFoundException;
import com.miqueias.r.camera_servico.repository.CameraRepository;
import com.miqueias.r.camera_servico.repository.MonitoramentoRepository;
import com.miqueias.r.camera_servico.service.MonitoramentoService;
import com.miqueias.r.camera_servico.service.mapper.MonitoramentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoramentoServiceImpl implements MonitoramentoService {

    @Autowired
    private MonitoramentoRepository monitoramentoRepository;
    @Autowired
    private CameraRepository cameraRepository;


    @Autowired
    private MonitoramentoMapper mapper;

    @Override
    public List<MonitoramentoDTO> findAll(Long cameraId) {
        List<Monitoramento> monitoramentos = monitoramentoRepository.findAllByCameraId(cameraId);
        return mapper.toMonitoramentosDTO(monitoramentos);
    }

    @Override
    public MonitoramentoDTO findById(Long id) {
        Monitoramento monitoramento = monitoramentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monitoramento não encontrado!"));
        return mapper.toMonitoramentoDTO(monitoramento);
    }

    @Override
    public MonitoramentoDTO create(MonitoramentoCreateDTO monitoramentoCreateDTO) {
        Monitoramento monitoramento = mapper.toMonitoramento(monitoramentoCreateDTO);
        Camera camera = cameraRepository.findById(monitoramentoCreateDTO.getCameraId())
                .orElseThrow(() -> new ResourceNotFoundException("Câmera não encontrado!"));
        monitoramento.setCamera(camera);
        Monitoramento savedMonitoramento = monitoramentoRepository.save(monitoramento);
        return mapper.toMonitoramentoDTO(savedMonitoramento);
    }

    @Override
    public MonitoramentoDTO update(MonitoramentoUpdateDTO monitoramentoUpdateDTO) {
        Long monitoramentoId = monitoramentoUpdateDTO.getId();
        Monitoramento existingMonitoramento = monitoramentoRepository.findById(monitoramentoId)
                .orElseThrow(() -> new ResourceNotFoundException("Monitoramento não encontrado!"));

        existingMonitoramento.setDia(monitoramentoUpdateDTO.getDia());
        existingMonitoramento.setHoraInicio(monitoramentoUpdateDTO.getHoraInicio());
        existingMonitoramento.setHoraFim(monitoramentoUpdateDTO.getHoraFim());

        Monitoramento updatedMonitoramento = monitoramentoRepository.save(existingMonitoramento);
        return mapper.toMonitoramentoDTO(updatedMonitoramento);
    }

    @Override
    public void delete(Long id) {
        Monitoramento monitoramento = monitoramentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Monitoramento não encontrado!"));
        monitoramentoRepository.delete(monitoramento);
    }
}
