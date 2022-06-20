package co.com.sofkau.training.ddd.reto.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;

public class ChangedEspecialidad extends DomainEvent {
    private final Especialidad especialidad;

    public ChangedEspecialidad(Especialidad especialidad) {
        super("co.com.sofkau.training.ddd.reto.mecanico.events.ChangedEspecialidad");
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
