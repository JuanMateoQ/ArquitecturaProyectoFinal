public class SumaBinaria {
    public static Binario sumarBinarios(Binario a, Binario b) {
        String binarioA = a.getNumeroBinario();
        String binarioB = b.getNumeroBinario();

        // Asegurar que ambos números tienen la misma longitud
        int maxLength = Math.max(binarioA.length(), binarioB.length());
        binarioA = String.format("%0" + maxLength + "d", Integer.parseInt(binarioA));
        binarioB = String.format("%0" + maxLength + "d", Integer.parseInt(binarioB));

        StringBuilder resultado = new StringBuilder();
        int acarreo = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int sumaBits = (binarioA.charAt(i) - '0') + (binarioB.charAt(i) - '0') + acarreo;
            resultado.insert(0, sumaBits % 2);
            acarreo = sumaBits / 2;
        }

        if (acarreo == 1) {
            resultado.insert(0, '1');
        }

        // Asegurar que el resultado tenga 6 bits
        while (resultado.length() < 6) {
            resultado.insert(0, '0');
        }

        // Verificar si el resultado excede los 6 bits
        if (resultado.length() > 6) {
            System.out.println("Error: El resultado de la suma binaria excede 6 bits.");
            return null;
        } else {
            System.out.println("Resultado de la suma en 6 bits: " + resultado);
            return new Binario(Integer.parseInt(resultado.toString(), 2));
        }
    }
}
