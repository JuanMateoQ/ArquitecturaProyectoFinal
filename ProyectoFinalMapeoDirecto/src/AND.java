public class AND {

    public static String and(String a, String b) {
        String binarioA = a;
        String binarioB = b;

        // Asegurarse de que ambos números tengan 6 bits
        binarioA = String.format("%6s", binarioA).replace(' ', '0');
        binarioB = String.format("%6s", binarioB).replace(' ', '0');

        StringBuilder resultado = new StringBuilder();

        // Realizar la operación AND bit a bit
        for (int i = 0; i < 6; i++) {
            char bitA = binarioA.charAt(i);
            char bitB = binarioB.charAt(i);

            if (bitA == '1' && bitB == '1') {
                resultado.append('1');
            } else {
                resultado.append('0');
            }
        }

        String resultadoFinal = resultado.toString();
        System.out.println("Resultado de la operación AND: " + resultadoFinal);

        return resultadoFinal;
    }
}