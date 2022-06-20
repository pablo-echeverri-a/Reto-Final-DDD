package co.com.sofkau.training.ddd.reto.servicioRM;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.training.ddd.reto.servicioRM.events.CreatedServicioRM;
import co.com.sofkau.training.ddd.reto.servicioRM.events.UpdatedNombreServicio;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;

public class ServicioRMChange extends EventChange {
    public ServicioRMChange(ServicioRM servicioRM) {
        apply((CreatedServicioRM event) -> {
            servicioRM.puestoTrabajoId = event.getPuestoTrabajoId();
            servicioRM.mecanicoId = event.getMecanicoId();
            servicioRM.facturaId = event.getFacturaId();
            servicioRM.nombreServicio = new NombreServicio(event.getNombreServicio().value());
        });

        apply((UpdatedNombreServicio event) -> {
            var nombreServicio = new NombreServicio(event.getNombreServicio());

            servicioRM.nombreServicio = nombreServicio;
        });
    }
}
