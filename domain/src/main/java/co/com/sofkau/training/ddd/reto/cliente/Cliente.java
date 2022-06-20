package co.com.sofkau.training.ddd.reto.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.entities.Usuario;
import co.com.sofkau.training.ddd.reto.cliente.entities.Vehiculo;
import co.com.sofkau.training.ddd.reto.cliente.events.CreatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedUsuario;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedVehiculo;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.cliente.identities.VehiculoId;
import co.com.sofkau.training.ddd.reto.cliente.values.*;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {
    protected Usuario usuario;
    protected Vehiculo vehiculo;
    protected ServicioRMId servicioRMId;

    public Cliente(ClienteId id, UsuarioId usuarioId, NombrePersona nombre, DocumentoIdentidad documentoIdentidad, Activo activo) {
        super(id);
        subscribe(new ClienteChange(this));
        appendChange(new CreatedCliente(usuarioId, nombre, documentoIdentidad, activo)).apply();
    }

    public Cliente(ClienteId entityId) {
        super(entityId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId id, List<DomainEvent> events) {
        var cliente = new Cliente(id);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void updateUsuario(UsuarioId usuarioId, NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo){
        appendChange(new UpdatedUsuario(usuarioId, nombrePersona, documentoIdentidad, activo)).apply();
    }

    public void updateVehiculo(VehiculoId vehiculoId, TipoVehiculo tipoVehiculo, Marca marca, Linea linea, Modelo modelo, Placa placa){
        appendChange(new UpdatedVehiculo(vehiculoId, tipoVehiculo, marca, linea, modelo, placa)).apply();
    }
}
