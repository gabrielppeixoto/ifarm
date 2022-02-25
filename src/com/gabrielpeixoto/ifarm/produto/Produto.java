package com.gabrielpeixoto.ifarm.produto;

import com.gabrielpeixoto.ifarm.produto.enums.TipoProduto;
import java.time.LocalDate;
import java.util.Date;

public class Produto {
    private String nome;
    private TipoProduto tipoProduto;
    private Integer quantidade;
    private Date dataValidade;
    private Double preco;

    public Produto(String nome, TipoProduto tipoProduto, Integer quantidade, Date dataValidade, Double preco) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void reduzirQuantidade(Integer qtd)
    {
        if(this.quantidade < qtd)
        {
            System.out.println("Quantidade insuficiente em estoque.");
            return;
        }
        this.quantidade -= qtd;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", dataValidade=" + dataValidade;
    }
}
