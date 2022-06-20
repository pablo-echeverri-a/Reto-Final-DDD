package co.com.sofkau.training.ddd.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

public class UpdatedManoObra extends DomainEvent {
    private final ManoObraId manoObraId;
    private final Horas horas;
    private final Costo costo;

    public UpdatedManoObra(ManoObraId manoObraId, Horas horas, Costo costo){
        super("co.com.sofkau.training.ddd.reto.factura.events.UpdatedManoObra");

        this.manoObraId = manoObraId;
        this.horas = horas;
        this.costo = costo;
    }

    public ManoObraId getManoObraId() {
        return manoObraId;
    }

    public Horas getHoras() {
        return horas;
    }

    public Costo getCosto() {
        return costo;
    }
}
