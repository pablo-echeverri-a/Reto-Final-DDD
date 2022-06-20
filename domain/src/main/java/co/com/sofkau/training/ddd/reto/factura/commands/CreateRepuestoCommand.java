package co.com.sofkau.training.ddd.reto.factura.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.factura.RepuestoFactory;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;

public class CreateRepuestoCommand extends Command {
    private final RepuestoFactory repuestoFactory;
    private final FacturaId facturaId;

    public CreateRepuestoCommand(RepuestoFactory repuestoFactory, FacturaId facturaId) {
        this.repuestoFactory = repuestoFactory;
        this.facturaId = facturaId;
    }

    public RepuestoFactory getRepuestoFactory() {
        return repuestoFactory;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
