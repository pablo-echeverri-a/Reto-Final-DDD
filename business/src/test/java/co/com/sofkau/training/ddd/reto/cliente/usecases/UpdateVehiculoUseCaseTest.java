package co.com.sofkau.training.ddd.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.training.ddd.reto.cliente.commands.UpdateVehiculoCommand;
import co.com.sofkau.training.ddd.reto.cliente.events.UpdatedVehiculo;
import co.com.sofkau.training.ddd.reto.cliente.identities.ClienteId;
import co.com.sofkau.training.ddd.reto.cliente.identities.VehiculoId;
import co.com.sofkau.training.ddd.reto.cliente.values.*;
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
class UpdateVehiculoUseCaseTest {

    @InjectMocks
    private UpdateVehiculoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateVehiculo(){
        //arrange
        var clienteId = ClienteId.of("1");
        var vehiculoId = VehiculoId.of("2");
        var tipoVehiculo = TipoVehiculo.of(TipoVehiculo.TiposVehiculos.AUTOMOVIL);
        var marca = Marca.of("Chevrolet");
        var linea = Linea.of("Swift");
        var modelo = Modelo.of("1994");
        var placa = Placa.of("ABC123");
        var command = new UpdateVehiculoCommand(clienteId, vehiculoId, tipoVehiculo,
                marca, linea, modelo, placa);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getVehiculoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var updatedVehiculo = (UpdatedVehiculo) events.get(0);
        Assertions.assertEquals("1", updatedVehiculo.aggregateRootId());
        Assertions.assertEquals("AUTOMOVIL", updatedVehiculo.getTipoVehiculo().value().name());
        Assertions.assertEquals("Chevrolet", updatedVehiculo.getMarca().value());
        Assertions.assertEquals("Swift", updatedVehiculo.getLinea().value());
        Assertions.assertEquals("1994", updatedVehiculo.getModelo().value());
        Assertions.assertEquals("ABC123", updatedVehiculo.getPlaca().value());
    }

    private List<DomainEvent> history() {

        var vehiculoId = VehiculoId.of("3");
        var tipoVehiculo = TipoVehiculo.of(TipoVehiculo.TiposVehiculos.CAMIONETA);
        var marca = Marca.of("Suzuki");
        var linea = Linea.of("Forsa");
        var modelo = Modelo.of("1995");
        var placa = Placa.of("ABC132");
        var evento = new UpdatedVehiculo(
                vehiculoId,
                tipoVehiculo,
                marca,
                linea,
                modelo,
                placa
        );
        evento.setAggregateRootId("2");
        return List.of(evento);
    }
}