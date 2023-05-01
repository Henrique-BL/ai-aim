package desktopentrega1.controller;

import desktopentrega1.model.Produto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Henrique RA 2312808
 */
public class ControllerArquivoTextoProduto extends ControllerArquivoTexto {

    protected Produto produto;
    protected ArrayList<Produto> produtos = new ArrayList();

    /*Define o arquivo para salvar os produtos e alimenta o arrayList com os dados do a
    arquivo*/
    public void lerProdutos() {
        produtos.clear();
        setArquivo("Abrir arquivo de Produtos");
        ler();
        String aux = getTexto();
        StringTokenizer tokens = new StringTokenizer(aux, "\n-");
        
        while (tokens.hasMoreTokens()) {
            try {
                produto = new Produto();
                produto.setId(Integer.parseInt(tokens.nextToken()));
                produto.setNome(tokens.nextToken());
                
                produto.setDescricao(tokens.nextToken());
                produto.setDataCompra(new SimpleDateFormat("dd/MM/yyyy").parse(tokens.nextToken()));
              
                produto.setDataVencimento(new SimpleDateFormat("dd/MM/yyyy").parse(tokens.nextToken()));

                produtos.add(produto);
            } catch (ParseException ex) {
                System.out.println("Erro: conversão das datas\n");
                ex.printStackTrace();

            }
        }

    }

    /*Salva todos os produtos do array no arquivo*/
    public void gravarProdutos() {
        String aux = "";

        for (Produto produto : produtos) {
            aux = aux + produto.toString();

        }
        setTexto(aux);
        setArquivo("Salvar");
        escrever(false);

    }

    /*Salva um produto no arquivo*/
    public void gravarProduto() {
        String aux = produto.toString();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);

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
