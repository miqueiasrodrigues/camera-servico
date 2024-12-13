package com.miqueias.r.camera_servico.service.impl;

import com.miqueias.r.camera_servico.domain.Camera;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraDTO;
import com.miqueias.r.camera_servico.exception.ResourceNotFoundException;
import com.miqueias.r.camera_servico.repository.CameraRepository;
import com.miqueias.r.camera_servico.service.CameraService;
import com.miqueias.r.camera_servico.service.mapper.CameraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {
    @Autowired
    private CameraRepository repository;

    private final CameraMapper mapper = CameraMapper.INSTANCE;

    @Override
    public CameraDTO findById(Long id) {
        Camera camera = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Câmera não encontrada!")
        );

        return mapper.toCameraDTO(camera);
    }

    @Override
    public List<CameraDTO> findAll() {
        List<Camera> cameras = repository.findAll();

        return mapper.toCamerasDTO(cameras);
    }

    @Override
    public CameraDTO create(CameraCreateDTO cameraCreateDTO) {
       Camera cameraCreate = repository.save(mapper.toCamera(cameraCreateDTO));

       return mapper.toCameraDTO(cameraCreate);
    }

    @Override
    public CameraDTO update(CameraDTO cameraDTO) {
        Camera camera = repository.findById(mapper.toCamera(cameraDTO).getId()).orElseThrow(
                () -> new ResourceNotFoundException("Usuário não encontrado.")
        );

        camera.setMarca(mapper.toCamera(cameraDTO).getMarca());
        camera.setModelo(mapper.toCamera(cameraDTO).getModelo());
        camera.setIp(mapper.toCamera(cameraDTO).getIp());
        camera.setPorta(mapper.toCamera(cameraDTO).getPorta());
        camera.setUsuario(mapper.toCamera(cameraDTO).getUsuario());
        camera.setSenha(mapper.toCamera(cameraDTO).getSenha());
        camera.setUsuarioId(mapper.toCamera(cameraDTO).getUsuarioId());

        Camera cameraUpdate = repository.save(camera);

        return mapper.toCameraDTO(cameraUpdate);
    }

    @Override
    public void delete(Long id) {
        Camera camera = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Câmera não encontrada!")
        );

        repository.delete(camera);
    }
}
