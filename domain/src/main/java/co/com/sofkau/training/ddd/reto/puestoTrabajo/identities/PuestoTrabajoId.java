package co.com.sofkau.training.ddd.reto.puestoTrabajo.identities;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;

public class PuestoTrabajoId extends Identity {
    public PuestoTrabajoId(String id){
        super(id);
    }

    public PuestoTrabajoId() {
    }

    public static PuestoTrabajoId of(String id) {
        return new PuestoTrabajoId(id);
    }
}
