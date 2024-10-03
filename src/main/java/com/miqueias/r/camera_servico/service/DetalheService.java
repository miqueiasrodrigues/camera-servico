package com.miqueias.r.camera_servico.service;

import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheUpdateDTO;

public interface DetalheService {
    DetalheDTO findById(Long id);
    DetalheDTO create(DetalheCreateDTO detalheCreateDTO);
    DetalheDTO update(DetalheUpdateDTO detalheUpdateDTO);
    void delete(Long id);
}
