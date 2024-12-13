package com.miqueias.r.camera_servico.domain.dto.detalhe;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class DetalheCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long cameraId;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Long getCameraId() {
        return cameraId;
    }

    public void setCameraId(Long cameraId) {
        this.cameraId = cameraId;
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
        DetalheCreateDTO that = (DetalheCreateDTO) o;
        return Objects.equals(cameraId, that.cameraId) && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFim, that.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cameraId, horaInicio, horaFim);
    }
}
