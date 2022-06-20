package co.com.sofkau.training.ddd.reto.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class CreatedMecanico extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final NombrePersona nombre;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;
    private final Codigo codigo;

    public CreatedMecanico(EmpleadoId empleadoId, NombrePersona nombre, DocumentoIdentidad documentoIdentidad, Activo activo, Codigo codigo){
        super("co.com.sofkau.training.ddd.reto.mecanico.events.CreatedMecanico");
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
        this.codigo = codigo;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public NombrePersona getNombre() {
        return nombre;
    }

    public DocumentoIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public Activo getActivo() {
        return activo;
    }

    public Codigo getCodigo() {
        return codigo;
    }
}
