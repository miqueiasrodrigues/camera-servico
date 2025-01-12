package com.miqueias.r.camera_servico.domain.dto.monitoramento;

import com.miqueias.r.camera_servico.utils.enumerate.Dia;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class MonitoramentoCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Dia dia;
    private Long cameraId;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

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
}
