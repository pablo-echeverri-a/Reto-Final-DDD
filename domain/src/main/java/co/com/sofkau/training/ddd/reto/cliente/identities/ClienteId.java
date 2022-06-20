package co.com.sofkau.training.ddd.reto.cliente.identities;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(String id){
        super(id);
    }

    public ClienteId() {
    }

    public static ClienteId of(String id) {
        return new ClienteId(id);
    }
}
