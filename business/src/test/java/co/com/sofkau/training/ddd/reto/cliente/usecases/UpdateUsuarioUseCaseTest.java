package co.com.sofkau.training.ddd.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.commands.UpdateUsuarioCommand;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedUsuario;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.cliente.identities.UsuarioId;
import co.com.sofkau.training.ddd.reto.values.Activo;
import co.com.sofkau.training.ddd.reto.values.DocumentoIdentidad;
import co.com.sofkau.training.ddd.reto.values.NombrePersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateUsuarioUseCaseTest {

    @InjectMocks
    private UpdateUsuarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateUsuario(){
        //arrange
        var clienteId = ClienteId.of("1");
        var usuarioId = UsuarioId.of("2");
        var nombre = NombrePersona.of("Pablo", "Echeverri");
        var documento = DocumentoIdentidad.of("CC", "1234");
        var activo = Activo.of(true);
        var command = new UpdateUsuarioCommand(clienteId, usuarioId, nombre, documento, activo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getUsuarioId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var updatedUsuario = (UpdatedUsuario) events.get(0);
        Assertions.assertEquals("1", updatedUsuario.aggregateRootId());
        Assertions.assertEquals("Pablo Echeverri", updatedUsuario.getNombrePersona().value());
        Assertions.assertEquals("CC 1234", updatedUsuario.getDocumentoIdentidad().value());
        Assertions.assertEquals("2", updatedUsuario.getUsuarioId().value());
        Assertions.assertEquals(true, updatedUsuario.getActivo().value());
    }

    private List<DomainEvent> history() {

        var usuarioId = UsuarioId.of("3");
        var nombre = NombrePersona.of("Pablo","E");
        var documento = DocumentoIdentidad.of("TI","1234");
        var activo = Activo.of(false);
        var evento = new UpdatedUsuario(
                usuarioId,
                nombre,
                documento,
                activo
        );
        evento.setAggregateRootId("2");
        return List.of(evento);
    }
}