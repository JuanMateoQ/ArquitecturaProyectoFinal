public class Binario {
    private static String numeroBinario;

    public Binario(int numeroEntero) {
        numeroBinario = convertir(numeroEntero);
        convertir(numeroEntero);
    }
    public static String convertir(int num) {
        if (num < -64 || num > 31) {
            System.out.println("Ingrese valores entre -64 y 31 inclusive.");
            return null;
        }

        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num; // Usamos el valor absoluto
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 5; i >= 0; i--) {
            int mask = 1 << i;
            if ((num & mask) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        if (isNegative) {
            // Aplicar complemento a 2
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : '0');
            }
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    break;
                } else {
                    sb.setCharAt(i, '0');
                }
            }
        }

        return sb.toString();
    }
    public int getNumero(){
        return convertirADecimal();
    }


    public String getNumeroBinario() {
        return numeroBinario;
    }
    public static int convertirADecimal() {
        if (numeroBinario.length() != 6) {
            throw new IllegalArgumentException("El número binario debe tener 6 dígitos");
        }

        // Verificar si el número es negativo (bit más significativo es 1)
        boolean isNegative = numeroBinario.charAt(0) == '1';

        int resultado = 0;
        if (isNegative) {
            // Si es negativo, primero aplicamos el complemento a 1
            StringBuilder complemento = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                complemento.append(numeroBinario.charAt(i) == '0' ? '1' : '0');
            }

            // Convertimos el complemento a 1 a decimal
            for (int i = 1; i < 6; i++) {
                if (complemento.charAt(i) == '1') {
                    resultado += Math.pow(2, 5 - i);
                }
            }

            // Sumamos 1 y negamos el resultado
            resultado = -(resultado + 1);
        } else {
            // Si es positivo, simplemente convertimos a decimal
            for (int i = 1; i < 6; i++) {
                if (numeroBinario.charAt(i) == '1') {
                    resultado += Math.pow(2, 5 - i);
                }
            }
        }

        return resultado;
    }

}
