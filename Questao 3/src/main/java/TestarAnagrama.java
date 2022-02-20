import java.math.BigInteger;

public class TestarAnagrama {
    private final static int MAX_ANAGRAMAS = 10;

    private static BigInteger fatorial(int num) {
        BigInteger resultado = BigInteger.ONE;
        for (int i=1; i<=num; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i)) ;
        }
        return resultado;
    }



    public static String[] criarAnagramas(String palavra) {
        String[] retorno;
        palavra = palavra.toUpperCase();
        if (palavra.length() == 1) {
            retorno = new String[1];
            retorno[0]=palavra;
        } else {

            //Conta repetições de letras
            int[] repeticoes = new int[palavra.length()];
            char[] letras = new char[palavra.length()];
            int[]posicoes = new int[palavra.length()];
            int numLetrasDistintas = 0;
            for (int i=0; i<palavra.length(); i++){
                int lugar =-1;
                for (int j=0; j<numLetrasDistintas; j++) {
                    if (letras[j] == palavra.charAt(i))
                    {
                        lugar=j;
                        break;
                    }
                }

                if(lugar < 0){
                    letras[numLetrasDistintas] = palavra.charAt(i);
                    posicoes[numLetrasDistintas] = i;
                    repeticoes[numLetrasDistintas]++;
                    numLetrasDistintas++;
                } else {
                    repeticoes[lugar]++;
                }
            }

            //Calcula o número de anagramas possíveis
            BigInteger numAnagramasSemRepeticao = fatorial(palavra.length());
            for (int i=0; i<numLetrasDistintas; i++) {
                numAnagramasSemRepeticao =
                        numAnagramasSemRepeticao.divide(fatorial(repeticoes[i])) ;
            }

            //Cria o vetor que guardará os anagramas
            if (numAnagramasSemRepeticao.compareTo(
                    BigInteger.valueOf(MAX_ANAGRAMAS)) <= 0)
                retorno = new String[numAnagramasSemRepeticao.intValue()];
            else
                retorno = new String[MAX_ANAGRAMAS];


            /*
             Percorre cada letra distinta, colocando em sequência
             na primeira posição e gerando os anagramas para o resto
             */
            int k=0;
            for (int i =0; i<numLetrasDistintas; i++) {

                String resto = palavra.substring(0, posicoes[i]) +
                        palavra.substring(posicoes[i]+1);
                String[] anagramasResto = criarAnagramas(resto);
                for (int j=0; j<anagramasResto.length; j++) {
                    retorno[k] = letras[i]+anagramasResto[j];
                    k++;
                    if (k > MAX_ANAGRAMAS - 1)
                        break;
                }
                if (k > MAX_ANAGRAMAS - 1)
                    break;
            }
        }

        return retorno;
    }
}
