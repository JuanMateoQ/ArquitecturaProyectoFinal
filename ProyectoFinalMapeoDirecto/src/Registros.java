public class Registros {
    public int[] registros;
    public int cantidadDeRegistros = 4;
    private static Registros instance;
    private Registros(){
        this.registros = new int[cantidadDeRegistros];
    }

    public static Registros getInstance() {
        if(instance == null){
            instance = new Registros();
        }
        return instance;
    }

    public void cargarEnRegistro(int númeroDeRegistro, int valorACaargar) {
        registros[númeroDeRegistro] = valorACaargar;
    }

    public void imprimirRegistros() {
        System.out.println(" Los registros son: ");
        for (int i = 0; i < cantidadDeRegistros; i++){
            System.out.println(i + ": " + registros[i]);
        }
    }
}
