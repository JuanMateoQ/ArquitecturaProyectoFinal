import java.util.HashMap;
import java.util.Map;

public class Instrucciones {
    private Map<String, String> instrucciones;

    public Instrucciones() {
        instrucciones = new HashMap<>();
        // Definimos las instrucciones en binario
        instrucciones.put("0000", "CARGAR");
        instrucciones.put("0001", "SUMAR");
        instrucciones.put("0010", "MULTIPLICAR");
        instrucciones.put("0011", "COMPARAR");
    }

    public String getOperacion(String codigo) {
        return instrucciones.get(codigo);
    }
}
