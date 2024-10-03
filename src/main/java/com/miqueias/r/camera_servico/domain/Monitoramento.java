package com.miqueias.r.camera_servico.domain;

import com.miqueias.r.camera_servico.utils.enumerate.Dia;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
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
    @JoinColumn(name = "detalhe_id", nullable = false)
    private Detalhe detalhe;

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

    public Detalhe getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(Detalhe detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monitoramento that = (Monitoramento) o;
        return Objects.equals(id, that.id) && dia == that.dia && Objects.equals(detalhe, that.detalhe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, detalhe);
    }
}
