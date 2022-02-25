package com.gabrielpeixoto.ifarm;

import com.gabrielpeixoto.ifarm.cliente.Cliente;
import com.gabrielpeixoto.ifarm.farmacia.Farmacia;
import com.gabrielpeixoto.ifarm.produto.Produto;
import com.gabrielpeixoto.ifarm.produto.enums.TipoProduto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Cliente> clientes = new ArrayList<>();
        List<Farmacia> farmacias = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int entrada;

        System.out.println("Bem-vindo ao iFarm. O que deseja fazer?");
        do {
            System.out.println("1- Cadastrar um cliente");
            System.out.println("2 - Cadastrar uma farmácia");
            System.out.println("3 - Cadastrar um produto em uma farmácia");
            System.out.println("4 - Exibir clientes cadastrados");
            System.out.println("5 - Exibir farmácias cadastradas");
            System.out.println("6 - Realizar uma compra");
            System.out.println("0 - Sair");
            entrada = in.nextInt();

            switch (entrada)
            {
                case 0:
                    break;

                case 1:
                    cadastrarCliente(in, clientes);
                    break;

                case 2:
                    cadastrarFarmacia(in, farmacias);
                    break;

                case 3:
                    cadastrarProdutoFarmacia(in, farmacias);
                    break;

                case 4:
                    exibirClientes(clientes);
                    break;

                case 5:
                    exibirFarmacias(farmacias);
                    break;

                case 6:
                    realizarCompra(in, farmacias, clientes);
                    break;
            }
        }while (entrada != 0);
    }

    private static Farmacia obterFarmacia(List<Farmacia> farmacias, String nome)
    {
        for(Farmacia f : farmacias)
            if(f.getRazaoSocial().equalsIgnoreCase(nome))
                return f;
        return null;
    }

    private static Cliente obterCliente(List<Cliente> clientes, String nome)
    {
        for(Cliente c : clientes)
            if(c.getNome().equalsIgnoreCase(nome))
                return c;
        return null;
    }

    private static void realizarCompra(Scanner in, List<Farmacia> farmacias, List<Cliente> clientes) {
        System.out.println("Escolha a farmácia de destino: ");
        exibirFarmacias(farmacias);
        String nome = in.next();
        Farmacia f = obterFarmacia(farmacias, nome);

        System.out.println("Escolha o cliente que irá fazer a transição: ");
        exibirClientes(clientes);
        String nome2 = in.next();
        Cliente c = obterCliente(clientes, nome2);

        System.out.println("Digite o nome do produto que quer comprar:");
        f.exibirProdutos();
        String prod = in.next();
        List<Produto> lp = f.buscarProdutoPorNome(prod);

        if(lp.size() > 0)
        {
            System.out.println("Compra de " + lp.get(0) + " feita na " + nome + " por " + nome2);
        }
        else
            System.out.println("Produto não existente");
    }

    private static void cadastrarProdutoFarmacia(Scanner in, List<Farmacia> farmacias) throws ParseException {
        String nome, validade;
        Integer tipo, qtd;
        Double preco;
        System.out.println("Digite o nome do produto: ");
        nome = in.next();
        System.out.println("Digite a data de validade (dd/mm/aaaa): ");
        validade = in.next();
        System.out.println("Digite a quantidade de itens a entrar no estoque: ");
        qtd = in.nextInt();
        System.out.println("Digite o preço do produto: ");
        preco = in.nextDouble();
        System.out.println("(1) Medicamento, (2) Cuidados pessoais, (3) Alimento ou (4) Equipamento? ");
        tipo = in.nextInt();

        Date d = new SimpleDateFormat("dd/MM/yyyy").parse(validade);
        TipoProduto tp = null;
        if(tipo == 1)
            tp = TipoProduto.MEDICAMENTO;
        else if(tipo == 2)
            tp = TipoProduto.CUIDADOS_PESSOAIS;
        else if(tipo == 3)
            tp = TipoProduto.ALIMENTO;
        else if(tipo == 4)
            tp = TipoProduto.EQUIPAMENTO;

        Produto p = new Produto(nome, tp, qtd, d, preco);

        System.out.println("Escolha a farmácia de destino: ");
        exibirFarmacias(farmacias);
        nome = in.next();
        for(Farmacia fm : farmacias)
            if(fm.getRazaoSocial().equalsIgnoreCase(nome))
                fm.inserirProduto(p);

    }

    private static void cadastrarFarmacia(Scanner in, List<Farmacia> farmacias) {
        String razao2 = "Santa_Lucia";
        String endereco2 = "Av. ABC, 123";
        String cnpj2 = "1111111111/111.1";
        Farmacia f2 = new Farmacia(razao2, endereco2, cnpj2);

        String razao3 = "Drogamar";
        String endereco3 = "Av. São Paulo, 333";
        String cnpj3 = "1111111123/111.1";
        Farmacia f3 = new Farmacia(razao3, endereco3, cnpj3);

        String razao4 = "Drogasil";
        String endereco4 = "Rua das Palmeiras, 123";
        String cnpj4 = "1144111111/111.5";
        Farmacia f4 = new Farmacia(razao4, endereco4, cnpj4);
        farmacias.addAll(Arrays.asList(f2, f3, f4));
        System.out.println("Farmácias cadastradas");
    }

    private static void cadastrarCliente(Scanner in, List<Cliente> clientes) {
        String nome = "Antonio A.";
        String endereco = "Rua X, 23";
        String telefone = "99111-1111";
        String cpf = "111.111.111-11";
        Cliente c = new Cliente(nome, endereco, telefone, cpf);

        String nome2 = "Bruna B.";
        String endereco2 = "Rua asasf, 44";
        String telefone2 = "99212-1231";
        String cpf2 = "122.222.222-22";
        Cliente c2 = new Cliente(nome2, endereco2, telefone2, cpf2);

        String nome3 = "Carlos A.";
        String endereco3 = "Rua Itabira, 99";
        String telefone3 = "99111-4567";
        String cpf3 = "111.333.333-33";
        Cliente c3 = new Cliente(nome3, endereco3, telefone3, cpf3);

        clientes.addAll(Arrays.asList(c, c2, c3));
        System.out.println("Clientes cadstrados");
    }

    public static void exibirClientes(List<Cliente> c)
    {
        System.out.println(c);
    }

    public static void exibirFarmacias(List<Farmacia> f)
    {
        System.out.println(f);
    }
}
