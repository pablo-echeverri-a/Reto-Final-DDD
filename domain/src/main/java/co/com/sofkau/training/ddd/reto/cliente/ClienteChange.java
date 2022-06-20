package co.com.sofkau.training.ddd.reto.cliente;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.training.ddd.reto.cliente.entities.Usuario;
import co.com.sofkau.training.ddd.reto.cliente.entities.Vehiculo;
import co.com.sofkau.training.ddd.reto.cliente.events.CreatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedUsuario;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedVehiculo;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.cliente.identities.VehiculoId;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente){
        apply((CreatedCliente event) -> {
            cliente.vehiculo = new Vehiculo(new VehiculoId());
            cliente.servicioRMId = new ServicioRMId();
            cliente.usuario = new Usuario(event.getUsuarioId(), event.getNombre(), event.
                    getDocumentoIdentidad(), event.getActivo());
        });

        apply((UpdatedUsuario event)->{
            cliente.usuario = new Usuario(new UsuarioId());

            var usuarioId = event.getUsuarioId();
            var usuario = new Usuario(usuarioId, event.getNombrePersona(), event.getDocumentoIdentidad(),
                    event.getActivo());

            cliente.usuario.actualizarUsuario(usuario);
        });

        apply((UpdatedVehiculo event)->{
            cliente.vehiculo = new Vehiculo(new VehiculoId());

            var vehiculoId = event.getVehiculoId();
            var vehiculo = new Vehiculo(vehiculoId, event.getTipoVehiculo(), event.getMarca(),
                    event.getLinea(), event.getModelo(), event.getPlaca());

            cliente.vehiculo.actualizarVehiculo(vehiculo);
        });

    }
}
