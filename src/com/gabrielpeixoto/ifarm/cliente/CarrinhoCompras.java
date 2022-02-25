package com.gabrielpeixoto.ifarm.cliente;

import com.gabrielpeixoto.ifarm.farmacia.Farmacia;
import com.gabrielpeixoto.ifarm.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Produto> cesta;
    private Farmacia vendedor;

    public CarrinhoCompras(Farmacia vendedor) {
        this.vendedor = vendedor;
        this.cesta = new ArrayList<>();
    }

    public void incluirProduto(Produto p)
    {
        this.cesta.add(p);
    }

    public void retirarProduto(Produto p)
    {
        this.cesta.remove(p);
    }

    public Double calcularPrecoTotal()
    {
        Double pt = 0.0;
        for(Produto p : this.cesta)
            pt += p.getPreco();
        return pt;
    }

    public void finalizarCompra()
    {
        for(Produto p : cesta)
            p.reduzirQuantidade(-1);
        System.out.println("Obrigado por comprar na " + this.vendedor.getRazaoSocial()
        + ". Seu(s) produto(s) chegará(ão) em breve.");
    }
}
