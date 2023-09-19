import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args) {

        // Criação do ArrayList cardapio que será preenchido com a leitura do arquivo .txt.
        ArrayList<Cardapio> cardapio = new ArrayList<Cardapio>();
        File fileLeitura = new File("Cardápio/Cardapio.txt");

        // Leitura do arquivo .txt e preenchimento do ArrayList cardapio.
        try {
            Scanner scanner = new Scanner(fileLeitura);
            while (scanner.hasNext()) {
                // Desestruturação de cada linha do arquivo .txt em um vetor de String.
                String linha = scanner.nextLine();
                String elementos[] = linha.split("&");
                int tipo = Integer.parseInt(elementos[0]);
                if (tipo == 1) {
                    String nome = elementos[1];
                    String descricao = elementos[2];
                    Double preco = Double.parseDouble(elementos[3]);
                    String culinaria = elementos[4];
                    cardapio.add(new PratoPrincipal(nome, descricao, preco, culinaria));
                } else if (tipo == 2) {
                    String nome = elementos[1];
                    String descricao = elementos[2];
                    Double preco = Double.parseDouble(elementos[3]);
                    String bebida = elementos[4];
                    cardapio.add(new Bebida(nome, descricao, preco, bebida));
                } else if (tipo == 3) {
                    String nome = elementos[1];
                    String descricao = elementos[2];
                    Double preco = Double.parseDouble(elementos[3]);
                    String sobremesa = elementos[4];
                    cardapio.add(new Sobremesa(nome, descricao, preco, sobremesa));
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não existe!");
        }

        // Criação do ArrayList itensEscolhidos para ser preenchido de acordo com as escolhas do cliente.
        Scanner scanner = new Scanner(System.in);
        ArrayList<ItemMenu> itensEscolhidos = new ArrayList<ItemMenu>();

        System.out.println("Bem-vindo. Você deseja pedir um prato principal?");
        String respostaPrato = scanner.nextLine();
        PratoPrincipal pratoEscolhido = null;

        while (!respostaPrato.equalsIgnoreCase("sim") && !respostaPrato.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Tente novamente.");
            respostaPrato = scanner.nextLine();
        }

        // Criação do ArrayList pratos para armazenar somente os pratos principais.
        if (respostaPrato.equalsIgnoreCase("sim")) {
            System.out.println("Qual prato deseja pedir?");
            ArrayList<PratoPrincipal> pratos = new ArrayList<PratoPrincipal>();
            for (int i = 0; i < cardapio.size(); i++) {
                String elemento = cardapio.get(i).getClass().getName();
                if (elemento.equals("PratoPrincipal")) {
                    PratoPrincipal prato = (PratoPrincipal) cardapio.get(i);
                    pratos.add(prato);
                    prato.mostrarInfo();
                }
            }
            String pedidoPrato = scanner.nextLine();
            int index = -1;
            while (index == -1) {
                for (int i = 0; i < pratos.size(); i++) {
                    if (pedidoPrato.equalsIgnoreCase(pratos.get(i).getNome())) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Escolha um prato válido.");
                    pedidoPrato = scanner.nextLine();
                }
            }
            pratoEscolhido = pratos.get(index);
        }
        if (pratoEscolhido != null) {
            itensEscolhidos.add(pratoEscolhido);
        }

        System.out.println("Você deseja pedir algo para beber?");
        String respostaBebida = scanner.nextLine();
        Bebida bebidaEscolhida = null;

        while (!respostaBebida.equalsIgnoreCase("sim") && !respostaBebida.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Tente novamente.");
            respostaBebida = scanner.nextLine();
        }

        if (respostaBebida.equalsIgnoreCase("sim")) {
            System.out.println("Qual bebida deseja pedir?");
            ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
            for (int i = 0; i < cardapio.size(); i++) {
                String elemento = cardapio.get(i).getClass().getName();
                if (elemento.equals("Bebida")) {
                    Bebida bebida = (Bebida) cardapio.get(i);
                    bebidas.add(bebida);
                    bebida.mostrarInfo();
                }
            }
            String pedidoBebida = scanner.nextLine();
            int index = -1;
            while (index == -1) {
                for (int i = 0; i < bebidas.size(); i++) {
                    if (pedidoBebida.equalsIgnoreCase(bebidas.get(i).getNome())) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Escolha uma bebida válida.");
                    pedidoBebida = scanner.nextLine();
                }
            }
            bebidaEscolhida = bebidas.get(index);
        }
        if (bebidaEscolhida != null) {
            itensEscolhidos.add(bebidaEscolhida);
        }

        System.out.println("Você deseja pedir uma sobremesa?");
        String respostaSobremesa = scanner.nextLine();
        Sobremesa sobremesaEscolhida = null;

        while (!respostaSobremesa.equalsIgnoreCase("sim") && !respostaSobremesa.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Tente novamente.");
            respostaSobremesa = scanner.nextLine();
        }

        if (respostaSobremesa.equalsIgnoreCase("sim")) {
            System.out.println("Qual sobremesa deseja pedir?");
            ArrayList<Sobremesa> sobremesas = new ArrayList<Sobremesa>();
            for (int i = 0; i < cardapio.size(); i++) {
                String elemento = cardapio.get(i).getClass().getName();
                if (elemento.equals("Sobremesa")) {
                    Sobremesa sobremesa = (Sobremesa) cardapio.get(i);
                    sobremesas.add(sobremesa);
                    sobremesa.mostrarInfo();
                }
            }
            String pedidoSobremesa = scanner.nextLine();
            int index = -1;
            while (index == -1) {
                for (int i = 0; i < sobremesas.size(); i++) {
                    if (pedidoSobremesa.equalsIgnoreCase(sobremesas.get(i).getNome())) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Escolha uma sobremesa válida.");
                    pedidoSobremesa = scanner.nextLine();
                }
            }
            sobremesaEscolhida = sobremesas.get(index);
        }
        if (sobremesaEscolhida != null) {
            itensEscolhidos.add(sobremesaEscolhida);
        }

        // Criação de um pedido para depois ser adiconado em um arquivo .txt externo.
        if (itensEscolhidos.isEmpty()) {
            System.out.println("Obrigado.");
        } else {
            System.out.println("Por favor insira seu nome, telefone e endereço: ");
            String nome = scanner.nextLine();
            String telefone = scanner.nextLine();
            String endereco = scanner.nextLine();

            Pedido pedido = new Pedido(nome, telefone, endereco, itensEscolhidos);

            File fileEscrita = new File("Pedidos/Pedidos.txt");
            try {
                FileWriter fileWriter = new FileWriter(fileEscrita, true);
                fileWriter.write(pedido.toString() + "\n");
                fileWriter.close();
            } catch (IOException exception) {
                System.out.println("Escrita não realizada.");
            }

            System.out.printf("O valor total do pedido foi de R$%.2f.\n", pedido.valorTotal());
        }
    }
}