
package model;

import java.io.Serializable;

/**
 *
 * @author henri
 */
public class Pedido  implements Serializable {
    private static long serialVersionUID = 1L;
    private int codigo;
    private int codigoProduto;
    private String clienteCPF;
    private String transportadora;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return  codigo + "-" + codigoProduto + "-" + clienteCPF + "-"+ transportadora + "-" + descricao + '\n';
    }
    
    
    
}
