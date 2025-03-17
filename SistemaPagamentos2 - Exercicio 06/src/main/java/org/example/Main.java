package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessadorPagamento processador = new ProcessadorPagamento();

        while (true) {
            System.out.println("\nEscolha o método de pagamento:");
            System.out.println("1 - PIX");
            System.out.println("2 - Cartão de Crédito");
            System.out.println("3 - Boleto");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();


            String tipoPagamento = "";
            switch (opcao) {
                case 1:
                    tipoPagamento = "pix";
                    break;
                case 2:
                    tipoPagamento = "cartao";
                    break;
                case 3:
                    tipoPagamento = "boleto";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.print("Insira o valor da transação: R$");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            try {
                FormaPagamento formaPagamento = FabricaPagamentos.criarPagamento(tipoPagamento);
                processador.definirFormaPagamento(formaPagamento);
                processador.processar(valor);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}