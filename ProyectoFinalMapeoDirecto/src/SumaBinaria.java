public class SumaBinaria {
    public static String sumarBinarios(String a, String b) {
        String binarioA = a;
        String binarioB = b;

        // Asegurar que ambos números tienen la misma longitud
        int maxLength = Math.max(binarioA.length(), binarioB.length());
        binarioA = String.format("%" + maxLength + "s", binarioA).replace(' ', '0');
        binarioB = String.format("%" + maxLength + "s", binarioB).replace(' ', '0');

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
        String resultadoFinal = resultado.toString();
        if (resultadoFinal.length() < 6) {
            resultadoFinal = String.format("%6s", resultadoFinal).replace(' ', '0');
        } else if (resultadoFinal.length() > 6) {
            resultadoFinal = resultadoFinal.substring(resultadoFinal.length() - 6);
        }

        return resultadoFinal;
    }
}