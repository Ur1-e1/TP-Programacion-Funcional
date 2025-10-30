import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
}
