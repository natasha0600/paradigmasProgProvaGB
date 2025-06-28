package contaBancaria;

import java.util.Scanner;

public class ContaBancaria {

    private static String nome = "Natasha";
    private static String tipoConta = "Corrente";
    private static double saldo = 2500;
    private static Scanner leitura = new Scanner(System.in);

    public static void mostrarSaldo() {
        System.out.println("O saldo atualizado é R$ " + saldo);
    }

    public static void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        mostrarSaldo();
    }


    public static void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
            mostrarSaldo();
        }
    }

    public static void main(String[] args) {
        int opcao = 0;

        System.out.println("Dados iniciais do cliente: ");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println("Saldo atual: R$ " + saldo);

        String menu = """
                ** Digite sua opção **
                1- Consultar Saldo
                2- Transferir Valor
                3- Receber valor
                4- Sair
                """;

        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    mostrarSaldo();
                    break;
                case 2:
                    System.out.println("Qual o valor que deseja transferir?");
                    double valorSaque = leitura.nextDouble();
                    sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Qual valor deseja receber?");
                    double valorDeposito = leitura.nextDouble();
                    depositar(valorDeposito);
                    break;
                case 4:
                    System.out.println("Obrigado por usar nossos serviços!");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        leitura.close();
    }
}