package desktopentrega1.controller;
import desktopentrega1.model.Cliente;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author henri
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {
    
    protected Cliente cliente;
    protected ArrayList<Cliente> clientes = new ArrayList();

    public void lerClientes() {
        clientes.clear();
        setArquivo("Abrir");
        ler();
        String aux = getTexto();
        StringTokenizer auxiliar = new StringTokenizer(aux, "\n");
        
        while(auxiliar.hasMoreTokens()){
            StringTokenizer tokens = new StringTokenizer(auxiliar.nextToken(),"-");
            while (tokens.hasMoreTokens()) {
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
        
    }

    public void gravarClientes() {
        String aux = "";
                    
        for(Cliente cliente: clientes){
            aux = aux + cliente.toString();

        }
        setTexto(aux);
        setArquivo("Salvar");
        escrever(false);
       

    }
    public void gravarCliente() {
        String aux = cliente.toString();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
       

    }
    public Cliente buscarCliente(String cpf){
        lerClientes();
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
        
    }
    public boolean editarCliente(Cliente cliente){
        
        Cliente aux = buscarCliente(cliente.getCpf());
        int index = clientes.indexOf(aux);
        clientes.set(index, cliente);
        gravarClientes();
        return true;
        
        
    }
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
