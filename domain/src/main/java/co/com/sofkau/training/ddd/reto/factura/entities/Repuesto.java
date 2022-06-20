package co.com.sofkau.training.ddd.reto.factura.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.factura.identities.RepuestoId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.NombreRepuesto;

public class Repuesto extends Entity<RepuestoId> {
    private NombreRepuesto nombreRepuesto;
    private Costo costo;

    public Repuesto(RepuestoId entityId) {
        super(entityId);
    }

    public Repuesto(RepuestoId entityId, NombreRepuesto nombreRepuesto, Costo costo) {
        super(entityId);
        this.nombreRepuesto = nombreRepuesto;
        this.costo = costo;
    }

    public void actualizarRepuesto(Repuesto repuesto){
        this.nombreRepuesto = repuesto.nombreRepuesto;
        this.costo = repuesto.costo;
    }

    public NombreRepuesto nombreRepuesto() {
        return nombreRepuesto;
    }

    public Costo costo() {
        return costo;
    }
}
