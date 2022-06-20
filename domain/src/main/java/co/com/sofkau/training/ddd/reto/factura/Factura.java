package co.com.sofkau.training.ddd.reto.factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.entities.ManoObra;
import co.com.sofkau.training.ddd.reto.factura.entities.Repuesto;
import co.com.sofkau.training.ddd.reto.factura.events.CreatedFactura;
import co.com.sofkau.training.ddd.reto.factura.events.RepuestoAdded;
import co.com.sofkau.training.ddd.reto.factura.events.UpdatedManoObra;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

import java.util.List;

public class Factura extends AggregateEvent<FacturaId> {
    protected ManoObra manoObra;
    protected List<Repuesto> repuestos;

    public Factura(FacturaId id, ManoObraId manoObraId, Horas horas, Costo costo){
        super(id);
        subscribe(new FacturaChange(this));
        appendChange(new CreatedFactura(manoObraId, horas, costo)).apply();
    }

    public Factura(FacturaId entityId) {
        super(entityId);
        subscribe(new FacturaChange(this));
    }

    public static Factura from(FacturaId id, List<DomainEvent> events) {
        var factura = new Factura(id);
        events.forEach(factura::applyEvent);
        return factura;
    }

    public void updateManoObra(ManoObraId manoObraId, Horas horas, Costo costo){
        appendChange(new UpdatedManoObra(manoObraId, horas, costo)).apply();
    }

    public void addRepuesto(RepuestoFactory repuestoFactory){
        repuestoFactory.repuestos()
                .forEach(repuesto ->
                        appendChange(
                                new RepuestoAdded(repuesto.identity(),  repuesto.nombreRepuesto(),
                                        repuesto.costo())).apply()
                );
    }
}
