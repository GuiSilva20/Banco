/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.banco;

/**
 *
 * @author Guilherme Silva
 */
import java.util.Scanner;

public class Banco {
    private static String nome;
    private static String sobrenome;
    private static String cpf;
    private static double saldo = 0.0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;
            
            while (continuar) {
                exibirMenu();
                int escolha = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (escolha) {
                    case 1 -> informarUsuario();
                    case 2 -> consultarSaldo();
                    case 3 -> realizarDeposito();
                    case 4 -> realizarRetirada();
                    case 5 -> {
                        System.out.println("Obrigado por usar nosso serviço. Adeus!");
                        continuar = false;
                    }
                    default -> System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Informar dados do usuário");
        System.out.println("2. Consultar saldo");
        System.out.println("3. Realizar depósito");
        System.out.println("4. Realizar retirada");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void informarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        cpf = scanner.nextLine();
        System.out.println("Dados do usuário informados com sucesso.");
    }

    public static void consultarSaldo() {
        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("CPF: " + cpf);
        System.out.println("Saldo disponível: R$" + saldo);
    }

    public static void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor do depósito: R$");
        double valor = scanner.nextDouble();
        saldo += valor;
        System.out.println("Depósito realizado com sucesso. Novo saldo: R$" + saldo);
    }

    public static void realizarRetirada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor da retirada: R$");
        double valor = scanner.nextDouble();
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada realizada com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente. Operação cancelada.");
        }
    }
}
