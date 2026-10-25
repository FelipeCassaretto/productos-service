package cl.duoc.productos.repository;

import cl.duoc.productos.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository 
public class ProductoRepository {

    private final Map<Long, Producto> datos = new ConcurrentHashMap<>();
    private final AtomicLong secuencia = new AtomicLong();

    public List<Producto> findAll() {
        return new ArrayList<>(datos.values());
    }

    public Optional<Producto> findById(Long id){
        return Optional.ofNullable(datos.get(id));
    }

    public Producto save(Producto producto) {
        Long id = (producto.id() == null) ? 
            secuencia.incrementAndGet() : producto.id();
        Producto guardado = new Producto(id, 
            producto.nombre(), producto.cantidad());
        datos.put(id, guardado);
        return guardado;
    }

    public boolean deleteById(Long id) {
        return datos.remove(id) != null;
    }

}