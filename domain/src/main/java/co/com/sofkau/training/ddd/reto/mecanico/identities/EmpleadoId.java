package co.com.sofkau.training.ddd.reto.mecanico.identities;

import co.com.sofka.domain.generic.Identity;

public class EmpleadoId extends Identity {
    public EmpleadoId(String id){
        super(id);
    }

    public EmpleadoId() {
    }

    public static EmpleadoId of(String id) {
        return new EmpleadoId(id);
    }
}
