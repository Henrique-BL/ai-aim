package desktopentrega1.controller;
import desktopentrega1.model.Produto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author henri
 */
public class ControllerArquivoTextoProduto extends ControllerArquivoTexto {
    protected Produto produto;
    protected ArrayList<Produto> produtos = new ArrayList();
    
   
    public void lerProdutos() {
        produtos.clear();
        setArquivo("Abrir");
        ler();
        String aux = getTexto();
        StringTokenizer auxiliar = new StringTokenizer(aux, "\n");
        
        while(auxiliar.hasMoreTokens()){
            StringTokenizer tokens = new StringTokenizer(auxiliar.nextToken(),"-");
            while (tokens.hasMoreTokens()) {
                try {
                produto = new Produto();
                produto.setId(Integer.parseInt(tokens.nextToken()));
                produto.setNome(tokens.nextToken() );
                produto.setDescricao(tokens.nextToken());
                produto.setDataCompra(new SimpleDateFormat
                                    ("dd/MM/yyyy").parse(tokens.nextToken()));
                produto.setDataVencimento(new SimpleDateFormat
                                    ("dd/MM/yyyy").parse(tokens.nextToken()));
                
                
                produtos.add(produto);
                } catch (ParseException ex) {
                    System.out.println("Erro: conversão das datas\n");
                    ex.printStackTrace();
                }
            }
        }
        
    }

    public void gravarProdutos() {
        String aux = "";
                    
        for(Produto produto: produtos){
            aux = aux + produto.toString();

        }
        setTexto(aux);
        setArquivo("Salvar");
        escrever(false);
       

    }
    public void gravarProduto() {
        String aux = produto.toString();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
       

    }
    public Produto buscarProduto(String nome){
        lerProdutos();
        for(Produto produto : produtos){
           
            if(produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
        
    }
    public Produto buscarProduto(int codigo){
        lerProdutos();
        for(Produto produto : produtos){
          
            if(produto.getId() == codigo){
                return produto;
            }
        }
        return null;
        
    }
    public boolean editarProduto(Produto produto){
        System.out.println(produto.getNome());
        Produto aux = buscarProduto(produto.getNome());
        int index = produtos.indexOf(aux);
        produtos.set(index, produto);
        gravarProdutos();
        return true;
        
        
    }
    public Produto excluirProduto(String nome){
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
