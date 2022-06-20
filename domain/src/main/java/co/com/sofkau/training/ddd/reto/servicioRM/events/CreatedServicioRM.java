package co.com.sofkau.training.ddd.reto.servicioRM.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;

public class CreatedServicioRM extends DomainEvent {
    private final FacturaId facturaId;
    private final PuestoTrabajoId puestoTrabajoId;
    private final MecanicoId mecanicoId;
    private final NombreServicio nombreServicio;

    public CreatedServicioRM(FacturaId facturaId, PuestoTrabajoId puestoTrabajoId,
                             MecanicoId mecanicoId, NombreServicio nombreServicio){
        super("co.com.sofkau.training.ddd.reto.servicioRM.events.CreatedServicioRM");
        this.facturaId = facturaId;
        this.puestoTrabajoId = puestoTrabajoId;
        this.mecanicoId = mecanicoId;
        this.nombreServicio = nombreServicio;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public PuestoTrabajoId getPuestoTrabajoId() {
        return puestoTrabajoId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public NombreServicio getNombreServicio() {
        return nombreServicio;
    }
}
