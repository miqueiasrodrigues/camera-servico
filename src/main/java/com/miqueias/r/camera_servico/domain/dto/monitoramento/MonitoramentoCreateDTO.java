package com.miqueias.r.camera_servico.domain.dto.monitoramento;

import com.miqueias.r.camera_servico.utils.enumerate.Dia;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class MonitoramentoCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Dia dia;
    private Long detalheId;

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Long getDetalheId() {
        return detalheId;
    }

    public void setDetalheId(Long detalheId) {
        this.detalheId = detalheId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitoramentoCreateDTO that = (MonitoramentoCreateDTO) o;
        return dia == that.dia && Objects.equals(detalheId, that.detalheId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, detalheId);
    }
}
