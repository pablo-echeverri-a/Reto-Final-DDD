package co.com.sofkau.training.ddd.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.training.ddd.reto.cliente.commands.CreateClienteCommand;
import co.com.sofkau.training.ddd.reto.cliente.events.CreatedCliente;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateClienteUseCaseTest {
    @Test
    void createCliente(){
        //arrange
        NombrePersona nombrePersona = new NombrePersona("Pablo", "Echeverri");
        DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad("CC","1111111");
        Activo activo = new Activo(true);
        var command = new CreateClienteCommand(new ClienteId(), new UsuarioId(), nombrePersona,documentoIdentidad, activo);
        var usecase = new CreateClienteUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        CreatedCliente event = (CreatedCliente) events.get(0);
        Assertions.assertEquals("Pablo Echeverri", event.getNombre().value());
        Assertions.assertEquals("CC 1111111", event.getDocumentoIdentidad().value());
        Assertions.assertEquals(true, event.getActivo().value());
    }
}