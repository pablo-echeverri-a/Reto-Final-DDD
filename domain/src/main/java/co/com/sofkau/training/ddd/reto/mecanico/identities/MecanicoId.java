package co.com.sofkau.training.ddd.reto.mecanico.identities;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;

public class MecanicoId extends Identity {
    public MecanicoId(String id){
        super(id);
    }

    public MecanicoId() {
    }

    public static MecanicoId of(String id) {
        return new MecanicoId(id);
    }
}
