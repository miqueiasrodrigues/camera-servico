package com.miqueias.r.camera_servico.controller;

import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoDTO;
import com.miqueias.r.camera_servico.domain.dto.monitoramento.MonitoramentoUpdateDTO;
import com.miqueias.r.camera_servico.service.impl.MonitoramentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("api/monitoramento")
public class MonitoramentoController {
    @Autowired
    private MonitoramentoServiceImpl service;

    @GetMapping(value = "/todos/{cameraId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<MonitoramentoDTO>> findAll(@PathVariable(value = "cameraId") Long cameraId){
        List<MonitoramentoDTO> monitoramentosDTO = service.findAll(cameraId);
        return ResponseEntity.ok(monitoramentosDTO);
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MonitoramentoDTO> findById(@PathVariable(value = "id") Long id){
        MonitoramentoDTO monitoramentoDTO = service.findById(id);
        return ResponseEntity.ok(monitoramentoDTO);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MonitoramentoDTO> create(@RequestBody MonitoramentoCreateDTO monitoramentoCreateDTO){
        MonitoramentoDTO monitoramentoCreatedDTO = service.create(monitoramentoCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(monitoramentoCreatedDTO);
    }



    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MonitoramentoDTO> update(@RequestBody MonitoramentoUpdateDTO monitoramentoUpdateDTO){
        MonitoramentoDTO monitoramentoUpdatedDTO = service.update(monitoramentoUpdateDTO);
        return ResponseEntity.ok(monitoramentoUpdatedDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
