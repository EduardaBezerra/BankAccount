package com.bancodd;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * MELHORIA:
 *     fazer o menu se repetir ao final de cada operação até que
 *     o usuário informe um comando de encerramento (uma opção a mais)
 */

public class Main {

    public static boolean inputPrint(BankAccount account, Scanner reader){
        
        System.out.println("\nDigite o número da sua conta: ");
                 
        if((reader.nextInt()) != (account.getAccountNum())){ // MELHORIA: ACESSAR CONTA ESPECIFICA QUANDO TIVER MAIS DE UMA
            System.out.println("Essa conta não existe!\nTente novamente: ");
            return false;
        }

        System.out.println("\nDigite sua senha: ");

        if((reader.nextInt()) != (account.getPassword())){
            System.out.println("Senha incorreta!\nTente novamente: ");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        
        //OBJETOS
        Scanner reader = new Scanner(System.in);
        BankAccount firstAccount = new BankAccount();
        String name, password; 
        ArrayList<String> n = new ArrayList<>();
        
        /* "name" e "password" são objetos que não precisaram do construtor para serem criados (por isso não usa "new") 
        por convenção do Java. Logo, String é a única classe que permite ter objetos sem uso de contrutor */

        System.out.println("O que você deseja?\n" +
                "\n1 - Criar conta\n" + 
                "2 - Ver saldo\n" + 
                "3 - Sacar\n" + 
                "4 - Depositar\n");

        int option = Integer.parseInt(reader.nextLine()); // nextLine é usado para descartar o "\n". Depois a entrada lida em string é convertida para inteiro 

        switch (option) {

            case 1: // Cria uma Conta
 
                System.out.println("\nDigite o seu nome completo: ");
                name = reader.nextLine(); 

                System.out.println("\nCrie uma senha apenas com 6 números: ");
                password = reader.nextLine(); 


                while(password.length() != 6){ //Verifica se a senha tem 6 números
                    System.out.println("\nSenha inválida! Digite uma nova senha: ");
                    password = reader.nextLine();
                } 

                System.out.println("\nSenha Criada!");

                firstAccount.setClient(name);
                firstAccount.setAccountNum(8232301); //MELHORIA: CRIAR UM METODO QUE GERE UMA CONTA ALEATORIA
                firstAccount.setBalance(0);
                firstAccount.setPassword(Integer.parseInt(password)); //Integer é uma classe de inteiros e parseInt é um método estático. Ele esta sendo usado para converter o "password" de String para Int

                System.out.printf("\nParabéns, %s! Sua conta foi criada." +
                                  "\nO número da sua conta é: %d" +
                                  "\nSeu saldo é de R$ %.2f\n\n", firstAccount.getClient().split(" ")[0], firstAccount.getAccountNum(), firstAccount.getBalance());

                break;
            
            case 2: // Vê o saldo

                while(inputPrint(firstAccount, reader) == false){}
                System.out.printf("Olá, $s! Seu saldo é R$ %.2f", firstAccount.getClient().split(" ")[0], firstAccount.getBalance());                
                break;

            case 3: // Saca um valor

                System.out.println("\nDigite o valor do saque: ");
                float withdraw = reader.nextFloat();

                while(inputPrint(firstAccount, reader) == false){}

                if(firstAccount.toWithdraw(withdraw)){
                    System.out.printf("Parabéns! O saque foi realizado com sucesso\nSeu novo saldo é R$ %.2f", firstAccount.getBalance());
                }else{
                    System.out.println("Operação inválida: Saldo Insuficiente!");
                }
                    
                break;

            case 4: // Deposita um valor

                System.out.println("\nDigite o valor do depósito: ");
                float deposit = reader.nextFloat();

                while(inputPrint(firstAccount, reader) == false){}

                System.out.printf("Parabéns! O depósito foi realizado com sucesso\nSeu novo saldo é R$ %.2f", firstAccount.toDeposit(deposit));

                break;

            default:

                System.out.println("Operação Inválida!");
                break;
        }
    }     
}