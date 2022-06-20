package co.com.sofkau.training.ddd.reto.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;

public class ChangedEspecialidadCommand extends Command {
    private final MecanicoId mecanicoId;
    private final Especialidad especialidad;

    public ChangedEspecialidadCommand(MecanicoId mecanicoId, Especialidad especialidad) {
        this.mecanicoId = mecanicoId;
        this.especialidad = especialidad;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
