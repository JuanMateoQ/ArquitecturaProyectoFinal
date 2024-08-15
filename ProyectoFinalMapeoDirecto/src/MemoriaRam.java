import java.util.ArrayList;

public class MemoriaRam {
    private static MemoriaRam instance;
    private int[] arregloDeMemoria;
    private ArrayList<Integer> operacionesPCDisponibles;
    private int cantidadDeDatosGurdados = 0;
    private int tamañoDeMemoria = 14;
    private MemoriaRam(){
        //Se puede hacer dinámico este valor,
        arregloDeMemoria = new int[tamañoDeMemoria];
        operacionesPCDisponibles = new ArrayList<>();
        cargarOperacionesDisponibles();
    }

    private void cargarOperacionesDisponibles() {
        operacionesPCDisponibles.add(100); //Sumar
        operacionesPCDisponibles.add(200); //Multiplicar
        operacionesPCDisponibles.add(300); //AND
    }

    public static MemoriaRam getInstance() {
        if(instance == null){
            instance = new MemoriaRam();
        }
        return instance;
    }

    public int seleccionarPC(int númeroDeOperaciónARealizar) {
        return operacionesPCDisponibles.get(númeroDeOperaciónARealizar);
    }

    public void agregarValor(int valorAAgregar) {
        arregloDeMemoria[cantidadDeDatosGurdados] = valorAAgregar;
        cantidadDeDatosGurdados++;
    }

    public void mostrarValoresCargados() {
        System.out.println("Los datos cargados en Memoria Principal son...");
        for (int i =0; i < cantidadDeDatosGurdados; i++){
            System.out.println(i+1 + ": " + arregloDeMemoria[i]);
        }
    }
}
