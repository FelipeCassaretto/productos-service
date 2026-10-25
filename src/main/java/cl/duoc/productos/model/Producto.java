package cl.duoc.productos.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record Producto(
    Long id,

    @NotBlank(message = "El nombre es obligatorio") 
    String nombre,

    @NotNull(message = "La cantidad es obligatoria")
    @PositiveOrZero(message = "La cantidad no puede ser negativa")
    Integer cantidad) {
}

