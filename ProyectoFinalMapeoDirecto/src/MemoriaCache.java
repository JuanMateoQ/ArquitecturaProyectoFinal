public class MemoriaCache {
    private static MemoriaCache instance;
    private int[] líneasDeMemoriaCache;
    private int cantidadDeLíneas =8;

    private MemoriaCache(){
        líneasDeMemoriaCache = new int[cantidadDeLíneas];
    }
    public static MemoriaCache getInstance() {
    if(instance == null){
        instance = new MemoriaCache();
    }
    return instance;
    }
}
