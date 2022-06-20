package co.com.sofkau.training.ddd.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.identities.RepuestoId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;
import co.com.sofkau.training.ddd.reto.factura.values.NombreRepuesto;

public class RepuestoAdded extends DomainEvent {
    private final RepuestoId repuestoId;
    private final NombreRepuesto nombreRepuesto;
    private final Costo costo;

    public RepuestoAdded(RepuestoId repuestoId, NombreRepuesto nombreRepuesto, Costo costo){
        super("co.com.sofkau.training.ddd.reto.factura.events.RepuestoAdded");

        this.repuestoId = repuestoId;
        this.nombreRepuesto = nombreRepuesto;
        this.costo = costo;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public NombreRepuesto getNombreRepuesto() {
        return nombreRepuesto;
    }

    public Costo getCosto() {
        return costo;
    }
}
