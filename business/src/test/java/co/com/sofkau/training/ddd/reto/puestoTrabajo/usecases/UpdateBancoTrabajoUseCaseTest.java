package co.com.sofkau.training.ddd.reto.puestoTrabajo.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.commands.UpdateBancoTrabajoCommand;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.UpdatedBancoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NumeroBanco;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Sector;
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
class UpdateBancoTrabajoUseCaseTest {

    @InjectMocks
    private UpdateBancoTrabajoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateBancoTrabajo(){
        //arrange
        var puestoTrabajoId = PuestoTrabajoId.of("1");
        var bancoTrabajoId = BancoTrabajoId.of("4");
        var numeroBanco = NumeroBanco.of("Banco 2");
        var sector = Sector.of("Zona Norte");
        var command = new UpdateBancoTrabajoCommand(puestoTrabajoId, bancoTrabajoId, numeroBanco, sector);

        when(repository.getEventsBy("4")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getBancoTrabajoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var updatedBancoTrabajo = (UpdatedBancoTrabajo) events.get(0);
        Assertions.assertEquals("1", updatedBancoTrabajo.aggregateRootId());
        Assertions.assertEquals("4", updatedBancoTrabajo.getBancoTrabajoId().value());
        Assertions.assertEquals("Banco 2", updatedBancoTrabajo.getNumeroBanco().value());
        Assertions.assertEquals("Zona Norte", updatedBancoTrabajo.getSector().value());
    }

    private List<DomainEvent> history() {

        var bancoTrabajoId = BancoTrabajoId.of("3");
        var numeroBanco = NumeroBanco.of("Banco 1");
        var sector = Sector.of("Zona Sur");
        var evento = new UpdatedBancoTrabajo(
                bancoTrabajoId,
                numeroBanco,
                sector
        );
        evento.setAggregateRootId("2");
        return List.of(evento);
    }

}