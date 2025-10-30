import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;
}