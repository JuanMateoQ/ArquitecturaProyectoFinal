import java.util.ArrayList;
import java.util.HashMap;

public class MemoriaRam {
    private static MemoriaRam instance;
    private LíneasDeMemoria[] arregloDeMemoria;
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> operacionesPCDisponibles;
    private int cantidadDeDatosGurdados = 0;
    private int tamañoDeMemoria = 14;

    private MemoriaRam(){
        //Se puede hacer dinámico este valor,
        arregloDeMemoria = new LíneasDeMemoria[tamañoDeMemoria];
        operacionesPCDisponibles = new ArrayList<>();
        map = new HashMap<>();
        cargarOperacionesDisponibles();
        cargarPCasociadasAUnaOperación();
        inicializarArregloDeMemoria(); // Inicializar los elementos del arreglo
        cargarTagEIndex();
    }

    private void inicializarArregloDeMemoria() {
        for (int i = 0; i < tamañoDeMemoria; i++) {
            arregloDeMemoria[i] = new LíneasDeMemoria(); // Inicialización de cada elemento
        }
    }

    private void cargarTagEIndex() {
        for(int i =0; i < tamañoDeMemoria; i++){
            if (arregloDeMemoria[i] != null) {
                arregloDeMemoria[i].setIndex(i % (8));
                arregloDeMemoria[i].setTag(i / (8));
            } else {
                System.out.println("Error: arregloDeMemoria[" + i + "] es null.");
            }
        }
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
        if (arregloDeMemoria[cantidadDeDatosGurdados] != null) {
            arregloDeMemoria[cantidadDeDatosGurdados].setValor(Binario.convertir(valorAAgregar));
            cantidadDeDatosGurdados++;
        } else {
            System.out.println("Error: Elemento en arregloDeMemoria es null en índice " + cantidadDeDatosGurdados);
        }
    }

    public void mostrarValoresCargados() {
        System.out.println("Los datos cargados en Memoria Principal son...");
        
        int elementosPorFila = 6; // Define cuántos elementos imprimir por fila
        
        for (int fila = 0; fila < cantidadDeDatosGurdados; fila += elementosPorFila) {
            // Imprimir los índices
            System.out.print("  ");
            for (int i = fila; i < Math.min(fila + elementosPorFila, cantidadDeDatosGurdados); i++) {
                System.out.printf("%-14d", i);
            }
            System.out.println();
        
            // Imprimir tag e index en binario juntos en una sola línea
            for (int i = fila; i < Math.min(fila + elementosPorFila, cantidadDeDatosGurdados); i++) {
                if (arregloDeMemoria[i] != null) {
                    String tagBinario = Binario.convertir(arregloDeMemoria[i].getTag());
                    String indexBinario = Binario.convertir(arregloDeMemoria[i].getIndex());
                    System.out.printf("|%-13s", tagBinario + " " + indexBinario);
                } else {
                    System.out.printf("|%-13s", "-");
                }
            }
            System.out.println("|"); // Cierra la línea de la fila actual
            System.out.println(); // Salto de línea entre bloques de 6 elementos
        }
    }

    public int cargarOperación(int pc) {
        System.out.println(map.get(pc));
        return map.get(pc);
    }

    public int getCantidadDeDatos() {
        return tamañoDeMemoria;
    }

    public LíneasDeMemoria getDatos(int i) {
        return arregloDeMemoria[i];
    }

    public void modificarEnMemoriaPrincipal(int tag, int index, String valor) {
        for(int i = 0; i < cantidadDeDatosGurdados; i++){
            if (tag == arregloDeMemoria[i].getTag() & index == arregloDeMemoria[i].getIndex()){
                arregloDeMemoria[i].setValor(valor);
                return;
            }
        }
    }
}
