package com.gabrielpeixoto.ifarm.cliente;

import com.gabrielpeixoto.ifarm.farmacia.Farmacia;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private CarrinhoCompras compras;

    public Cliente(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CarrinhoCompras getCompras() {
        return compras;
    }

    public void inicializarCompras(Farmacia f) {
        this.compras = new CarrinhoCompras(f);
    }

    @Override
    public String toString() {
        return "Cliente " +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'';
    }
}
