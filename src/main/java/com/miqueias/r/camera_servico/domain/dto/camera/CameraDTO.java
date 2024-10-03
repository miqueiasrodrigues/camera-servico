package com.miqueias.r.camera_servico.domain.dto.camera;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class CameraDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String modelo;
    private String marca;
    private String ip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraDTO cameraDTO = (CameraDTO) o;
        return Objects.equals(id, cameraDTO.id) && Objects.equals(modelo, cameraDTO.modelo) && Objects.equals(marca, cameraDTO.marca) && Objects.equals(ip, cameraDTO.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, marca, ip);
    }
}
