import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Alumno {
    private String nombre;
    private double nota;
    private String curso;
}
