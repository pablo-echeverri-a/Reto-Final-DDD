package co.com.sofkau.training.ddd.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class CreateClienteCommand extends Command {
    private final ClienteId clienteId;
    private final NombrePersona nombrePersona;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;

    public CreateClienteCommand(ClienteId clienteId, NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo) {
        this.clienteId = clienteId;
        this.nombrePersona = nombrePersona;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
    public NombrePersona getNombre() {
        return nombrePersona;
    }

    public DocumentoIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public Activo getActivo() {
        return activo;
    }
}
