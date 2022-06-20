package co.com.sofkau.training.ddd.reto.cliente.identities;

import co.com.sofka.domain.generic.Identity;

public class VehiculoId extends Identity {
    public VehiculoId(String id){
        super(id);
    }

    public VehiculoId() {
    }

    public static VehiculoId of(String id) {
        return new VehiculoId(id);
    }
}
