public class Registros {
    int registro1;
    int registro2;
    int registro3;
    int registro4;
    private static Registros instance;
    private Registros(){
        this.registro1 =0;
        this.registro2 =0;
        this.registro3 =0;
        this.registro4 =0;
    }

    public static Registros getInstance() {
        if(instance == null){
            instance = new Registros();
        }
        return instance;
    }
}
