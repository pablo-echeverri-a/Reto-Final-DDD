package co.com.sofkau.training.ddd.reto.cliente.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.cliente.values.*;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;

public class Usuario extends Entity<UsuarioId> {
    private NombrePersona nombrePersona;
    private DocumentoIdentidad documentoIdentidad;
    private Activo activo;

    public Usuario(UsuarioId entityId) {
        super(entityId);
    }

    public Usuario(UsuarioId entityId, NombrePersona nombrePersona, DocumentoIdentidad documentoIdentidad, Activo activo) {
        super(entityId);
        this.nombrePersona = nombrePersona;
        this.documentoIdentidad = documentoIdentidad;
        this.activo = activo;
    }

    public void actualizarUsuario(Usuario usuario){
        this.nombrePersona = usuario.nombrePersona;
        this.documentoIdentidad = usuario.documentoIdentidad;
        this.activo = usuario.activo;
    }
}
