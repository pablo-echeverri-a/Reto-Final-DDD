package co.com.sofkau.training.ddd.reto.factura.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;

public class UpdateManoObraCommand extends Command {
    private final FacturaId facturaId;
    private final ManoObraId manoObraId;
    private final Horas horas;
    private final Costo costo;

    public UpdateManoObraCommand(FacturaId facturaId, ManoObraId manoObraId, Horas horas, Costo costo) {
        this.facturaId = facturaId;
        this.manoObraId = manoObraId;
        this.horas = horas;
        this.costo = costo;
    }

    public FacturaId getFacturaId() {
        return facturaId;
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
