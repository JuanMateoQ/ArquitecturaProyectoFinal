public class MemoriaCache {
    private static MemoriaCache instance;
    private LíneasDeMemoria[] líneasDeMemoriaCache;
    private MemoriaRam ram = MemoriaRam.getInstance();
    private int cantidadDeLíneas =8;
    private int guardarDatoAux;

    private MemoriaCache(){
        líneasDeMemoriaCache = new LíneasDeMemoria[cantidadDeLíneas];
        cargarLíneasDeMemoria();
    }

    private void cargarLíneasDeMemoria() {
        for(int i =0; i < cantidadDeLíneas; i++){
            líneasDeMemoriaCache[i].setIndex(i % (cantidadDeLíneas-1));
            líneasDeMemoriaCache[i].setTag(i / (cantidadDeLíneas-1));
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

    public int traerDato(int tag, int index) {
        if(comprobarSiExisteEnCache(tag, index)){
            return guardarDatoAux;
        }
        traerDatoDeMemoriaPrincipal(tag, index);

        //esta línea solo es para evitar la excepción.
        return 0;
    }
    private void traerDatoDeMemoriaPrincipal(int tag, int index) {
        //for (int i = 0; i < ram.get)
    }

    private boolean comprobarSiExisteEnCache(int tag, int index) {
        for(int i =0; i< this.cantidadDeLíneas; i++){
            if(tag == líneasDeMemoriaCache[i].getTag() & index == líneasDeMemoriaCache[i].getIndex()){
                guardarDatoAux = líneasDeMemoriaCache[i].getDatoAlamcenado();
                return true;
            }
        }
        return false;
    }
}
