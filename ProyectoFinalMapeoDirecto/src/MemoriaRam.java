import java.util.ArrayList;
import java.util.HashMap;

public class MemoriaRam {
    private static MemoriaRam instance;
    private int[] arregloDeMemoria;
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> operacionesPCDisponibles;
    private int cantidadDeDatosGurdados = 0;
    private int tamañoDeMemoria = 14;
    private MemoriaRam(){
        //Se puede hacer dinámico este valor,
        arregloDeMemoria = new int[tamañoDeMemoria];
        operacionesPCDisponibles = new ArrayList<>();
        map = new HashMap<>();
        cargarOperacionesDisponibles();
        cargarPCasociadasAUnaOperación();
    }

    private void cargarPCasociadasAUnaOperación() {
        map.put(100, 1); //cargar de Memoría Cache en Registro 1
        map.put(101, 2); //Cargar de Memoria Cache en Registro 2
        map.put(102, 3); //Sumar registro 1 y registro 2
        map.put(103, 4); //Cargar de nuevo en cache y en Memora RAM posteriormente, en donde iba el primer valor

        map.put(200, 1); //cargar de Memoría Cache en Registro 1
        map.put(201, 2); //Cargar de Memoria Cache en Registro 2
        map.put(202, 5); //Multiplicación registro 1 y registro 2
        map.put(203, 4); //Cargar de nuevo en cache y en Memora RAM posteriormente, en donde iba el primer valor

        map.put(300, 1); //cargar de Memoría Cache en Registro 1
        map.put(301, 2); //Cargar de Memoria Cache en Registro 2
        map.put(302, 6); //Operación AND registro 1 y registro 2
        map.put(303, 4); //Cargar de nuevo en cache y en Memora RAM posteriormente, en donde iba el primer valor
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

    public int cargarOperación(int pc) {
        System.out.println(map.get(pc));
        return map.get(pc);
    }
}
