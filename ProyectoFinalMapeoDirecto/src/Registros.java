public class Registros {
    public String[] registros;
    public int cantidadDeRegistros = 4;
    private static Registros instance;
    private Registros(){
        this.registros = new String[cantidadDeRegistros];
    }

    public static Registros getInstance() {
        if(instance == null){
            instance = new Registros();
        }
        return instance;
    }

    public void cargarEnRegistro(int númeroDeRegistro, String valorACaargar) {
        registros[númeroDeRegistro] = valorACaargar;
    }
//hola
    public void imprimirRegistros() {
        System.out.println(" Los registros son: ");
        for (int i = 0; i < cantidadDeRegistros; i++){
            System.out.println(i + ": " + registros[i]);
        }
    }
}
