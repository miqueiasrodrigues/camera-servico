package com.miqueias.r.camera_servico.domain.dto.camera;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class CameraCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String modelo;
    private String marca;
    private String ip;

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
        CameraCreateDTO that = (CameraCreateDTO) o;
        return Objects.equals(modelo, that.modelo) && Objects.equals(marca, that.marca) && Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, ip);
    }
}
