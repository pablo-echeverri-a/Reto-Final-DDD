package co.com.sofkau.training.ddd.reto.servicioRM.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.servicioRM.commands.UpdateNombreServicioCommand;
import co.com.sofkau.training.ddd.reto.servicioRM.events.UpdatedNombreServicio;
import co.com.sofkau.training.ddd.reto.servicioRM.identities.ServicioRMId;
import co.com.sofkau.training.ddd.reto.servicioRM.values.NombreServicio;
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
class UpdateNombreServicioUseCaseTest {

    @InjectMocks
    private UpdateNombreServicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateBancoTrabajo(){
        //arrange
        var servicioRMId = ServicioRMId.of("1");
        var nombreServicio = NombreServicio.of("Cambio Amortiguador");
        var command = new UpdateNombreServicioCommand(servicioRMId, nombreServicio);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getServicioRMId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var updatedNombreServicio = (UpdatedNombreServicio) events.get(0);
        Assertions.assertEquals("1", updatedNombreServicio.aggregateRootId());
        Assertions.assertEquals("Cambio Amortiguador", updatedNombreServicio.getNombreServicio());
    }

    private List<DomainEvent> history() {

        var servicioRMId = ServicioRMId.of("2");
        var nombreServicio = NombreServicio.of("Cambio Aceite");
        var evento = new UpdatedNombreServicio(nombreServicio.value());
        evento.setAggregateRootId("2");
        return List.of(evento);
    }
}