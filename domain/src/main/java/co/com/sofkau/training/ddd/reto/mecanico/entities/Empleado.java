package co.com.sofkau.training.ddd.reto.mecanico.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class Empleado extends Entity<EmpleadoId> {
    private NombrePersona nombrePersona;
    private DocumentoIdentidad documentoIdentidad;
    private Activo activo;
    private Codigo codigo;

    public Empleado(EmpleadoId entityId) {
        super(entityId);
    }

    public Empleado(EmpleadoId entityId, NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo, Codigo codigo) {
        super(entityId);
        this.nombrePersona = nombrePersona;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
        this.codigo = codigo;
    }

    public void actualizarEmpleado(Empleado empleado){
        this.nombrePersona = empleado.nombrePersona;
        this.documentoIdentidad = empleado.documentoIdentidad;
        this.activo = empleado.activo;
        this.codigo = empleado.codigo;
    }
}
