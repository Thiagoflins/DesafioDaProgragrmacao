import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> Esc = new ArrayList<>();
        System.out.print("Informe o número de degraus desejado: ");
        int nDegraus = sc.nextInt();
        
        for (int i = 0; i < nDegraus; i++) {
            Esc.add(" ".repeat(nDegraus - i) + "*".repeat(i + 1));
        }
        for (String d : Esc ) {
            System.out.println(d);
        }
    }
}

