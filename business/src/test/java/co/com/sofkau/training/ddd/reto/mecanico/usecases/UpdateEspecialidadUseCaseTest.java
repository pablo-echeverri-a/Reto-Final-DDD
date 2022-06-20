package co.com.sofkau.training.ddd.reto.mecanico.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.factura.identities.FacturaId;
import co.com.sofkau.training.ddd.reto.mecanico.commands.ChangeEspecialidadCommand;
import co.com.sofkau.training.ddd.reto.mecanico.events.ChangedEspecialidad;
import co.com.sofkau.training.ddd.reto.mecanico.identities.MecanicoId;
import co.com.sofkau.training.ddd.reto.mecanico.usecases.UpdateEspecialidadUseCase;
import co.com.sofkau.training.ddd.reto.mecanico.values.Especialidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateEspecialidadUseCaseTest {

    @InjectMocks
    private UpdateEspecialidadUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateEspecialidadMecanico(){
        var mecanicoId = MecanicoId.of("1");
        var especialidad = Especialidad.of(Especialidad.Especialidades.GENERAL);
        var command = new ChangeEspecialidadCommand(mecanicoId, especialidad);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMecanicoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var changedEspecialidad = (ChangedEspecialidad) events.get(0);
        Assertions.assertEquals("GENERAL", changedEspecialidad.getEspecialidad().value().name());
    }

    private List<DomainEvent> history() {

        var mecanicoId = MecanicoId.of("3");
        var especialidad = Especialidad.of(Especialidad.Especialidades.SUSPENSION);
        var evento = new ChangedEspecialidad(
                especialidad
        );
        evento.setAggregateRootId("2");
        return List.of(evento);
    }

}