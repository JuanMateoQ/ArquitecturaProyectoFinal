public class MultiplicacionBinaria {
    public static Binario multiplicarBinario(Binario a, Binario b) {
        String binarioA = a.getNumeroBinario();
        String binarioB = b.getNumeroBinario();

        int maxLength = binarioA.length() + binarioB.length();
        int[] producto = new int[maxLength];

        // Multiplicación de binarios
        for (int i = binarioB.length() - 1; i >= 0; i--) {
            int bitB = binarioB.charAt(i) - '0';
            for (int j = binarioA.length() - 1; j >= 0; j--) {
                int bitA = binarioA.charAt(j) - '0';
                producto[i + j + 1] += bitA * bitB;
            }
        }

        // Manejo de acarreos
        for (int i = maxLength - 1; i > 0; i--) {
            if (producto[i] >= 2) {
                producto[i - 1] += producto[i] / 2;
                producto[i] %= 2;
            }
        }

        // Convertir el resultado a cadena binaria
        StringBuilder resultado = new StringBuilder();
        for (int num : producto) {
            resultado.append(num);
        }

        // Quitar ceros a la izquierda
        while (resultado.length() > 1 && resultado.charAt(0) == '0') {
            resultado.deleteCharAt(0);
        }

        // Asegurar que el resultado tenga 6 bits
        while (resultado.length() < 6) {
            resultado.insert(0, '0');
        }

        System.out.println("Resultado de la multiplicación en 6 bits: " + resultado);
        return null;
    }
}
