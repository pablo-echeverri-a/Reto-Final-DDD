package co.com.sofkau.training.ddd.reto.puestoTrabajo;

import co.com.sofkau.training.ddd.reto.puestoTrabajo.entities.Herramienta;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.HerramientaId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Descripcion;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NombreHerramienta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HerramientaFactory {
    private final List<Herramienta> herramientas;
    private static HerramientaFactory instance;

    public HerramientaFactory() {
        herramientas = new ArrayList<>();
    }

    public static HerramientaFactory getInstance(){
        if(Objects.isNull(instance)){
            instance = new HerramientaFactory();
            return instance;
        }
        return instance;
    }

    public HerramientaFactory add(HerramientaId herramientaId, NombreHerramienta nombreHerramienta, Descripcion descripcion){
        herramientas.add(new Herramienta(herramientaId, nombreHerramienta, descripcion));
        return this;
    }

    protected List<Herramienta> herramientas() {
        return herramientas;
    }
}
