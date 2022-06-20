package co.com.sofkau.training.ddd.reto.puestoTrabajo.identities;

import co.com.sofka.domain.generic.Identity;

public class BancoTrabajoId extends Identity {
    public BancoTrabajoId(String id){
        super(id);
    }

    public BancoTrabajoId() {
    }

    public static BancoTrabajoId of(String id) {
        return new BancoTrabajoId(id);
    }
}
