package com.gabrielpeixoto.ifarm.farmacia;

import com.gabrielpeixoto.ifarm.produto.Produto;
import com.gabrielpeixoto.ifarm.produto.enums.TipoProduto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Farmacia {
    private String razaoSocial;
    private String endereco;
    private String cnpj;
    List<Produto> produtos;

    public Farmacia(String razaoSocial, String endereco, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.produtos = new ArrayList<>();
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void inserirProduto(Produto p)
    {
        this.produtos.add(p);
    }

    public void reduzirEstoque(String nome)
    {
        List<Produto> lp = this.produtos.stream()
                .filter(ps -> ps.getNome() == nome)
                .collect(Collectors.toList());
        for(Produto p : lp)
            p.reduzirQuantidade(-1);
    }

    public List<Produto> buscarProdutoPorTipo(TipoProduto p)
    {
        List<Produto> lp = new ArrayList<>();
        lp = this.produtos.stream().filter(ps -> ps.getTipoProduto() == p).collect(Collectors.toList());
        return lp;
    }

    public List<Produto> buscarProdutoPorNome(String p)
    {
        List<Produto> lp = new ArrayList<>();
        lp = this.produtos.stream().filter(ps -> ps.getNome() == p).collect(Collectors.toList());
        return lp;
    }

    public void exibirProdutos()
    {
        System.out.println(this.produtos);
    }

    @Override
    public String toString() {
        return "Farmacia " +
                "razaoSocial= '" + razaoSocial + '\'' +
                ", endereco= '" + endereco + '\'' +
                ", cnpj= '" + cnpj + '\'' +
                '}';
    }
}
