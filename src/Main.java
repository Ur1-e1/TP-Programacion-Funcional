import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        casoAlumno();
        casoProducto();
        casoLibro();
        casoEmpleado();

    }

    public static void casoAlumno() {
        List<Alumno> alumnos = crearAlumnos();
        System.out.println("CASO PRACTICO 1: ALUMNOS");


        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Alumnos aprobados: " + aprobados);


        double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0);
        System.out.println("Promedio general: " + promedio);


        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println("Alumnos por curso: " + porCurso);


        List<Double> mejoresPromedios = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .map(Alumno::getNota)
                .collect(Collectors.toList());
        System.out.println("Top 3 notas: " + mejoresPromedios);
    }

    public static List<Alumno> crearAlumnos() {
        return Arrays.asList(
                new Alumno("Juan", 8.5, "Matematicas"),
                new Alumno("Ana", 6.0, "Fisica"),
                new Alumno("Luis", 9.0, "Matematicas"),
                new Alumno("Maria", 7.5, "Fisica"),
                new Alumno("Carlos", 5.0, "Quimica")
        );
    }


    public static void casoProducto() {
        List<Producto> productos = crearProductos();
        System.out.println("\nCASO PRACTICO 2: PRODUCTOS");


        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
        System.out.println("Productos caros: " + caros.stream().map(Producto::getNombre).collect(Collectors.toList()));


        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));
        System.out.println("Stock por categoria: " + stockPorCategoria);


        String productosString = productos.stream()
                .map(p -> p.getNombre() + " - " + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("Productos como String: " + productosString);


        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0);
        System.out.println("Promedio general: " + promedioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        System.out.println("Promedio por categoria: " + promedioPorCategoria);
    }

    public static List<Producto> crearProductos() {
        return Arrays.asList(
                new Producto("Laptop", "Tecnologia", 1200, 10),
                new Producto("Mouse", "Tecnologia", 25, 50),
                new Producto("Silla", "Muebles", 150, 20),
                new Producto("Mesa", "Muebles", 300, 15),
                new Producto("Monitor", "Tecnologia", 250, 30)
        );
    }


    public static void casoLibro() {
        List<Libro> libros = crearLibros();
        System.out.println("\nCASO PRACTICO 3: LIBROS");


        List<String> titulos = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Libros largos: " + titulos);


        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0);
        System.out.println("Promedio de paginas: " + promedioPaginas);


        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
        System.out.println("Libros por autor: " + librosPorAutor);


        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));
        libroMasCaro.ifPresent(l -> System.out.println("Libro mas caro: " + l.getTitulo() + " - " + l.getPrecio()));
    }

    public static List<Libro> crearLibros() {
        return Arrays.asList(
                new Libro("El Quijote", "Cervantes", 863, 25.99),
                new Libro("1984", "Orwell", 328, 15.50),
                new Libro("Cien años de soledad", "Garcia Marquez", 417, 20.00),
                new Libro("El Principito", "Saint-Exupery", 96, 10.00),
                new Libro("IT", "Stephen King", 1138, 30.00)
        );
    }


    public static void casoEmpleado() {
        List<Empleado> empleados = crearEmpleados();
        System.out.println("\nCASO PRACTICO 4: EMPLEADOS");


        List<Empleado> salariosAltos = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());
        System.out.println("Empleados con salario alto: " + salariosAltos.stream().map(Empleado::getNombre).collect(Collectors.toList()));


        double promedioSalario = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0);
        System.out.println("Promedio salarial: " + promedioSalario);


        Map<String, Double> salariosPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        System.out.println("Salarios por departamento: " + salariosPorDepartamento);


        List<String> jovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
        System.out.println("Empleados mas jovenes: " + jovenes);
    }

    public static List<Empleado> crearEmpleados() {
        return Arrays.asList(
                new Empleado("Ana", "Ventas", 2500, 30),
                new Empleado("Luis", "TI", 3000, 25),
                new Empleado("Maria", "RRHH", 1800, 40),
                new Empleado("Carlos", "TI", 3500, 28),
                new Empleado("Juan", "Ventas", 2200, 35)
        );
    }
}