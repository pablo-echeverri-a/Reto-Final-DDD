package co.com.sofkau.training.ddd.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class UpdatedUsuario extends DomainEvent {
    private final UsuarioId usuarioId;
    private final NombrePersona nombrePersona;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;

    public UpdatedUsuario(UsuarioId usuarioId, NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo){
        super("co.com.sofkau.training.ddd.reto.cliente.events.UpdatedUsuario");

        this.usuarioId = usuarioId;
        this.nombrePersona = nombrePersona;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public NombrePersona getNombrePersona() {
        return nombrePersona;
    }

    public DocumentoIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public Activo getActivo() {
        return activo;
    }
}
