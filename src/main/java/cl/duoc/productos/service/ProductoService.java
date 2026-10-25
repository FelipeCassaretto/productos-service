package cl.duoc.productos.service;

import cl.duoc.productos.model.Producto;
import cl.duoc.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto crear(Producto producto) {
        return repo.save(new Producto(null, producto.nombre(), producto.cantidad()));
    }

    public Producto modificar(Long id, Producto producto) {
        if (repo.findById(id).isEmpty()) {
            throw new NoSuchElementException("El producto " + id + " no existe");
        }
        return repo.save(new Producto(id, producto.nombre(), producto.cantidad()));
    }

    public void eliminar(Long id) {
        if (!repo.deleteById(id)) {
            throw new NoSuchElementException("El producto " + id + " no existe");
        }
    }
}