package co.com.sofkau.training.ddd.reto.servicioRM.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.servicioRM.ServicioRM;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;

public class UpdateNombreServicioCommand extends Command {
    private final ServicioRMId servicioRMId;
    private final NombreServicio nombreServicio;

    public UpdateNombreServicioCommand(ServicioRMId servicioRMId, NombreServicio nombreServicio) {
        this.servicioRMId = servicioRMId;
        this.nombreServicio = nombreServicio;
    }

    public ServicioRMId getServicioRMId() {
        return servicioRMId;
    }

    public NombreServicio getNombreServicio() {
        return nombreServicio;
    }
}
