public class UnidadDeControl {
    private Instrucciones instrucciones;
    private Registros registros;
    private int PC;
    private String IR;

    public UnidadDeControl() {
        this.instrucciones = new Instrucciones();
        this.registros = new Registros();
        this.PC = 0;
        this.IR = "";
    }

    public void cargar(String direccion, int valor) {
        // Convertir la dirección en binario y almacenar el valor en el registro
        if (direccion.equals("0000")) { // Si la dirección es 0000 cargamos en AC1
            registros.setAC1(valor);
        } else if (direccion.equals("0001")) { // Si la dirección es 0001 cargamos en AC2
            registros.setAC2(valor);
        }
        IR = direccion;
    }

    public void ejecutarOperacion(String codigo) {
        String operacion = instrucciones.getOperacion(codigo);

        switch (operacion) {
            case "CARGAR":
                
                break;
            case "SUMAR":
                registros.setAC1(registros.getAC1().get() + registros.getAC2().get());
                break;
            case "MULTIPLICAR":
                registros.setAC1(registros.getAC1().get() * registros.getAC2().get());
                break;
            case "COMPARAR":
                if (registros.getAC1().get() == registros.getAC2().get()) {
                    System.out.println("AC1 es igual a AC2");
                } else {
                    System.out.println("AC1 no es igual a AC2");
                }
                break;
            default:
                System.out.println("Operación no soportada.");
        }
        PC++;
    }

    public void mostrarEstado() {
        System.out.println("PC: " + PC);
        System.out.println("IR: " + IR);
        System.out.println("AC1: " + registros.getAC1());
        System.out.println("AC2: " + registros.getAC2());
    }
}
