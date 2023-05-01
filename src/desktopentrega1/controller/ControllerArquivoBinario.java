package desktopentrega1.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author fabricio
 */
public class ControllerArquivoBinario extends ControllerArquivo {

    private ArrayList<Object> objeto = null;
    private ObjectInputStream leitor = null;
    private ObjectOutputStream escritor = null;

    /**
     * @return the cliente
     */
    public Object getObjeto() {
        return objeto;
    }

    /**
     * @param objetos
     * @param cliente the cliente to set
     */
    public void setObjeto(ArrayList<Object> objetos) {
        this.objeto =  objetos;
    }

    @Override
    public boolean ler() {
        try {
            leitor = new ObjectInputStream(new FileInputStream(arquivo));
            objeto = (ArrayList<Object>) leitor.readObject();
            leitor.close();
            return true;
        } catch (ClassNotFoundException erro) {
            //erro.printStackTrace();
            System.err.println(erro.getMessage() + "Classe não encontrada.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo binário.");
            return false;
        }
    }

    @Override
    public boolean escrever(boolean append) {
        if (arquivo != null) {
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append));
                escritor.writeObject(objeto);
                escritor.close();
                return true;
            } catch (IOException erro) {
                erro.printStackTrace();
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }

    /*
     * metodo para ser usado na criação de escritores binarios
     * quando for necessario escrever varios objetos em um mesmo
     * arquivo considerando multiplas execuções da aplicação. 
     */
    public static ObjectOutputStream CriaEscritorObjeto(File arquivo) {
        ObjectOutputStream out = null;
        try {
            if (arquivo.exists()) {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos) {

                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos);
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }
}
