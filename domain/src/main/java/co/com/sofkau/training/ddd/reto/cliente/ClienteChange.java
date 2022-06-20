package co.com.sofkau.training.ddd.reto.cliente;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.training.ddd.reto.cliente.entities.Usuario;
import co.com.sofkau.training.ddd.reto.cliente.entities.Vehiculo;
import co.com.sofkau.training.ddd.reto.cliente.events.CreatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedUsuario;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedVehiculo;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente){
        apply((CreatedCliente event) -> {
            cliente.vehiculo = null;
            cliente.servicioRMId = null;
            cliente.usuario = new Usuario(event.getUsuarioId(), event.getNombre(), event.
                    getDocumentoIdentidad(), event.getActivo());
        });

        apply((UpdatedUsuario event)->{

            var usuarioId = event.getUsuarioId();
            var usuario = new Usuario(usuarioId, event.getNombrePersona(), event.getDocumentoIdentidad(),
                    event.getActivo());

            cliente.usuario.actualizarUsuario(usuario);
        });

        apply((UpdatedVehiculo event)->{

            var vehiculoId = event.getVehiculoId();
            var vehiculo = new Vehiculo(vehiculoId, event.getTipoVehiculo(), event.getMarca(),
                    event.getLinea(), event.getModelo(), event.getPlaca());

            cliente.vehiculo.actualizarVehiculo(vehiculo);
        });

    }
}
