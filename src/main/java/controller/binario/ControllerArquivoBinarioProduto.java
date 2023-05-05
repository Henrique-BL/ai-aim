package controller.binario;

import  model.Produto;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Henrique RA 2312808
 */
public class ControllerArquivoBinarioProduto extends ControllerArquivoBinario{

    protected Produto produto;
    protected ArrayList<Produto> produtos = new ArrayList();

    /*Define o arquivo para salvar os produtos e alimenta o arrayList com os dados do a
    arquivo*/
    public void lerProdutos() {
        
         
        produtos.clear();  
        setArquivo("Abrir arquivo de Produtos");
        ler();
        if(getObjeto()!=null){
            
            produtos = (ArrayList<Produto>) getObjeto();

        }
    }

    /*Salva todos os produtos do array no arquivo*/
    public void gravarProdutos() {

        setObjeto(new ArrayList(Arrays.asList(produtos.toArray())));
        setArquivo("Salvar");
        escrever(false);

    }


    /*Recebe o nome de um produto e devolve o objeto correspondente no array*/
    public Produto buscarProduto(String nome) {
        lerProdutos();
        for (Produto produto : produtos) {

            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;

    }

    /*Recebe o código de um produto e devolve o objeto correspondente do array*/
    public Produto buscarProduto(int codigo) {
        lerProdutos();
        for (Produto produto : produtos) {

            if (produto.getId() == codigo) {
                return produto;
            }
        }
        return null;

    }

    /*Recebe um produto alterado, modifica no arquivo e no arrray*/
    public boolean editarProduto(Produto produto) {
        Produto aux = buscarProduto(produto.getId());
        int index = produtos.indexOf(aux);
        produtos.set(index, produto);
        gravarProdutos();
        return true;

    }

    /*Recebe o nome de um produto e exclui ele do aray e do arquivo*/
    public Produto excluirProduto(String nome) {
        Produto produto = buscarProduto(nome);
        int index = produtos.indexOf(produto);
        produtos.remove(index);
        gravarProdutos();
        return produto;

    }

    /**
     * @return the produto
     */
    public ArrayList<Produto> getProdutos() {
        lerProdutos();
        return produtos;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        produtos.add(produto);
        this.produto = produto;
    }

}
