package co.com.sofkau.training.ddd.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class UpdateUsuarioCommand extends Command {
    private final ClienteId id;
    private final UsuarioId usuarioId;
    private final NombrePersona nombre;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;

    public UpdateUsuarioCommand(ClienteId id, UsuarioId usuarioId, NombrePersona nombre, DocumentoIdentidad documentoIdentidad, Activo activo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
    }

    public ClienteId getId() {
        return id;
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
