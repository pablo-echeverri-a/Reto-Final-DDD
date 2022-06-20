package co.com.sofkau.training.ddd.reto.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;

public class ChangedEspecialidadCommand extends Command {
    private final Especialidad especialidad;

    public ChangedEspecialidadCommand(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
