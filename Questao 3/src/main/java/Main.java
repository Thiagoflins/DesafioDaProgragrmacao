import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String entrada;
        entrada = s.next();
        anagrama(entrada);
    }
    static void anagrama(String palavra) {
        int paresDeAnagrama = 0;

        HashMap<String, Integer> letrasPalava = new HashMap<>();

        for (int i = 0; i <= palavra.length(); i++) {
            for (int j = i; j < palavra.length(); j++) {

                char[] letra = palavra.substring(i, j + 1).toCharArray();
                Arrays.sort(letra);
                String subletra = new String(letra);


                if (letrasPalava.containsKey(subletra)) {
                    letrasPalava.put(subletra, letrasPalava.get(subletra) + 1);
                } else {
                    letrasPalava.put(subletra, 1);
                }
            }
        }

        for (String cont : letrasPalava.keySet()) {
            int i = letrasPalava.get(cont);
            paresDeAnagrama += (i * (i - 1)) / 2;
        }
        System.out.print("O número de Anagramas na Palavra é de: " + paresDeAnagrama);
    }
}
