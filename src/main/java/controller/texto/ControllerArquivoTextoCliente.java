package controller.texto;
import model.Cliente;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Henrique - RA2312808
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {
    
    protected Cliente cliente;
    protected ArrayList<Cliente> clientes = new ArrayList();

    /*Define o arquivo para salvar os clientes e alimenta o arrayList com os dados do a
    arquivo*/
    public void lerClientes() {
        clientes.clear();
        setArquivo("Abrir arquivo de Clientes");
        ler();
        String aux = getTexto();
        StringTokenizer tokens =  new StringTokenizer(aux,"\n-");
        while(tokens.hasMoreTokens()){
               cliente = new Cliente();
                cliente.setNome(tokens.nextToken() );
                cliente.setCpf(tokens.nextToken());
                cliente.setEmail(tokens.nextToken());
                cliente.setTelefone(tokens.nextToken());
                cliente.setEndereco(tokens.nextToken());
                cliente.setCep(tokens.nextToken());
                clientes.add(cliente);
            
        }
        
        
    }
    
    /*Escreve no arquivo todos os clientes do arrayList*/
    public void gravarClientes() {
        String aux = "";
                    
        for(Cliente cliente: clientes){
            aux = aux + cliente.toString();

        }
        setTexto(aux);
        setArquivo("Salvar");
        escrever(false);
       

    }
    
    /*Escreve no arquivo apenas um cliente*/
    public void gravarCliente() {
        String aux = cliente.toString();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
       

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
        System.out.println("INDEX" + index);
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
