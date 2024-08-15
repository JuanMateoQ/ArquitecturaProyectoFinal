import java.util.ArrayList;

public class MemoriaSecundaria {
    ArrayList<Integer> datosGuardadosNoBorrables;
    private static MemoriaSecundaria instance;
    private MemoriaSecundaria(){
        datosGuardadosNoBorrables = new ArrayList<>();
    }
    public static MemoriaSecundaria getInstance(){
        if(instance == null){
            instance = new MemoriaSecundaria();
        }
        return instance;
    }

    public void guardarDato(int aux) {
        datosGuardadosNoBorrables.add(aux);
    }

    public void imprimirDatosGuardados() {
        System.out.println("\t| Datos Guardados en Memoria Secundaria |");
        for(int i =0; i < datosGuardadosNoBorrables.size(); i++){
            System.out.println(i+1 + ": " + datosGuardadosNoBorrables.get(i));
        }
    }

    public int getNúmeroDeValoresCargados() {
        return datosGuardadosNoBorrables.size();
    }

    public int getValor(int i) {
        return datosGuardadosNoBorrables.get(i);
    }
}
