package edu.coderhouse.FacturacionSegundaEntregaDelucchi.services;

import edu.coderhouse.FacturacionSegundaEntregaDelucchi.models.Venta;
import edu.coderhouse.FacturacionSegundaEntregaDelucchi.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public Venta crearVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarVentaById(Integer idVenta) {
        return ventaRepository.findById(idVenta);
    }
}
