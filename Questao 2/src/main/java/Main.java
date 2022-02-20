import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Criar uma senha: ");
        String senha = sc.nextLine();

        if(validandoSenha(senha) == false){
            System.out.println("A senha precisa ter no mínimo 6 digitos com (caracteres epeciais, números, letras maiuscúlas e minúsculas), SENHA FRACA! ");



        } else {
            System.out.println("Parabéns sua senha foi criada com sucesso! SENHA FORTE.");

        }


        System.out.println("Sua senha tem; "+ senha.length()+ " caracteres");

    }
    public static boolean validandoSenha (String validarSenha){

        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{6,12}$";
        Pattern p = Pattern.compile(regex);

        if (validarSenha == null) {
            return false;
        }
        Matcher m = p.matcher(validarSenha);
        return m.matches();
    }
}
