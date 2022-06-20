package co.com.sofkau.training.ddd.reto.cliente.identities;

import co.com.sofka.domain.generic.Identity;

public class UsuarioId extends Identity {
    public UsuarioId(String id){
        super(id);
    }

    public UsuarioId() {
    }

    public static UsuarioId of(String id) {
        return new UsuarioId(id);
    }
}
