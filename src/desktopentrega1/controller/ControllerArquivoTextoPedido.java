package desktopentrega1.controller;
import desktopentrega1.model.Pedido;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author henri
 */
public class ControllerArquivoTextoPedido extends ControllerArquivoTexto{
    
    protected Pedido pedido;
    protected ArrayList<Pedido> pedidos = new ArrayList();

    public void lerPedidos() {
        pedidos.clear();
        setArquivo("Abrir");
        ler();
        String aux = getTexto();
        StringTokenizer auxiliar = new StringTokenizer(aux, "\n");
        
        while(auxiliar.hasMoreTokens()){
            StringTokenizer tokens = new StringTokenizer(auxiliar.nextToken(),"-");
            while (tokens.hasMoreTokens()) {
                pedido = new Pedido();
                pedido.setCodigo(Integer.parseInt(tokens.nextToken()));
                pedido.setCodigoProduto(Integer.parseInt(tokens.nextToken()));
                pedido.setClienteCPF(tokens.nextToken());
                pedido.setTransportadora(tokens.nextToken());
                pedido.setDescricao(tokens.nextToken());
                
                pedidos.add(pedido);
            }
        }
        
    }

    public void gravarPedidos() {
        String aux = "";
                    
        for(Pedido pedido: pedidos){
            aux = aux + pedido.toString();

        }
        setTexto(aux);
        setArquivo("Salvar");
        escrever(false);
       

    }
    public void gravarPedido() {
        String aux = pedido.toString();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
       

    }
    public Pedido buscarPedido(int codigo){
        lerPedidos();
        for(Pedido pedido : pedidos){
            if(pedido.getCodigo() == codigo){
                return pedido;
            }
        }
        return null;
        
    }
    public boolean editarPedido(Pedido pedido){
        
        Pedido aux = buscarPedido(pedido.getCodigo());
        int index = pedidos.indexOf(aux);
        pedidos.set(index, pedido);
        gravarPedidos();
        return true;
        
        
    }
    public Pedido excluirPedido(int codigo){
        Pedido pedido = buscarPedido(codigo);
        int index = pedidos.indexOf(pedido);
        System.out.println("INDEX" + index);
        pedidos.remove(index);
        gravarPedidos();
        return pedido;
        
    }

    /**
     * @return the pedido
     */
    public ArrayList<Pedido> getPedidos() {
        lerPedidos();
        return pedidos;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        pedidos.add(pedido);
        this.pedido = pedido;
    }
    
}
