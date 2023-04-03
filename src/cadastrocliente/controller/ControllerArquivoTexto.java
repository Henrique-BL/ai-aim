package cadastrocliente.controller;

import cadastrocliente.controller.ControllerArquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author fabricio@utfpr.edu.br
 */
public class ControllerArquivoTexto extends ControllerArquivo {

    private String texto = null;
    private BufferedReader leitor = null;
    private BufferedWriter escritor = null;

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return true caso a operação de leitura seja bem sucedida ou false
     * caso contrário.
     */
    @Override
    public boolean ler() {
        StringBuilder line = new StringBuilder();
        try {
            leitor = new BufferedReader(new FileReader(arquivo));
            while (leitor.ready()) {
                line.append(leitor.readLine()).append("\n");
            }
            leitor.close();
            setTexto(line.toString());
            return true;
        } catch (FileNotFoundException erro) {
            //erro.printStackTrace(); //usado para debug
            System.err.println(erro.getMessage() + "Arquivo não encontrado.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo.");
            return false;
        }
    }

    /**
     * @param append se o texto será continuado a partir do seu
     * final (append = true) ou se o arquivo será sobrescrito (append = false)
     * @param texto != null para escrever texto no mesmo arquivo e texto == null
     * para escrever texto copiado de outro arquivo
     * @return true caso a operação de escrita seja bem sucedida ou false
     * caso contrário.
     */
    @Override
    public boolean escrever(boolean append, String texto) {
        if (arquivo != null) {
            try {
                escritor = new BufferedWriter(new FileWriter(arquivo, append));
                if(texto==null){
                    escritor.write(getTexto());
                }else{
                    escritor.write(texto);
                }
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao ler arquivo.");
                return false;
            }
        } else {
            return false;
        }
    }


    
}