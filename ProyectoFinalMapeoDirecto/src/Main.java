import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CPU cpu = new CPU();

    public static void main(String[] args) {
        int númeroOperaciónARealizar = 0;
        ingresarValoresAMemoriaRAM();
        cpu.realizarOperación(escogerOpcionesARealizarEnCpu(númeroOperaciónARealizar));
    }

    private static int escogerOpcionesARealizarEnCpu(int númeroOperaciónARealizar) {
        System.out.println("|| OPERACIONES DISPONIBLES ||");
        System.out.println("1. Sumar.");
        System.out.println("2. Multiplicar.");
        System.out.println("3. Operación Lógica AND.");
        System.out.println("0. Salir...");

            System.out.println("Seleccionar opción: ");
            do{
                númeroOperaciónARealizar = scanner.nextInt();
            }while(númeroOperaciónARealizar<0 & númeroOperaciónARealizar>3);
        return númeroOperaciónARealizar;
    }

    private static void ingresarValoresAMemoriaRAM() {
        System.out.println("| INGRESE LOS VALORES A ALMACENAR EN MEMORIA RAM... |");
        int opc;
        do{
            System.out.println("Valor a ingresar:");
            int aux = scanner.nextInt();
            cpu.guardarEnMemoriaSecundaria(aux);
            do{
                System.out.println("Desea seguir ingresando más valores...\n 1:SI  0:NO");
                opc = scanner.nextInt();
                System.out.println("\n");
            }while(opc != 0 & opc != 1);
        }while(opc == 1);
        cpu.mostrarDatosDeMemoriaSecundaria();
    }
}