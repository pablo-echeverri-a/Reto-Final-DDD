package co.com.sofkau.training.ddd.reto.factura.identities;

import co.com.sofka.domain.generic.Identity;

public class ManoObraId extends Identity {
    public ManoObraId(String id){
        super(id);
    }

    public ManoObraId() {
    }

    public static ManoObraId of(String id) {
        return new ManoObraId(id);
    }
}
