package com.miqueias.r.camera_servico.service.impl;

import com.miqueias.r.camera_servico.domain.Camera;
import com.miqueias.r.camera_servico.domain.Detalhe;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheUpdateDTO;
import com.miqueias.r.camera_servico.exception.ResourceNotFoundException;
import com.miqueias.r.camera_servico.repository.CameraRepository;
import com.miqueias.r.camera_servico.repository.DetalheRepository;
import com.miqueias.r.camera_servico.service.DetalheService;
import com.miqueias.r.camera_servico.service.mapper.DetalheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalheServiceImpl implements DetalheService {
    @Autowired
    private DetalheRepository detalheRepository;

    @Autowired
    private CameraRepository cameraRepository;

    private final DetalheMapper mapper = DetalheMapper.INSTANCE;

    @Override
    public DetalheDTO findById(Long id) {
        Detalhe detalhe = detalheRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Detalhes não encontrado!")
        );

        return mapper.toDetalheDTO(detalhe);
    }

    @Override
    public DetalheDTO create(DetalheCreateDTO detalheCreateDTO) {

        Detalhe detalheCreate = mapper.toDetalhe(detalheCreateDTO);

        Camera camera = cameraRepository.findById(detalheCreate.getCamera().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Câmera associada não encontrada!")
        );

        detalheCreate.setCamera(camera);
        Detalhe detalheCreated = detalheRepository.save(detalheCreate);
        return mapper.toDetalheDTO(detalheCreated);
    }

    @Override
    public DetalheDTO update(DetalheUpdateDTO detalheUpdateDTO) {

        Detalhe detalhe = detalheRepository.findById(mapper.toDetalhe(detalheUpdateDTO).getId()).orElseThrow(
                () -> new ResourceNotFoundException("Detalhes não encontrado")
        );

        Camera camera = cameraRepository.findById(detalhe.getCamera().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Câmera associada não encontrada!")
        );

        detalhe.setCamera(camera);
        detalhe.setHoraInicio(mapper.toDetalhe(detalheUpdateDTO).getHoraInicio());
        detalhe.setHoraFim(mapper.toDetalhe(detalheUpdateDTO).getHoraFim());

        Detalhe detalheUpdate = detalheRepository.save(detalhe);

        return mapper.toDetalheDTO(detalheUpdate);
    }

    @Override
    public void delete(Long id) {
        Detalhe detalhe = detalheRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Detalhes não encontrados")
        );

        detalheRepository.delete(detalhe);
    }
}
