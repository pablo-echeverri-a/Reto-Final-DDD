package co.com.sofkau.training.ddd.reto.cliente.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.training.ddd.reto.cliente.identities.VehiculoId;
import co.com.sofkau.training.ddd.reto.cliente.values.*;

public class Vehiculo extends Entity<VehiculoId> {
    private TipoVehiculo tipoVehiculo;
    private Marca marca;
    private Linea linea;
    private Modelo modelo;
    private Placa placa;

    public Vehiculo(VehiculoId entityId) {
        super(entityId);
    }

    public Vehiculo(VehiculoId entityId, TipoVehiculo tipoVehiculo, Marca marca, Linea linea, Modelo modelo, Placa placa) {
        super(entityId);
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.placa = placa;
    }

    public void actualizarVehiculo(Vehiculo vehiculo){
        this.tipoVehiculo = vehiculo.tipoVehiculo;
        this.marca = vehiculo.marca;
        this.linea = vehiculo.linea;
        this.modelo = vehiculo.modelo;
        this.placa = vehiculo.placa;
    }
}
