package co.com.sofkau.training.ddd.reto.factura.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

public class CreateFacturaCommand extends Command {
    private FacturaId facturaId;
    private final Horas horas;
    private final Costo costo;

    public CreateFacturaCommand(FacturaId facturaId, Horas horas, Costo costo) {
        this.facturaId = facturaId;
        this.horas = horas;
        this.costo = costo;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Horas getHoras() {
        return horas;
    }

    public Costo getCosto() {
        return costo;
    }
}
