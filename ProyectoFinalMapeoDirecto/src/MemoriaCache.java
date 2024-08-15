public class MemoriaCache {
    private static MemoriaCache instance;

    private MemoriaCache(){

    }

        public static MemoriaCache getInstance() {
        if(instance == null){
            instance = new MemoriaCache();
        }
        return instance;
    }
}
