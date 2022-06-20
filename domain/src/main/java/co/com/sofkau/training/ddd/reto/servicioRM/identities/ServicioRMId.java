package co.com.sofkau.training.ddd.reto.servicioRM.identities;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;

public class ServicioRMId extends Identity {
    public ServicioRMId(String id){
        super(id);
    }

    public ServicioRMId() {
    }

    public static ServicioRMId of(String id) {
        return new ServicioRMId(id);
    }
}
