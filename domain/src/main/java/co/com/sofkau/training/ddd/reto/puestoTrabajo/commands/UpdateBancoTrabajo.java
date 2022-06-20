package co.com.sofkau.training.ddd.reto.puestoTrabajo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.PuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;

public class UpdateBancoTrabajo extends Command {
    private final BancoTrabajoId bancoTrabajoId;
    private final NumeroBanco NumeroBanco;
    private final Sector sector;

    public UpdateBancoTrabajo(BancoTrabajoId bancoTrabajoId, co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco numeroBanco, Sector sector) {
        this.bancoTrabajoId = bancoTrabajoId;
        NumeroBanco = numeroBanco;
        this.sector = sector;
    }

    public BancoTrabajoId getBancoTrabajoId() {
        return bancoTrabajoId;
    }

    public co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco getNumeroBanco() {
        return NumeroBanco;
    }

    public Sector getSector() {
        return sector;
    }
}
