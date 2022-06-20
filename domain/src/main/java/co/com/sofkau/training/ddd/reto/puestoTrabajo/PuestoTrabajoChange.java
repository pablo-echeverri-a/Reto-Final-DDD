package co.com.sofkau.training.ddd.reto.puestoTrabajo;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.entities.BancoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.entities.Herramienta;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.CreatedPuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.HerramientaAdded;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.UpdatedBancoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;

import java.util.ArrayList;

public class PuestoTrabajoChange extends EventChange {
    public PuestoTrabajoChange(PuestoTrabajo puestoTrabajo){
        apply((CreatedPuestoTrabajo event) -> {
            puestoTrabajo.herramientas = new ArrayList<>();
            puestoTrabajo.bancoTrabajo = new BancoTrabajo(event.getBancoTrabajoId(), event.getNumeroBanco(),
                    event.getSector());
        });

        apply((UpdatedBancoTrabajo event)->{
            puestoTrabajo.bancoTrabajo = new BancoTrabajo(new BancoTrabajoId());
            var bancoTrabajo = new BancoTrabajo(event.getBancoTrabajoId(), event.getNumeroBanco(),
                    event.getSector());

            puestoTrabajo.bancoTrabajo.actualizarBancoTrabajo(bancoTrabajo);
        });

        apply((HerramientaAdded event) -> {
            puestoTrabajo.herramientas.add(new Herramienta(event.getHerramientaId(), event.getNombreHerramienta(),
                    event.getDescripcion()));
        });
    }
}
