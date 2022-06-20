package co.com.sofkau.training.ddd.reto.puestoTrabajo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.RepuestoId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.NombreRepuesto;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.HerramientaId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Descripcion;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NombreHerramienta;

public class HerramientaAdded extends DomainEvent {
    private final HerramientaId herramientaId;
    private final NombreHerramienta nombreHerramienta;
    private final Descripcion descripcion;

    public HerramientaAdded(HerramientaId herramientaId, NombreHerramienta nombreHerramienta, Descripcion descripcion){
        super("co.com.sofkau.training.ddd.reto.factura.events.HerramientaAdded");

        this.herramientaId = herramientaId;
        this.nombreHerramienta = nombreHerramienta;
        this.descripcion = descripcion;
    }

    public HerramientaId getHerramientaId() {
        return herramientaId;
    }

    public NombreHerramienta getNombreHerramienta() {
        return nombreHerramienta;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
