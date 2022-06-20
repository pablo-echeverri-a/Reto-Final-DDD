package co.com.sofkau.training.ddd.reto.puestoTrabajo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.HerramientaFactory;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;

public class CreateHerramientaCommand extends Command {
    private final HerramientaFactory herramientaFactory;
    private final PuestoTrabajoId puestoTrabajoId;

    public CreateHerramientaCommand(HerramientaFactory herramientaFactory, PuestoTrabajoId puestoTrabajoId) {
        this.herramientaFactory = herramientaFactory;
        this.puestoTrabajoId = puestoTrabajoId;
    }

    public HerramientaFactory getHerramientaFactory() {
        return herramientaFactory;
    }

    public PuestoTrabajoId getPuestoTrabajoId() {
        return puestoTrabajoId;
    }
}
