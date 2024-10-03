package com.miqueias.r.camera_servico.controller;


import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheDTO;
import com.miqueias.r.camera_servico.domain.dto.detalhe.DetalheUpdateDTO;
import com.miqueias.r.camera_servico.service.impl.DetalheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("api/detalhe")
public class DetalheController {
    @Autowired
    private DetalheServiceImpl service;
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DetalheDTO> findById(@PathVariable(value = "id") Long id){
        DetalheDTO detalheDTO = service.findById(id);
        return ResponseEntity.ok(detalheDTO);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DetalheDTO> create(@RequestBody DetalheCreateDTO detalheCreateDTO){
        DetalheDTO detalheCreatedDTO = service.create(detalheCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalheCreatedDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DetalheDTO> update(@RequestBody DetalheUpdateDTO detalheUpdateDTO){
        DetalheDTO detalheUpdatedDTO = service.update(detalheUpdateDTO);
        return ResponseEntity.ok(detalheUpdatedDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
