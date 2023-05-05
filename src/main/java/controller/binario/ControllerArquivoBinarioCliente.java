package controller.binario;
import  model.Cliente;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Henrique - RA2312808
 */
public class ControllerArquivoBinarioCliente extends ControllerArquivoBinario {
    
    protected Cliente cliente;
    protected ArrayList<Cliente> clientes = new ArrayList();

    /*Define o arquivo para salvar os clientes e alimenta o arrayList com os dados do a
    arquivo*/
    public void lerClientes() {
        clientes.clear();
        setArquivo("Abrir arquivo de Clientes");
        ler();
        
        if(getObjeto()!=null){    
            clientes = (ArrayList<Cliente>) getObjeto();
        }
    }
    
    /*Escreve no arquivo todos os clientes do arrayList*/
    public void gravarClientes() {     
        setObjeto( new ArrayList(Arrays.asList(clientes.toArray())));
        setArquivo("Salvar");
        escrever(false);
       

    }
    
    
    /*Busca cliente no arrayList utilizando o CPF e devolve o objeto correspondente*/
    public Cliente buscarCliente(String cpf){
        lerClientes();
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
        
    }
    
    /*Recebe um cliente com informações modificadas e altera no arquivo*/
    public boolean editarCliente(Cliente cliente){
        
        Cliente aux = buscarCliente(cliente.getCpf());
        int index = clientes.indexOf(aux);
        clientes.set(index, cliente);
        gravarClientes();
        return true;
        
        
    }
    
    /*Recebe o CPF de um cliente existente e exclui ele do arquivo*/
    public Cliente excluirCliente(String cpf){
        Cliente cliente = buscarCliente(cpf);
        int index = clientes.indexOf(cliente);
        clientes.remove(index);
        gravarClientes();
        return cliente;
        
    }

    /**
     * @return the cliente
     */
    public ArrayList<Cliente> getClientes() {
        lerClientes();
        return clientes;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        clientes.add(cliente);
        this.cliente = cliente;
    }



   
}
