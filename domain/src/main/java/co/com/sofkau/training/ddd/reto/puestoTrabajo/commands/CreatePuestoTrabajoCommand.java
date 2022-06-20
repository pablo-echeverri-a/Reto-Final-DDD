package co.com.sofkau.training.ddd.reto.puestoTrabajo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;

public class CreatePuestoTrabajoCommand extends Command {
    private final BancoTrabajoId bancoTrabajoId;
    private final NumeroBanco numeroBanco;
    private final Sector sector;

    public CreatePuestoTrabajoCommand(BancoTrabajoId bancoTrabajoId, NumeroBanco numeroBanco, Sector sector) {
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
