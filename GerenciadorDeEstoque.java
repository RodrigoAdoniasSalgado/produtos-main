import java.util.ArrayList;

/**
 * Gerencia o estoque de uma empresa.
 * Um estoque é formado por zero ou mais produtos.
 * 
 * Traduzido por Julio César Alves - 2023.10.10
 * 
 * @author (Rodrigo Adonias Salgado) 
 * @version (28/09)
 */
public class GerenciadorDeEstoque
{
    // Uma lista dos produtos.
    private ArrayList<Produto> estoque;

    /**
     * Inicializa o gerenciador de estoque.
     */
    public GerenciadorDeEstoque()
    {
        estoque = new ArrayList<>();
    }

    /**
     * Adiciona um produto à lista.
     * @param item O item a ser adicionado.
     */
    public void adicionarProduto(Produto item)
    {
    if (encontrarProduto(item.obterID()) == null) 
    {
        estoque.add(item);
    }
    else 
    {
        System.out.println("Produto com id " + item.obterID() + " já existe. Não adicionado.");
    }
}
    
    /**
     * Tenta encontrar um produto no estoque com o identificador passado.
     * @return O produto identificado, ou null se não há nenhum produto
     *         com o identificador passado.
     */
    public Produto encontrarProduto(int id)
    {
        for (Produto p : estoque) 
        {
            if (p.obterID() == id) 
            {
                return p;
            }
        }
        return null;
    }
    
    public Produto encontrarProduto(String nome)
    {
        for (Produto p : estoque) 
        {
            if (p.obterNome().equals(nome)) 
            {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Recebe uma entrega de um produto particular.
     * Aumenta a quantidade do produto pela quantidade passada.
     * @param id O identificador do produto.
     * @param quantidade A quantidade a ser aumentada do produto.
     */
    public void receberEntrega(int id, int quantidade)
    {
        Produto p = encontrarProduto(id);
        if (p != null) 
        {
            p.aumentarQuantidade(quantidade);
        }
        else 
        {
            System.out.println("Recebimento: produto com id " + id + " não encontrado.");
        }
    }
    
    /**
     * Localiza um produto com o identificador passado, e retorna
     * quantas unidades dele existem no estoque. Retorna zero
     * se não há nenhum produto com o identificador passado.
     * @param id O identificador do produto.
     * @return A quantidade do produto solicitado em estoque.
     */
    public int quantidadeEmEstoque(int id)
    {
        Produto p = encontrarProduto(id);
        if (p != null) 
        {
            return p.obterQuantidade();
        }
        return 0;
    }

    /**
     * Exibe os detalhes de todos os produtos.
     */
    public void imprimirDetalhesDosProdutos()
    {
        for (Produto p : estoque) 
        {
        System.out.println(p.paraString());
        }
    }
    
    public void imprimirProdutosAbaixoDe(int limite)
    {
        for (Produto p : estoque) 
        {
            if (p.obterQuantidade() < limite) 
            {
                System.out.println(p.paraString());
            }
        }
    }
}
