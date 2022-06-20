package co.com.sofkau.training.ddd.reto.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class UpdateEmpleadoCommand extends Command {
    private final MecanicoId mecanicoId;
    private final EmpleadoId empleadoId;
    private final NombrePersona nombre;
    private final DocumentoIdentidad documentoIdentidad;
    private final Activo activo;
    private final Codigo codigo;

    public UpdateEmpleadoCommand(MecanicoId mecanicoId, EmpleadoId empleadoId, NombrePersona nombre,
                                DocumentoIdentidad documentoIdentidad, Activo activo, Codigo codigo) {
        this.mecanicoId = mecanicoId;
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
        this.codigo = codigo;
    }

    public MecanicoId getMecanicoId() {
        return mecanicoId;
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
