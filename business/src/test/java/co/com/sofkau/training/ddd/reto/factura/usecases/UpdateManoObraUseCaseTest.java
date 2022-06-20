package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.commands.UpdateManoObraCommand;
import co.com.sofkau.training.ddd.reto.factura.events.UpdatedManoObra;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;
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
class UpdateManoObraUseCaseTest {

    @InjectMocks
    private UpdateManoObraUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateManoObra(){
        //arrange
        var facturaId = FacturaId.of("1");
        var manoObraId = ManoObraId.of("2");
        var horas = Horas.of(2);
        var costo = Costo.of(100000);
        var command = new UpdateManoObraCommand(facturaId, manoObraId, horas, costo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getManoObraId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var updatedManoObra = (UpdatedManoObra) events.get(0);
        Assertions.assertEquals("1", updatedManoObra.aggregateRootId());
        Assertions.assertEquals("2", updatedManoObra.getManoObraId().value());
        Assertions.assertEquals(2, updatedManoObra.getHoras().value());
        Assertions.assertEquals(100000, updatedManoObra.getCosto().value());
    }

    private List<DomainEvent> history() {

        var facturaId = FacturaId.of("2");
        var manoObraId = ManoObraId.of("3");
        var horas = Horas.of(3);
        var costo = Costo.of(200000);
        var evento = new UpdatedManoObra(
                manoObraId,
                horas,
                costo
        );
        evento.setAggregateRootId("3");
        return List.of(evento);
    }

}