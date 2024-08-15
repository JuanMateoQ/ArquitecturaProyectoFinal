import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CPU cpu = new CPU();

    public static void main(String[] args) {
        int númeroOperaciónARealizar = 0;
        ingresarValoresAMemoriaSecundaria();
        cpu.guardarOperación(escogerOpcionesARealizarEnCpu(númeroOperaciónARealizar));
        escogerPosiciónDeValoresAOperar();
    }

    private static void escogerPosiciónDeValoresAOperar() {
        cpu.mostrarDatosDeMemoriaPrinciapal();
        int valor1, valor2;
        System.out.println("Ingrese la posición del Primer Valor a Operar: ");
        valor1 = scanner.nextInt();
        System.out.println("Ingrese la posición del Segundo Valor a Operar: ");
        valor2 = scanner.nextInt();
        //cpu.cargarValoresACache(valor1);
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

    private static void ingresarValoresAMemoriaSecundaria() {
        System.out.println("| INGRESE LOS VALORES A ALMACENAR EN MEMORIA SECUNDARIA... |");
        int opc;
        do{
            System.out.println("Valor a ingresar:");
            int aux = scanner.nextInt();
            cpu.guardarEnMemoriaSecundaria(aux);
            do{
                System.out.println("Desea seguir ingresando más valores...\n 1:SI  0:NO");
                opc = scanner.nextInt();
                System.out.println("\n");
            }while((opc != 0 & opc != 1)& (cpu.getCantidadDeValoresEnMemoriaSecundaria() < 14));
        }while(opc == 1);
        cpu.cargarEnMemoriaPrincipal();
    }
}