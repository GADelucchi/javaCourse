package edu.coder.swagger.services;

import edu.coder.swagger.models.Venta;
import edu.coder.swagger.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> buscarVentas() {
        return ventaRepository.findAll();
    }

    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarVentaById(Integer idVenta) {
        return ventaRepository.findById(idVenta);
    }
}
