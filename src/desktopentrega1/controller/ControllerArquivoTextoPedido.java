package desktopentrega1.controller;

import desktopentrega1.model.Pedido;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Henrique RA 2312808
 */
public class ControllerArquivoTextoPedido extends ControllerArquivoTexto {

    protected Pedido pedido;
    protected ArrayList<Pedido> pedidos = new ArrayList();

    /*Define o arquivo para salvar os pedidos e alimenta o arrayList com os dados do 
    arquivo*/
    public void lerPedidos() {
        pedidos.clear();
        setArquivo("Abrir arquivo de Pedidos");
        ler();
        String aux = getTexto();
        StringTokenizer tokens = new StringTokenizer(aux, "\n-");

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

    
    /*Grava todos os pedidos do arrayList no arquivo*/
    public void gravarPedidos() {
        String aux = "";

        for (Pedido pedido : pedidos) {
            aux = aux + pedido.toString();

        }
        setTexto(aux);
        setArquivo("Salvar");
        escrever(false);

    }

    /*Grava um pedido no arquivo*/
    public void gravarPedido() {
        String aux = pedido.toString();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);

    }
    
    /*Recebe o código do pedido e devolve um objeto Pedido correspondente*/
    public Pedido buscarPedido(int codigo) {
        lerPedidos();
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigo() == codigo) {
                return pedido;
            }
        }
        return null;

    }

    
    /*Recebe um objeto Pedido e altera ele no arrayList e no arquivo*/
    public boolean editarPedido(Pedido pedido) {

        Pedido aux = buscarPedido(pedido.getCodigo());
        int index = pedidos.indexOf(aux);
        pedidos.set(index, pedido);
        gravarPedidos();
        return true;

    }

    /*Recebe o código de um pedido e exclui ele do arquivo e do arrayList*/
    public Pedido excluirPedido(int codigo) {
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
