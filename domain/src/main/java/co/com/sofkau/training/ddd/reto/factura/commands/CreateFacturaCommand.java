package co.com.sofkau.training.ddd.reto.factura.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

public class CreateFacturaCommand extends Command {
    private final Horas horas;
    private final Costo costo;

    public CreateFacturaCommand(Horas horas, Costo costo) {
        this.horas = horas;
        this.costo = costo;
    }

    public Horas getHoras() {
        return horas;
    }

    public Costo getCosto() {
        return costo;
    }
}
