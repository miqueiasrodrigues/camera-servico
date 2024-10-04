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
    private Integer porta;
    private String usuario;
    private String senha;

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

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraCreateDTO that = (CameraCreateDTO) o;
        return Objects.equals(modelo, that.modelo) && Objects.equals(marca, that.marca) && Objects.equals(ip, that.ip) && Objects.equals(porta, that.porta) && Objects.equals(usuario, that.usuario) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, ip, porta, usuario, senha);
    }
}
