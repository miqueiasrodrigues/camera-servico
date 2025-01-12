package com.miqueias.r.camera_servico.domain.dto.camera;

import com.miqueias.r.camera_servico.utils.enumerate.Status;

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
    private Integer porta;
    private String usuario;
    private String senha;
    private Long usuarioId;
    private Status status;


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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraDTO cameraDTO = (CameraDTO) o;
        return Objects.equals(id, cameraDTO.id) && Objects.equals(modelo, cameraDTO.modelo) && Objects.equals(marca, cameraDTO.marca) && Objects.equals(ip, cameraDTO.ip) && Objects.equals(porta, cameraDTO.porta) && Objects.equals(usuario, cameraDTO.usuario) && Objects.equals(senha, cameraDTO.senha) && Objects.equals(usuarioId, cameraDTO.usuarioId) && status == cameraDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, marca, ip, porta, usuario, senha, usuarioId, status);
    }
}
