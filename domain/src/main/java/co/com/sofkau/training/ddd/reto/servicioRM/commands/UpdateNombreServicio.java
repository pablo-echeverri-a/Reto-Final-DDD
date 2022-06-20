package co.com.sofkau.training.ddd.reto.servicioRM.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;

public class UpdateNombreServicio extends Command {
    private final NombreServicio nombreServicio;

    public UpdateNombreServicio(NombreServicio nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public NombreServicio getNombreServicio() {
        return nombreServicio;
    }
}
