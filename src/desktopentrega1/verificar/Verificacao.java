//Henrique Bezerra Lucas - RA: 2312808
//Patrick de Almeida Quine
package desktopentrega1.verificar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author henri
 */
public class Verificacao {
    
    public static boolean isValidCPF(String cpf) {
        //Usada para calcular os digitos verificadores
        int soma = 0;
        
        cpf = cpf.replaceAll("[^\\d]", "");
        
        // verificar tamanho == 11
        if (cpf.length() != 11) {
           
            return false;
        }

        // calculando digitos verificadores
        for (int i = 0; i < 9; i++) {
            
            soma += Integer.parseInt(cpf.substring(i, i+1)) * (10 - i);
        }
        int resto = 11 - (soma % 11);
        int dig1 = (resto >= 10) ? 0 : resto;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(cpf.substring(i, i+1)) * (11 - i);
        }
        resto = 11 - (soma % 11);
        int dig2 = (resto >= 10) ? 0 : resto;
        
        // validar se os verificadores estão corretos
        
        boolean resultado = (dig1 == Integer.parseInt(cpf.substring(9, 10)))
                    && (dig2 == Integer.parseInt(cpf.substring(10)));
     
        
        return resultado;
    }
    
    public static boolean isValidEmail(String email) {
        
        // verifica se começa ou termina com .
        if (email.startsWith(".") || email.endsWith(".")) {
            
            //System.out.println("Erro 1 - Email");
            return false;
        }
        
        // confirma se tem apenas um @
        if (email.indexOf('@') == -1 || email.indexOf('@') != email.lastIndexOf('@')) {
            
            //System.out.println("Erro 2 - Email");
            return false;
        }

        // confirma existência domínio  
        if (email.lastIndexOf('.') < email.indexOf('@')) {
           
            //System.out.println("Erro 3 - Email");
            return false;
        }

        // verificar se o último . está depois do último @
        if (email.lastIndexOf('.') < email.lastIndexOf('@')) {
            
            return false;
        }

        String validos = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
        
        Pattern pattern = Pattern.compile(validos);  
        //Instancia de um verificador   
        
        Matcher matcher = pattern.matcher(email);   
        // verificar se não tem caracteres inválidos
        if(!(matcher.matches())){
            System.out.println("Erro 4 - Email" + email);
        }


        return matcher.matches();
    }
    
}
