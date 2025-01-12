package com.miqueias.r.camera_servico.domain;

import com.miqueias.r.camera_servico.utils.enumerate.Dia;
import com.miqueias.r.camera_servico.utils.enumerate.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;


@Entity
@Table(name = "tb_monitoramentos", schema = "public")
public class Monitoramento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Dia dia;
    @ManyToOne
    @JoinColumn(name = "camera_id", nullable = false)
    private Camera camera;
    @Column(nullable = false)
    private LocalTime horaInicio;
    @Column(nullable = false)
    private LocalTime horaFim;

    public Monitoramento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
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
        Monitoramento that = (Monitoramento) o;
        return Objects.equals(id, that.id) && dia == that.dia && Objects.equals(camera, that.camera) && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFim, that.horaFim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, camera, horaInicio, horaFim);
    }
}
