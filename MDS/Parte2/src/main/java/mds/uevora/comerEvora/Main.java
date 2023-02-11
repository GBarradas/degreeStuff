package mds.uevora.comerEvora;

public class Main {

    private static void demo1(){
        Restaurante bk = new Restaurante("BK", "umaPass", "Horta das Figueuiras");

        Categoria hamburguer = new Categoria("Hamburguer");
        Categoria bebidas = new Categoria("Bebidas");
        Categoria batata = new Categoria("Batatas");

        Artigo dCheese = new Artigo("Double Cheese", "Um hamburguer simples com duas fatias de queijo", 2.5, hamburguer, bk );
        Artigo kingBacon = new Artigo("King Bacon", "Carne grelhada com fatias de bacon crocantes", 6.5, hamburguer, bk);
        Artigo kingOvo = new Artigo("King Ovo", "Carne grelbada com ovo estrelado", 7, hamburguer, bk);
        Artigo cola = new Artigo("Coca cola", "Bebida refrescante", 1.5, bebidas, bk);
        Artigo icedTea= new Artigo("Iced tea", "Bebida refrescante sem gás", 1.5, bebidas, bk);
        Artigo batatas = new Artigo("Batatas fritas", "Batatas fritas com sal", 1.5, batata, bk);

        Menu menubk = new Menu("Menu Double Cheese", "Uma opção barata e deliciosa", 5.5);
        menubk.addArtigo(dCheese);
        menubk.addArtigo(cola);
        menubk.addArtigo(batatas);

        Cliente helder = new Cliente("Helder", "helder", "Rua Bernardo de Matos 52", "969684832", "Pao de alho");

        Encomenda e1 = new Encomenda("Estou esfomeado", helder);

        e1.adicionarMenu(menubk);
        System.out.println(menubk.nome +  " adicionado ao carrinho!");

        e1.adicionarArtigo(kingBacon);
        System.out.println("Artigo " + kingBacon.nome + " adicionado ao carrinho!");

        System.out.println("Estado da encomenda: " + e1.estado);

        if(e1.encomendar()) {
            System.out.println("\nEstado da encomenda: " + e1.estado);
            System.out.println("Preço da encomenda: " + e1.caclPreco());
        }
        System.out.println("\nEstado da encomenda: Entregue");
        Classificacao clas = new Classificacao(7, "Estava bom mas o pedido chegou frio.");

        System.out.println("\nClassificação da encomenda:\nNota: " + clas.getNota() + "\nDescrição: " + clas.getDescricao());

        System.out.println("\nMuito obrigado por utilizar o nosso serviço!");
    }

    private static void demo2(){
        Restaurante pl = new Restaurante("Parque dos Leitões", "fernandosantos", "Horta das Figueiras");
        Restaurante samurai = new Restaurante("Samurai", "jorgejesus", "Rua Serpa Pinto");

        Categoria vaca = new Categoria("Carne de vaca");
        Categoria bebida = new Categoria("Bebidas");
        Categoria porco = new Categoria("Carne de porco");
        Categoria sushi = new Categoria("Sushi");

        Artigo maminha = new Artigo("Maminha de vaca", "Um prato com maminha de vaca e com salada a acompanhar", 10.95, vaca, pl);
        Artigo cola = new Artigo("Coca cola", "Bebida refrescante", 1.5, bebida, pl);
        Artigo cola2 = new Artigo("Coca cola", "Bebida refescante", 1.5, bebida, samurai);
        Artigo temaki = new Artigo("Temaki", "Sushi coberto com alga", 10, sushi, samurai);

        Cliente goncalo = new Cliente("Goncalo", "goncalo", "Horta das figueiras", "goncalo@hotmail.com", "Grlo");

        Encomenda e1 = new Encomenda("Sempre com fome", goncalo);

        e1.adicionarArtigo(maminha);
        System.out.println("Artigo " + maminha.nome + " adicionado ao carrinho");

        e1.adicionarArtigo(cola);
        System.out.println("Artigo " +cola.nome+ " adicionado ao carrinho");

        e1.adicionarArtigo(temaki);
        System.out.println("Artigo " +temaki.nome+ " adicionado ao carrinho");

        e1.adicionarArtigo(cola2);
        System.out.println("Artigo " +cola2.nome+ " adicionado ao carrinho");

        if(e1.encomendar()){
            System.out.println("\nEstado da encomenda: " +e1.estado);
            System.out.println("Preço da encomenda: " +e1.caclPreco());
        }
        System.out.println("\nEstado da encomenda: Entregue");

        Classificacao clas1 = new Classificacao(9.5, "A maminha estava ótima, no ponto certo!!");
        Classificacao clas2 = new Classificacao(2, "O peixe estava cru");

        System.out.println("\nClassificação da restaurante " +pl.nome+  ":\nNota: " + clas1.getNota() + "\nDescrição: " + clas1.getDescricao());
        System.out.println("\nClassificação da restaurante: " +samurai.nome+ "\nNota: " + clas2.getNota() + "\nDescrição: " + clas2.getDescricao());

        Reclamacao recl = new Reclamacao(goncalo, "O peixe veio cru no sushi e eu só gosto do peixe grelhado!");
        System.out.println("\nReclamação do restaurante: " +samurai.nome+ "\n" +recl.getDescricao());

        System.out.println("\nMuito obrigado por utilizar o nosso serviço!");
    }

    private static void demo3(){
        Restaurante chinesa = new Restaurante("A chinesa", "elchino", "Rua da china");

        Categoria oriental = new Categoria("Comida chinesa");
        Categoria bebidas = new Categoria("bebidas");

        Artigo biscoito = new Artigo("Biscoito da sorte", "Um prato de biscoitos comestiveis que prevêm a tua sorte", 4.5, oriental, chinesa);
        Artigo agua = new Artigo("Agua", "Um copo de agua", 1.5, bebidas, chinesa);
        Artigo massa = new Artigo("Massa chinesa", "Uma porção de massa chinesa como acompanhamento", 5.5, oriental, chinesa);
        Artigo sumol = new Artigo("sumol", "uma bebida refrescante", 1.5, oriental, chinesa);

        Menu menuCDisc = new Menu("Menu com desconto", "Uns biscoitos chineses com agua para acompanhar", 6);
        Cliente guilherme = new Cliente("Guilherme", "guilherme", "Bacelo", "967283921", "Bacelo");

        Encomenda e1 = new Encomenda("Sempre com fome", guilherme);

        e1.adicionarMenu(menuCDisc);
        System.out.print(menuCDisc.getNome() + " adicionado ao carrinho! Desconto aplicado de " + menuCDisc.getPreco());
        menuCDisc.aplicarDesconto(20);
        System.out.print(" passa a custar " + menuCDisc.getPreco() + "\n");



        System.out.println("Estado da encomenda: " + e1.estado);

        if(e1.encomendar()) {
            System.out.println("\nEstado da encomenda: " + e1.estado);
            System.out.println("Preço da encomenda: " + e1.caclPreco());
        }
        System.out.println("\nEstado da encomenda: Entregue");

        System.out.println("\nMuito obrigado por utilizar o nosso serviço!");
    }

    public static void main(String[] args) {
        System.out.println("\t\t Demonstração 1\n");
        demo1();

        System.out.println("\n\t\t Demonstração 2\n");
        demo2();

        System.out.println("\n\t\t Demonstração 3\n");
        demo3();
    }
}