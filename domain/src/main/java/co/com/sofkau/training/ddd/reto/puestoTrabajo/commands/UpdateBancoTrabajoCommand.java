package co.com.sofkau.training.ddd.reto.puestoTrabajo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;

public class UpdateBancoTrabajoCommand extends Command {
    private final PuestoTrabajoId puestoTrabajoId;
    private final BancoTrabajoId bancoTrabajoId;
    private final NumeroBanco numeroBanco;
    private final Sector sector;

    public UpdateBancoTrabajoCommand(PuestoTrabajoId puestoTrabajoId, BancoTrabajoId bancoTrabajoId, co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco numeroBanco, Sector sector) {
        this.puestoTrabajoId = puestoTrabajoId;
        this.bancoTrabajoId = bancoTrabajoId;
        this.numeroBanco = numeroBanco;
        this.sector = sector;
    }

    public PuestoTrabajoId getPuestoTrabajoId() {
        return puestoTrabajoId;
    }

    public BancoTrabajoId getBancoTrabajoId() {
        return bancoTrabajoId;
    }

    public co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco getNumeroBanco() {
        return numeroBanco;
    }

    public Sector getSector() {
        return sector;
    }
}
