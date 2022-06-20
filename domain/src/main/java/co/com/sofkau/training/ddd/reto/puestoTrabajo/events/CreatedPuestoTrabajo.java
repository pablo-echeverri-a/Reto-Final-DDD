package co.com.sofkau.training.ddd.reto.puestoTrabajo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;

public class CreatedPuestoTrabajo extends DomainEvent {
    private final BancoTrabajoId bancoTrabajoId;
    private final NumeroBanco numeroBanco;
    private final Sector sector;

    public CreatedPuestoTrabajo(BancoTrabajoId bancoTrabajoId, NumeroBanco numeroBanco, Sector sector){
        super("co.com.sofkau.training.ddd.reto.puestoTrabajo.events.CreatedPuestoTrabajo");
        this.bancoTrabajoId = bancoTrabajoId;
        this.numeroBanco = numeroBanco;
        this.sector = sector;
    }

    public BancoTrabajoId getBancoTrabajoId() {
        return bancoTrabajoId;
    }

    public NumeroBanco getNumeroBanco() {
        return numeroBanco;
    }

    public Sector getSector() {
        return sector;
    }
}
