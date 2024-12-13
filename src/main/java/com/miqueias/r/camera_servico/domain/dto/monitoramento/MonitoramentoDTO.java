package com.miqueias.r.camera_servico.domain.dto.monitoramento;

import com.miqueias.r.camera_servico.domain.Detalhe;
import com.miqueias.r.camera_servico.utils.enumerate.Dia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class MonitoramentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private Dia dia;
    private Detalhe detalhe;

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
        MonitoramentoDTO that = (MonitoramentoDTO) o;
        return Objects.equals(id, that.id) && dia == that.dia && Objects.equals(detalhe, that.detalhe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, detalhe);
    }
}
