package desktopentrega1.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author henri
 */

public class Produto  implements Serializable{
    private static long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String descricao;
    private Date dataVencimento;
    private Date dataCompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public String toString() {
        return  id + "-" +  nome + "-" + descricao + "-" + converterData(dataCompra)
                + "-" + converterData(dataVencimento) + '\n';
    }
    
    public String converterData(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String sData = formatter.format(date);
        return sData;
        
    }
}
