package co.com.sofkau.training.ddd.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.entities.ManoObra;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

public class CreatedFactura extends DomainEvent {
    private final ManoObraId manoObraId;
    private final Horas horas;
    private final Costo costo;

    public CreatedFactura(ManoObraId manoObraId, Horas horas, Costo costo){
        super("co.com.sofkau.training.ddd.reto.factura.events.CreatedFactura");
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
