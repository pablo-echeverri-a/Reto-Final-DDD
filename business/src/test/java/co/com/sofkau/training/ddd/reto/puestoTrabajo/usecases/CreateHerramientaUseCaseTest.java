package co.com.sofkau.training.ddd.reto.puestoTrabajo.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.HerramientaFactory;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.commands.CreateHerramientaCommand;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.CreatedPuestoTrabajo;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.events.HerramientaAdded;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.BancoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.HerramientaId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.identities.PuestoTrabajoId;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.Descripcion;
import co.com.sofkau.training.ddd.reto.puestoTrabajo.values.NombreHerramienta;
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
class CreateHerramientaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CreateHerramientaUseCase useCase;

    @Test
    void addHerramientaPuestoTrabajo(){
        //arrange
        HerramientaFactory factory = HerramientaFactory.getInstance()
                .add(HerramientaId.of("1"), new NombreHerramienta("martillo"), new Descripcion("sin descripcion"))
                .add(HerramientaId.of("2"), new NombreHerramienta("pistola neumatica"), new Descripcion("sin descripcion"));

        PuestoTrabajoId id = new PuestoTrabajoId();
        var command = new CreateHerramientaCommand(factory, id);
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
        NumeroBanco numeroBanco = new NumeroBanco("Banco 2");
        Sector sector = new Sector("Zona Norte");
        return List.of(
                new CreatedPuestoTrabajo(new BancoTrabajoId(), numeroBanco, sector),
                new HerramientaAdded(HerramientaId.of("1"),
                        new NombreHerramienta("martillo"),
                        new Descripcion("sin descripcion")
                ));
    }
}