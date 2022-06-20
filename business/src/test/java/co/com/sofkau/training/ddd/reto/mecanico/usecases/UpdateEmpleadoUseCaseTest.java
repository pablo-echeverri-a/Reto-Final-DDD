package co.com.sofkau.training.ddd.reto.mecanico.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.mecanico.commands.UpdateEmpleadoCommand;
import co.com.sofkau.training.ddd.reto.mecanico.events.UpdatedEmpleado;
import co.com.sofkau.training.ddd.reto.mecanico.identities.EmpleadoId;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.values.Codigo;
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
class UpdateEmpleadoUseCaseTest {

    @InjectMocks
    private UpdateEmpleadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateEmpleado(){
        //arrange
        var mecanicoId = MecanicoId.of("1");
        var empleadoId = EmpleadoId.of("2");
        var nombre = NombrePersona.of("Pablo", "Echeverri");
        var documento = DocumentoIdentidad.of("CC", "1234");
        var activo = Activo.of(true);
        var codigo = Codigo.of("1234");
        var command = new UpdateEmpleadoCommand(mecanicoId, empleadoId, nombre,
                documento, activo, codigo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var updatedEmpleado = (UpdatedEmpleado) events.get(0);
        Assertions.assertEquals("1", updatedEmpleado.aggregateRootId());
        Assertions.assertEquals("2", updatedEmpleado.getEmpleadoId().value());
        Assertions.assertEquals("Pablo Echeverri", updatedEmpleado.getNombrePersona().value());
        Assertions.assertEquals("CC 1234", updatedEmpleado.getDocumentoIdentidad().value());
        Assertions.assertEquals(true, updatedEmpleado.getActivo().value());
        Assertions.assertEquals("1234", updatedEmpleado.getCodigo().value());
    }

    private List<DomainEvent> history() {

        var empleadoId = EmpleadoId.of("3");
        var nombre = NombrePersona.of("Pablo", "E");
        var documento = DocumentoIdentidad.of("CC", "12345");
        var activo = Activo.of(false);
        var codigo = Codigo.of("12346");
        var evento = new UpdatedEmpleado(
                empleadoId,
                nombre,
                documento,
                activo,
                codigo
        );
        evento.setAggregateRootId("2");
        return List.of(evento);
    }
}