package com.miqueias.r.camera_servico.domain.dto.detalhe;

import com.miqueias.r.camera_servico.domain.Camera;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class DetalheDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    private Camera camera;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalheDTO that = (DetalheDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(camera, that.camera) && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFim, that.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, camera, horaInicio, horaFim);
    }
}
