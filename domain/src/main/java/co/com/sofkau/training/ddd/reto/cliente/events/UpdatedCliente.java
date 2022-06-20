package co.com.sofkau.training.ddd.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.entities.Usuario;
import co.com.sofkau.training.ddd.reto.cliente.entities.Vehiculo;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;

public class UpdatedCliente extends DomainEvent {
    private final ClienteId clienteId;
    private final Usuario usuario;
    private final Vehiculo vehiculo;
    private final ServicioRMId servicioRMId;

    public UpdatedCliente(ClienteId clienteId, Usuario usuario, Vehiculo vehiculo, ServicioRMId servicioRMId){
        super("co.com.sofkau.training.ddd.reto.cliente.events.UpdatedCliente");

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
