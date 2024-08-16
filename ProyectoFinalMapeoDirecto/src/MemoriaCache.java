public class MemoriaCache {
    private static MemoriaCache instance;
    private LíneasDeMemoria[] líneasDeMemoriaCache;
    MemoriaRam ram = MemoriaRam.getInstance();
    private int cantidadDeLíneas = 8;
    private LíneasDeMemoria guardarDatoAux;

    private MemoriaCache(){
        líneasDeMemoriaCache = new LíneasDeMemoria[cantidadDeLíneas];
        cargarLíneasDeMemoria();
    }

    private void cargarLíneasDeMemoria() {
        for(int i = 0; i < cantidadDeLíneas; i++){
            líneasDeMemoriaCache[i] = new LíneasDeMemoria(); // Inicializar cada elemento
            líneasDeMemoriaCache[i].setIndex(i % (cantidadDeLíneas));
            //líneasDeMemoriaCache[i].setTag(i / (cantidadDeLíneas));
        }
    }

    public static MemoriaCache getInstance() {
        if(instance == null){
            instance = new MemoriaCache();
        }
        return instance;
    }

    public int getNúmeroDeLíneas() {
        return cantidadDeLíneas;
    }

    public String traerDato(int tag, int index) {
        if(comprobarSiExisteEnCache(tag, index)){
            return guardarDatoAux.getDatoAlamcenado();
        }
        traerDatoDeMemoriaPrincipal(tag, index);
        return guardarDatoAux.getDatoAlamcenado();
    }

    private void traerDatoDeMemoriaPrincipal(int tag, int index) {
        for (int i = 0; i < ram.getCantidadDeDatos(); i++){
            if(ram.getDatos(i).getTag() == tag && ram.getDatos(i).getIndex() == index){
                guardarLíneaEnMemoriaCache(ram.getDatos(i));
                return;
            }
        }
    }

    private void guardarLíneaEnMemoriaCache(LíneasDeMemoria datoAGuardar) {
        for(int i = 0; i < this.cantidadDeLíneas; i++){
            if(líneasDeMemoriaCache[i].getIndex() == datoAGuardar.getIndex()){
                líneasDeMemoriaCache[i].setTag(datoAGuardar.getTag());
                líneasDeMemoriaCache[i].setValor(datoAGuardar.getDatoAlamcenado());
                guardarDatoAux = líneasDeMemoriaCache[i];
                return;
            }
        }
    }

    private boolean comprobarSiExisteEnCache(int tag, int index) {
        for(int i = 0; i < this.cantidadDeLíneas; i++){
            if(tag == líneasDeMemoriaCache[i].getTag() && index == líneasDeMemoriaCache[i].getIndex()){
                guardarDatoAux = líneasDeMemoriaCache[i];
                return true;
            }
        }
        return false;
    }

    public void mostrarValoresCargados() {
        System.out.println("Los datos cargados en Memoria Cache son...");
        
        int elementosPorFila = 6; // Define cuántos elementos imprimir por fila
    
        for (int fila = 0; fila < cantidadDeLíneas; fila += elementosPorFila) {
            // Imprimir los índices en una sola línea
            System.out.printf("  "); // Espacio inicial para los índices
            for (int i = fila; i < fila + elementosPorFila && i < cantidadDeLíneas; i++) {
                System.out.printf("%-14d", i); // Espacio fijo de 14 caracteres para cada índice
            }
            System.out.println(); // Salto de línea después de imprimir los índices
    
            // Imprimir los valores de tag y index en binario en la siguiente línea
            for (int i = fila; i < fila + elementosPorFila && i < cantidadDeLíneas; i++) {
                if (líneasDeMemoriaCache[i] != null) {
                    String tagBinario = Binario.convertir(líneasDeMemoriaCache[i].getTag());
                    String indexBinario = Binario.convertir(líneasDeMemoriaCache[i].getIndex());
                    System.out.printf("|%-13s", tagBinario + " " + indexBinario); // Espacio fijo de 13 caracteres para cada par tag-index
                } else {
                    System.out.printf("|%-13s", "-"); // Imprimir un guion si el valor es null
                }
            }
            System.out.println("|"); // Cerrar la línea con el último delimitador "|"
    
            System.out.println(); // Salto de línea entre bloques de 6 elementos
        }
    }

    public void modificarDato(int tag, int index, String valor) {
        for(int i = 0; i < this.cantidadDeLíneas; i++){
            if(tag == líneasDeMemoriaCache[i].getTag() && index == líneasDeMemoriaCache[i].getIndex()){
                líneasDeMemoriaCache[i].setValor(valor);
                ram.modificarEnMemoriaPrincipal(tag, index, valor);
                return;
            }
        }

    }
}
