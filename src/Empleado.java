import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Empleado {
    private String nombre;
    private String departamento;
    private double salario;
    private int edad;
}
