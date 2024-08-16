public class Binario {
    private String numeroBinario;

    public Binario(int numeroEntero) {
        numeroBinario = convertir(numeroEntero);
    }
    public static String convertir(int num) {
        boolean isNegative = num < 0;
        if (isNegative) {
            num = Math.abs(num);
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
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                } else {
                    sb.setCharAt(i, '0');
                }
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


    public String getNumeroBinario() {
        return numeroBinario;
    }
    public String getNumeroBinario() {
        return numeroBinario;
    }
    public int convertirADecimal() {
        if (numeroBinario.length() != 6) {
            throw new IllegalArgumentException("El número binario debe tener 6 dígitos");
        }

        boolean isNegative = numeroBinario.charAt(0) == '1';

        int resultado = 0;
        if (isNegative) {

            StringBuilder complemento = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                complemento.append(numeroBinario.charAt(i) == '0' ? '1' : '0');
            }

     
            for (int i = 1; i < 6; i++) {
                if (complemento.charAt(i) == '1') {
                    resultado += Math.pow(2, 5 - i);
                }
            }


            resultado = -(resultado + 1);
        } else {
  
            for (int i = 1; i < 6; i++) {
                if (numeroBinario.charAt(i) == '1') {
                    resultado += Math.pow(2, 5 - i);
                }
            }
        }

        return resultado;
    }

}
