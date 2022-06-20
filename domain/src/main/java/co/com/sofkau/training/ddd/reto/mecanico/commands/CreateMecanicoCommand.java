package co.com.sofkau.training.ddd.reto.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class CreateMecanicoCommand extends Command {
    private final NombrePersona nombrePersona;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;

    private final Codigo codigo;

    public CreateMecanicoCommand(NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo, Codigo codigo) {
        this.nombrePersona = nombrePersona;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
        this.codigo = codigo;
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

    public Codigo getCodigo() {
        return codigo;
    }
}
