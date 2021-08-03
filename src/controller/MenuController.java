package controller;

import java.util.ArrayList;

import model.Product;
import model.User;
import utils.Sc;

public class MenuController {
    private ArrayList<User> usuarios;
    private ArrayList<Product> products;

    public MenuController() {
        this.usuarios = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void cadastroNovoCliente() {
        System.out.println("Quantos clientes você deseja cadastrar: ");
        int qntClients = Sc.nextInt();
        // for para percorrer a quantidade de vezes que a pessoa quer cadastras os
        // clientes dentro da lista
        for (int i = 1; i <= qntClients; i++) {
            System.out.println("Qual é o seu nome: ");
            String name = Sc.nextLine();

            System.out.println("Qual é o seu endereço: ");
            String adress = Sc.nextLine();

            System.out.println("Qual é o seu telefone: ");
            String telephone = Sc.nextLine();

            // aloca a entrada do usuário em cada um dos atributos da classe User
            usuarios.add(new User(name, adress, telephone));
        }
    }

    public void buscarNovoCliente() {
        boolean search = false;
        System.out.println("Insira o seu nome para ser pesquisado: ");
        String name = Sc.nextLine();
        // foreach para percorrer a lista dos usuários e comparar o nome que foi
        // inserido com o da lista.
        for (User usuario : usuarios) {
            String nameUsuario = usuario.getName();
            // if do comparador, quando ele compara se for true ele entra dentro do if e
            // printa as informações do cliente.
            if (name.equals(nameUsuario)) {
                System.out.println("Nome encontrado!");
                // puxa as informações da lista usuario que foi criada lá em cima, printando ao
                // usuário.
                System.out.println("Nome: " + usuario.getName() + "\n" + "Endereço: " + usuario.getAdress() + "\n"
                        + "Telefone: " + usuario.getTelephone());
                // logica para alterar algum dado de algum cliente caso o user queira.
                System.out.println("Você deseja alterar algum dado do cliente: [1]Sim / [2]Não");
                int op = Sc.nextInt();
                // Se o usuário digitar 2 ele volta ao menu principal.
                if (op == 2) {
                    System.out.println("Voltando ao menu principal!");
                }
                while (op == 1) {
                    System.out.println("Oque você deseja alterar: [1]Nome / [2]Endereço / [3]Telefone / [4]Sair");
                    int opalterar = Sc.nextInt();
                    // switch para alteração dos dados
                    switch (opalterar) {
                        case 1:
                            System.out.println("Qual nome você deseja colocar: ");
                            // recebe a string que vai ser alocada por cima de outra
                            String nameAlterado = Sc.nextLine();
                            // puxa a informação, essa informação depende do setATRIBUTO, onde a var dentro
                            // dos () vai ser alocada na list.
                            usuario.setName(nameAlterado);
                            System.out.println("Sucesso! Nome alterado para: " + usuario.getName());
                            break;
                        case 2:
                            System.out.println("Qual endereço você deseja colocar: ");
                            String adressAlterado = Sc.nextLine();
                            usuario.setAdress(adressAlterado);
                            System.out.println("Sucesso! Endereço alterado para: " + usuario.getAdress());
                            break;
                        case 3:
                            System.out.println("Qual telefone você deseja colocar: ");
                            String telephoneAlterado = Sc.nextLine();
                            usuario.setTelephone(telephoneAlterado);
                            System.out.println("Sucesso! Telefone alterado para: " + usuario.getTelephone());
                            break;
                        case 4:
                            // caso o usuário queira sair do menu, o op que é a var do switch contara 1++,
                            // comparando com == 1, ele irá sair do switch.
                            op++;
                            break;
                        default:
                            break;
                    }
                }
                // boolean da procura alterado para verdadeiro pois foi achado.
                search = true;
            }
        }
        // se for diferente da procura ele printa que o nome não foi encontrado
        if (!search) {
            System.out.println("Nome não encontrado!");
        }
    }

    public void cadastroNovoProduto() {
        System.out.println("Quantos produtos você deseja cadastrar: ");
        int qntProducts = Sc.nextInt();
        // for para percorrer toda a arraylist e cadastrar cada uma em seu determinado
        // lugar na lista.
        for (int j = 1; j <= qntProducts; j++) {
            System.out.println("Qual é o nome do produto: ");
            String nameProduct = Sc.nextLine();

            System.out.println("Qual é a descrição do produto: ");
            String description = Sc.nextLine();

            System.out.println("Qual é o valor da compra: ");
            double value = Sc.nextInt();

            System.out.println("Qual é a porcentagem de lucro: ");
            double percentage = Sc.nextInt();

            System.out.println("Qual é a quantidade em estoque: ");
            int quantity = Sc.nextInt();

            // adiciona todos os elementos inseridos pelo usuário na arraylist.
            products.add(new Product(nameProduct, description, value, percentage, quantity));
        }
    }

    public void buscarNovoProduto() {
        // boolean para fazer a logica da pesquisa, iniciando com falso pois ainda não
        // foi achado
        boolean searchProduct = false;
        // insert do produto
        System.out.println("Insira o produto a ser pesquisado: ");
        String nomeProduct = Sc.nextLine();
        // foreach para percorrer a arraylist products
        for (Product produto : this.products) {
            // a var nameProduct recebe o nome do produto da lista
            String nameProduct = produto.getNameProduct();
            // e compara com a que o user inseriu no nome a ser pesquisado, caso seja entra
            // no if
            if (nomeProduct.equalsIgnoreCase(nameProduct)) {
                System.out.println("Produto encontrado!");
                // e printara os atributos do produto
                System.out.println("Nome: " + produto.getNameProduct() + "\n" + "Descrição: " + produto.getDescription()
                        + "\n" + "Valor: " + produto.getValue() + "\n" + "Porcentagem de lucro: "
                        + produto.getPercentage() + "\n" + "Quantidade: " + produto.getQuantity());
                // pergunta se quer fazer alguma alteração
                System.out.println("Você deseja alterar algum dado do produto: [1]Sim / [2]Não");
                int opProd = Sc.nextInt();
                // se for == 2 volta ao menu
                if (opProd == 2) {
                    System.out.println("Voltando ao menu principal!");
                }
                // caso seja == 1, entra no while
                while (opProd == 1) {
                    // mini switch para alteração em atributos do produto
                    System.out.println(
                            "Oque você deseja alterar: [1]Nome / [2]Descrição / [3]Valor / [4]Porcentagem de lucro / [5]Quantidade / [6]Sair");
                    int opAltProd = Sc.nextInt();
                    switch (opAltProd) {
                        case 1:
                            // pergunta oque vai ser mudado, nesse caso é o nome, porém a logica é a mesma
                            // para o resto
                            System.out.println("Qual nome você deseja colocar: ");
                            // a var recebe
                            String nomeAltProd = Sc.nextLine();
                            // apos receber oque o usuário digitou, ele seta oque sera mudado dentro da
                            // arraylist produto,
                            produto.setNameProduct(nomeAltProd);
                            System.out.println("Sucesso! Nome alterado para: " + produto.getNameProduct());
                            break;
                        case 2:
                            System.out.println("Qual descrição você deseja colocar: ");
                            String descAltProd = Sc.nextLine();
                            produto.setDescription(descAltProd);
                            System.out.println("Sucesso! Descrição alterada para: " + produto.getDescription());
                            break;
                        case 3:
                            System.out.println("Qual valor você deseja colocar: ");
                            Double valorAltProd = Sc.nextDouble();
                            produto.setValue(valorAltProd);
                            System.out.println("Sucesso! Valor alterado para: " + produto.getValue());
                            break;
                        case 4:
                            System.out.println("Qual porcentagem você deseja colocar: ");
                            Double percentAltProd = Sc.nextDouble();
                            produto.setPercentage(percentAltProd);
                            System.out.println("Sucesso! Porcentagem alterada para: " + produto.getPercentage());
                            break;
                        case 5:
                            System.out.println("Qual quantidade você deseja colocar: ");
                            int quantAltProd = Sc.nextInt();
                            produto.setQuantity(quantAltProd);
                            System.out.println("Sucesso! Quantidade alterada para: " + produto.getQuantity());
                            break;
                        case 6:
                            // caso conte 1 irá sair do switch
                            opProd++;
                            break;
                        default:
                    }
                }
                // ao final de tudo, a pesquisa sai como true pois foi achada.
                searchProduct = true;
            }
        }
        // caso seja diferente entra no if e printa
        if (!searchProduct) {
            System.out.println("Produto não encontrado!");
        }
    }
}
