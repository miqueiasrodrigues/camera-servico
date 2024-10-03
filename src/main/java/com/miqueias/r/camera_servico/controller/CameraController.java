package com.miqueias.r.camera_servico.controller;

import com.miqueias.r.camera_servico.domain.dto.camera.CameraCreateDTO;
import com.miqueias.r.camera_servico.domain.dto.camera.CameraDTO;
import com.miqueias.r.camera_servico.service.impl.CameraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
@RequestMapping("api/camera")
public class CameraController {
    @Autowired
    private CameraServiceImpl service;
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CameraDTO> findById(@PathVariable(value = "id") Long id){
        CameraDTO cameraDTO = service.findById(id);
        return ResponseEntity.ok(cameraDTO);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<CameraDTO>> findById(){
        List<CameraDTO> camerasDTO = service.findAll();
        return ResponseEntity.ok(camerasDTO);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CameraDTO> create(@RequestBody CameraCreateDTO cameraCreateDTO){
        CameraDTO cameraCreatedDTO = service.create(cameraCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cameraCreatedDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CameraDTO> update(@RequestBody CameraDTO cameraUpdateDTO){
        CameraDTO cameraUpdatedDTO = service.update(cameraUpdateDTO);
        return ResponseEntity.ok(cameraUpdatedDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
