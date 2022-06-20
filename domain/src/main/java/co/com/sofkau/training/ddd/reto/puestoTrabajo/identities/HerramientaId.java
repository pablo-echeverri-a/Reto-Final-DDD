package co.com.sofkau.training.ddd.reto.puestoTrabajo.identities;

import co.com.sofka.domain.generic.Identity;

public class HerramientaId extends Identity {
    private HerramientaId(String value) {
        super(value);
    }

    public HerramientaId(){ }

    public static HerramientaId of(String value) {
        return new HerramientaId(value);
    }
}
