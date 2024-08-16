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
        for (int i = 0; i < cantidadDeLíneas; i++){
            if (líneasDeMemoriaCache[i] != null) {
                System.out.println(i + "tag: " + this.líneasDeMemoriaCache[i].getTag());
                System.out.println(i + "index: " + this.líneasDeMemoriaCache[i].getIndex());
                System.out.println(i + ": " + líneasDeMemoriaCache[i].getDatoAlamcenado());
            } else {
                System.out.println("Error: Elemento en líneasDeMemoriaCache es null en índice " + i);
            }
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
