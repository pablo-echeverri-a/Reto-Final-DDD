package co.com.sofkau.training.ddd.reto.puestoTrabajo.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;

public class BancoTrabajo extends Entity<BancoTrabajoId> {
    private NumeroBanco numeroBanco;
    private Sector sector;

    public BancoTrabajo(BancoTrabajoId entityId) {
        super(entityId);
    }

    public BancoTrabajo(BancoTrabajoId entityId, NumeroBanco numeroBanco, Sector sector) {
        super(entityId);
        this.numeroBanco = numeroBanco;
        this.sector = sector;
    }

    public void actualizarBancoTrabajo(BancoTrabajo bancoTrabajo){
        this.numeroBanco = bancoTrabajo.numeroBanco;
        this.sector = bancoTrabajo.sector;
    }
}
