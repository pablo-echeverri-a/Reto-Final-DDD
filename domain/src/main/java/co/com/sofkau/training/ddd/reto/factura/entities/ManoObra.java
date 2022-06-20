package co.com.sofkau.training.ddd.reto.factura.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

public class ManoObra extends Entity<ManoObraId> {
    private Horas horas;
    private Costo costo;

    public ManoObra(ManoObraId entityId) {
        super(entityId);
    }

    public ManoObra(ManoObraId entityId, Horas horas, Costo costo) {
        super(entityId);
        this.horas = horas;
        this.costo = costo;
    }

    public void actualizarManoObra(ManoObra manoObra){
        this.horas = manoObra.horas;
        this.costo = manoObra.costo;

    }
}
