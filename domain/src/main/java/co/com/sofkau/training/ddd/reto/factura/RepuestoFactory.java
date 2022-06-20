package co.com.sofkau.training.ddd.reto.factura;

import co.com.sofkau.training.ddd.reto.factura.entities.Repuesto;
import co.com.sofkau.training.ddd.reto.factura.identities.RepuestoId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.NombreRepuesto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepuestoFactory {
    private final List<Repuesto> repuestos;
    private static  RepuestoFactory instance;

    public RepuestoFactory() {
        repuestos = new ArrayList<>();
    }

    public static RepuestoFactory getInstance(){
        if(Objects.isNull(instance)){
            instance = new RepuestoFactory();
            return instance;
        }
        return instance;
    }

    public RepuestoFactory add(RepuestoId repuestoId, NombreRepuesto nombreRepuesto, Costo costo){
        repuestos.add(new Repuesto(repuestoId, nombreRepuesto, costo));
        return this;
    }

    protected List<Repuesto> repuestos() {
        return repuestos;
    }
}
