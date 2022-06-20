package co.com.sofkau.training.ddd.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.cliente.entities.Usuario;
import co.com.sofkau.training.ddd.reto.cliente.entities.Vehiculo;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;

public class UpdateClienteCommand extends Command {
    private final ClienteId clienteId;
    private final Usuario usuario;
    private final Vehiculo vehiculo;
    private final ServicioRMId servicioRMId;

    public UpdateClienteCommand(ClienteId clienteId, Usuario usuario, Vehiculo vehiculo, ServicioRMId servicioRMId) {
        this.clienteId = clienteId;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.servicioRMId = servicioRMId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ServicioRMId getServicioRMId() {
        return servicioRMId;
    }
}
