package co.com.sofkau.training.ddd.reto.factura;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.training.ddd.reto.cliente.Cliente;
import co.com.sofkau.training.ddd.reto.cliente.entities.Usuario;
import co.com.sofkau.training.ddd.reto.cliente.entities.Vehiculo;
import co.com.sofkau.training.ddd.reto.cliente.events.CreatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedUsuario;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedVehiculo;
import co.com.sofkau.training.ddd.reto.factura.entities.ManoObra;
import co.com.sofkau.training.ddd.reto.factura.entities.Repuesto;
import co.com.sofkau.training.ddd.reto.factura.events.CreatedFactura;
import co.com.sofkau.training.ddd.reto.factura.events.RepuestoAdded;
import co.com.sofkau.training.ddd.reto.factura.events.UpdatedManoObra;

public class FacturaChange extends EventChange {
    public FacturaChange(Factura factura){
        apply((CreatedFactura event) -> {
            factura.repuestos = null;
            factura.manoObra = new ManoObra(event.getManoObraId(), event.getHoras(), event.getCosto());
        });

        apply((UpdatedManoObra event)->{

            var manoObra = new ManoObra(event.getManoObraId(), event.getHoras(), event.getCosto());

            factura.manoObra.actualizarManoObra(manoObra);
        });

        apply((RepuestoAdded event) -> {
            factura.repuestos.add(new Repuesto(event.getRepuestoId(), event.getNombreRepuesto(), event.getCosto()));
        });
    }
}
