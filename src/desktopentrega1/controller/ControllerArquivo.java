package desktopentrega1.controller;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author fabricio@utfpr.edu.br
 */
public abstract class ControllerArquivo {
    protected File arquivo = null;
    public abstract boolean ler();
    public abstract boolean escrever(boolean append);
    
    /**
     * @return the arquivo
     */
    public File getArquivo() {
        return arquivo;
    }

    /**
     * @param TextoBotao o texto para o botão de escolha do usuário
     * caso o arquivo já tenha sido escolhido então não mudará
     */
    public void setArquivo(String TextoBotao) {
        if(arquivo==null){
            arquivo = null;
            String pastainicial = System.getProperty("user.dir");
            JFileChooser chooser = new JFileChooser(pastainicial);
            if (chooser.showDialog(null, TextoBotao) == JFileChooser.APPROVE_OPTION) {
                arquivo = chooser.getSelectedFile();
            } 
        }
           
    }
}
