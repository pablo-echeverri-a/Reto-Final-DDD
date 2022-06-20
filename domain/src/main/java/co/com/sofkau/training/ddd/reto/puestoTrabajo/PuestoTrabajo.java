package co.com.sofkau.training.ddd.reto.puestoTrabajo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.entities.BancoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.entities.Herramienta;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.CreatedPuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.HerramientaAdded;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.UpdatedBancoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;

import java.util.List;

public class PuestoTrabajo extends AggregateEvent<PuestoTrabajoId> {
    protected BancoTrabajo bancoTrabajo;
    protected List<Herramienta> herramientas;

    public PuestoTrabajo(PuestoTrabajoId id, BancoTrabajoId bancoTrabajoId, NumeroBanco numeroBanco, Sector sector){
        super(id);
        subscribe(new PuestoTrabajoChange(this));
        appendChange(new CreatedPuestoTrabajo(bancoTrabajoId, numeroBanco, sector)).apply();
    }

    public PuestoTrabajo(PuestoTrabajoId entityId) {
        super(entityId);
        subscribe(new PuestoTrabajoChange(this));
    }

    public static PuestoTrabajo from(PuestoTrabajoId id, List<DomainEvent> events) {
        var puestoTrabajo = new PuestoTrabajo(id);
        events.forEach(puestoTrabajo::applyEvent);
        return puestoTrabajo;
    }

    public void updateBancoTrabajo(BancoTrabajoId bancoTrabajoId, NumeroBanco numeroBanco, Sector sector){
        appendChange(new UpdatedBancoTrabajo(bancoTrabajoId, numeroBanco, sector)).apply();
    }

    public void addHerramienta(HerramientaFactory herramientaFactory){
        herramientaFactory.herramientas()
                .forEach(herramienta ->
                        appendChange(
                                new HerramientaAdded(herramienta.identity(),  herramienta.nombreHerramienta(),
                                        herramienta.descripcion())).apply()
                );
    }

}
