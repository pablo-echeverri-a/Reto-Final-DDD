package co.com.sofkau.training.ddd.reto.factura.identities;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;

public class FacturaId extends Identity {
    public FacturaId(String id){
        super(id);
    }

    public FacturaId() {
    }

    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
}
