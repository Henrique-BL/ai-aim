package desktopentrega1.controller;

import desktopentrega1.model.Pedido;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Henrique RA 2312808
 */
public class ControllerArquivoBinarioPedido extends ControllerArquivoBinario {

    protected Pedido pedido;
    protected ArrayList<Pedido> pedidos = new ArrayList();

    /*Define o arquivo para salvar os pedidos e alimenta o arrayList com os dados do 
    arquivo*/
    public void lerPedidos() {
        pedidos.clear();
        setArquivo("Abrir arquivo de Pedidos");
        ler();
        if(getObjeto() != null){
         
            pedidos = (ArrayList<Pedido>) getObjeto();   
        }

    }

    
    /*Grava todos os pedidos do arrayList no arquivo*/
    public void gravarPedidos() {

        setObjeto(new ArrayList(Arrays.asList(pedidos.toArray())));
        setArquivo("Salvar");
        escrever(false);

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
