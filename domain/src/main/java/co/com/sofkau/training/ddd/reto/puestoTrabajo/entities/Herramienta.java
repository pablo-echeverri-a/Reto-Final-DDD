package co.com.sofkau.training.ddd.reto.puestoTrabajo.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.NombreRepuesto;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.HerramientaId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Descripcion;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NombreHerramienta;

public class Herramienta extends Entity<HerramientaId> {
    private NombreHerramienta nombreHerramienta;
    private Descripcion descripcion;

    public Herramienta(HerramientaId entityId) {
        super(entityId);
    }

    public Herramienta(HerramientaId entityId, NombreHerramienta nombreHerramienta, Descripcion descripcion) {
        super(entityId);
        this.nombreHerramienta = nombreHerramienta;
        this.descripcion = descripcion;
    }

    public void actualizarHerramienta(Herramienta herramienta){
        this.nombreHerramienta = herramienta.nombreHerramienta;
        this.descripcion = herramienta.descripcion;
    }

    public NombreHerramienta nombreHerramienta() {
        return nombreHerramienta;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
