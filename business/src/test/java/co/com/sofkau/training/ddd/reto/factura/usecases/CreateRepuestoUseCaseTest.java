package co.com.sofkau.training.ddd.reto.factura.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.RepuestoFactory;
import co.com.sofkau.training.ddd.reto.factura.commands.CreateRepuestoCommand;
import co.com.sofkau.training.ddd.reto.factura.events.CreatedFactura;
import co.com.sofkau.training.ddd.reto.factura.events.RepuestoAdded;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.factura.identities.ManoObraId;
import co.com.sofkau.training.ddd.reto.factura.identities.RepuestoId;
import co.com.sofkau.training.ddd.reto.factura.values.Costo;
import co.com.sofkau.training.ddd.reto.factura.values.Horas;
import co.com.sofkau.training.ddd.reto.factura.values.NombreRepuesto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateRepuestoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CreateRepuestoUseCase useCase;

    @Test
    void addRepuestoFactura(){
        //arrange
        RepuestoFactory factory = RepuestoFactory.getInstance()
                .add(RepuestoId.of("1"), new NombreRepuesto("piston"), new Costo(120000))
                .add(RepuestoId.of("2"), new NombreRepuesto("empaque"), new Costo(60000));

        FacturaId id = new FacturaId();
        var command = new CreateRepuestoCommand(factory, id);
        when(repository.getEventsBy(id.value())).thenReturn(history());
        useCase.addRepository(repository);


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(2, events.size());

    }

    private List<DomainEvent> history() {
        Horas horas = new Horas(3);
        Costo costo = new Costo(100000);
        return List.of(
                new CreatedFactura(new ManoObraId(), horas, costo),
                new RepuestoAdded(RepuestoId.of("1"),
                        new NombreRepuesto("piston"),
                        new Costo(120000)
                ));
    }
}