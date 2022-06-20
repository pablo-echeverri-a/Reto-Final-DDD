package co.com.sofkau.training.ddd.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class CreatedCliente extends DomainEvent {
    private final UsuarioId usuarioId;
    private final NombrePersona nombre;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;

    public CreatedCliente(UsuarioId usuarioId, NombrePersona nombre, DocumentoIdentidad documentoIdentidad, Activo activo){
        super("co.com.sofkau.training.ddd.reto.cliente.events.CreatedCliente");
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
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
}
