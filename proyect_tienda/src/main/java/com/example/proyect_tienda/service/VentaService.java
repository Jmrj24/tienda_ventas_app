package com.example.proyect_tienda.service;

import com.example.proyect_tienda.dto.VentaClienteDTO;
import com.example.proyect_tienda.model.Producto;
import com.example.proyect_tienda.model.Venta;
import com.example.proyect_tienda.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoService productoServi;

    @Override
    public String saveVenta(Venta venta) {
        List<Producto> listaProductosVe = venta.getListaProductos();
        List<Producto> listaProductosBD = productoServi.getAllProductos();
        double sumCosProduc = 0.0;
        String resp = "";
        boolean ventaBand  = false;
        double contProducRepet;
        double cantProducBD = 0;

        for(Producto productoVe: listaProductosVe) {
            for(Producto productoBD: listaProductosBD) {
                if(productoVe.getCodigoProducto()==productoBD.getCodigoProducto()) {
                    cantProducBD = productoBD.getCantidadDisponible();
                    if(cantProducBD>0) {
                        sumCosProduc += productoBD.getCosto();
                        ventaBand = true;
                    } else {
                        ventaBand = false;
                        resp = "Fallo la creación de la venta, Stock no disponible";
                    }
                }
            }
            if(!ventaBand) {
                break;
            }
            contProducRepet = 0;
            for(Producto productoVeRe: listaProductosVe) {
                if(productoVe.getCodigoProducto()==productoVeRe.getCodigoProducto()) {
                    contProducRepet++;
                }
            }
            if(contProducRepet>cantProducBD) {
                resp = "Fallo la creación de la venta, Stock no disponible";
                ventaBand = false;
                break;
            }
        }

        if(ventaBand) {
            double cantDesc;
            for(Producto productoVe: listaProductosVe) {
                Producto proDesc = productoServi.findProducto(productoVe.getCodigoProducto());
                cantDesc = proDesc.getCantidadDisponible();
                cantDesc--;
                proDesc.setCantidadDisponible(cantDesc);
                productoServi.editProducto(proDesc);
            }
            venta.setTotal(sumCosProduc);
            ventaRepo.save(venta);
            resp = "Venta creada correctamente";
        }
        return resp;
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void deleteVenta(Long codigoVenta) {
        ventaRepo.deleteById(codigoVenta);
    }

    @Override
    public Venta findVenta(Long codigoVenta) {
        return ventaRepo.findById(codigoVenta).orElse(null);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public List<Producto> getProductos(Long codigoVenta) {
        return this.findVenta(codigoVenta).getListaProductos();
    }

    @Override
    public String getVentasFecha(LocalDate fechaVenta) {
        List<Venta> listaVentas = this.getAllVentas();
        double sumaTotalVentas = 0.0;
        int cantVentas = 0;

        for(Venta venta: listaVentas) {
            if(fechaVenta.equals(venta.getFechaVenta())) {
                sumaTotalVentas += venta.getTotal();
                cantVentas++;
            }
        }
        return "La sumatoria del monto total de las ventas es: " + sumaTotalVentas + " y la cantidad total de ventas " +
                "para el dia: " + fechaVenta + " es: " + cantVentas;
    }

    @Override
    public VentaClienteDTO mayorVenta() {
        List<Venta> listaVentas = this.getAllVentas();
        Venta ventaMayor = new Venta();
        double auxVentaMayor = 0.0;

        for(Venta venta: listaVentas) {
            if(venta.getTotal()>auxVentaMayor) {
                ventaMayor = venta;
                auxVentaMayor = venta.getTotal();
            }
        }
        VentaClienteDTO ventaMayorDTO = new VentaClienteDTO();
        ventaMayorDTO.setCodigoVenta(ventaMayor.getCodigoVenta());
        ventaMayorDTO.setTotalVenta(ventaMayor.getTotal());
        ventaMayorDTO.setCantidadProductos(ventaMayor.getListaProductos().size());
        ventaMayorDTO.setNombreCliente(ventaMayor.getUnCliente().getNombre());
        ventaMayorDTO.setApellidoCliente(ventaMayor.getUnCliente().getApellido());
        return ventaMayorDTO;
    }
}
