package co.com.sofkau.training.ddd.reto.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;

public class ChangeEspecialidadCommand extends Command {
    private final FacturaId facturaId;
    private final MecanicoId mecanicoId;
    private final Especialidad especialidad;

    public ChangeEspecialidadCommand(FacturaId facturaId, MecanicoId mecanicoId, Especialidad especialidad) {
        this.facturaId = facturaId;
        this.mecanicoId = mecanicoId;
        this.especialidad = especialidad;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
