package com.miqueias.r.camera_servico.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_cameras", schema = "public")
public class Camera implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String modelo;
    @Column
    private String marca;
    @Column
    private String ip;
    @Column
    private Integer porta;
    @Column
    private String usuario;
    @Column
    private String senha;
    @Column
    private Long usuarioId;

    public Camera() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(id, camera.id) && Objects.equals(modelo, camera.modelo) && Objects.equals(marca, camera.marca) && Objects.equals(ip, camera.ip) && Objects.equals(porta, camera.porta) && Objects.equals(usuario, camera.usuario) && Objects.equals(senha, camera.senha) && Objects.equals(usuarioId, camera.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, marca, ip, porta, usuario, senha, usuarioId);
    }
}
