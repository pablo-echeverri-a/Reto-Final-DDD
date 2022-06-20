package co.com.sofkau.training.ddd.reto.servicioRM;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.servicioRM.events.CreatedServicioRM;
import co.com.sofkau.training.ddd.reto.servicioRM.events.UpdatedNombreServicio;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;

import java.util.List;

public class ServicioRM extends AggregateEvent<ServicioRMId> {
    protected FacturaId facturaId;
    protected PuestoTrabajoId puestoTrabajoId;
    protected MecanicoId mecanicoId;
    protected NombreServicio nombreServicio;

    public ServicioRM(ServicioRMId servicioRMId, FacturaId facturaId, PuestoTrabajoId puestoTrabajoId,
                      MecanicoId mecanicoId, NombreServicio nombreServicio){
        super(servicioRMId);
        subscribe(new ServicioRMChange(this));
        appendChange(new CreatedServicioRM(facturaId, puestoTrabajoId, mecanicoId, nombreServicio)).apply();
    }

    public ServicioRM(ServicioRMId entityId) {
        super(entityId);
        subscribe(new ServicioRMChange(this));
    }

    public static ServicioRM from(ServicioRMId id, List<DomainEvent> events) {
        var servicioRM = new ServicioRM(id);
        events.forEach(servicioRM::applyEvent);
        return servicioRM;
    }

    public void updateNombreServicio(NombreServicio nombreServicio){
        appendChange(new UpdatedNombreServicio(nombreServicio.value())).apply();
    }
}
