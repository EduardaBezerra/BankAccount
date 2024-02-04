package com.bancodd;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random; 

public class Main {

    private static final int LIMITMAX = 900001;
    private static final int LIMITMIN = 100000;

    public static int generateAccount(){
        Random generator = new Random();
        int newAccountNumber = (generator.nextInt(LIMITMAX) + LIMITMIN); 
        return newAccountNumber;
    }

    public static boolean inputPrint(BankAccount account, Scanner reader){

        /*A variável numberAccount foi criada para poder usar o nextLine depois dela.
        Antes dela ser criada o nextInt ficava direto no if, porém, desse jeito iria 
        ter que repetir o nextLine 4x (2 dentro de cada if e 2 fora de cada if). Do jeito 
        que esta agora são usados 2 nextLine a menos :)
        */

        System.out.println("\nDigite o número da sua conta: ");
        
        int numberAccount = reader.nextInt(); 
        reader.nextLine(); //Este nextLine serve para limpar o buffer
  
        if(numberAccount != (account.getAccountNum())){ // MELHORIA: ACESSAR CONTA ESPECIFICA QUANDO TIVER MAIS DE UMA
            System.out.println("Essa conta não existe!\nTente novamente: ");
            return false;
        }

        System.out.println("\nDigite sua senha: ");

        int password = reader.nextInt(); //Foi criado com o mesmo intuito de numberAccount
        reader.nextLine(); //Este nextLine serve para limpar o buffer


        if(password != (account.getPassword())){
            System.out.println("Senha incorreta!\nTente novamente: ");
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        
        //OBJETOS
        Scanner reader = new Scanner(System.in);
        ArrayList<BankAccount> bankAccountsList = new ArrayList<>(); //Lista de contas bancárias
        String name, password; 
        
        /* "name" e "password" são objetos que não precisaram do construtor para serem criados (por isso não usa "new") 
        por convenção do Java. Logo, String é a única classe que permite ter objetos sem uso de contrutor */

        int option = 0; 

        while(option != 5){

            System.out.println("\n\nO que você deseja agora?\n" +
                    "\n1 - Criar conta\n" + 
                    "2 - Ver saldo\n" + 
                    "3 - Sacar\n" + 
                    "4 - Depositar\n" +
                    "5 - Sair\n");

            option = Integer.parseInt(reader.nextLine()); 

            switch (option) {

                case 1: // Cria uma Conta
    
                    System.out.println("\nDigite o seu nome completo: ");
                    name = reader.nextLine(); 

                    System.out.println("\nCrie uma senha apenas com 6 números: ");
                    password = reader.nextLine(); // A leitura é feita em string para depois ser convertida em inteiro, dessa forma, caso seja armazenado um "\n" durante a leitura o mesmo será descartado


                    while(password.length() != 6){ //Verifica se a senha tem 6 números
                        System.out.println("\nSenha inválida! Digite uma nova senha: ");
                        password = reader.nextLine();
                    } 

                    System.out.println("\nSenha Criada!");
    
                    //OBJETO
                    BankAccount newAccount = new BankAccount(); 

                    //ATUALIZAÇÕES DO OBJETO "firstAccount"
                    newAccount.setClient(name);
                    newAccount.setAccountNum(generateAccount()); 
                    newAccount.setBalance(0);
                    newAccount.setPassword(Integer.parseInt(password)); //Integer é uma classe de inteiros e parseInt é um método estático. Ele esta sendo usado para converter o "password" de String para Int

                    bankAccountsList.add(newAccount);

                    System.out.printf("\nParabéns, %s! Sua conta foi criada." +
                                      "\nO número da sua conta é: %d" +
                                      "\nSeu saldo é de R$ %.2f\n\n", newAccount.getClient().split(" ")[0], newAccount.getAccountNum(), newAccount.getBalance());

                    break;
                
                case 2: // Vê o saldo

                    while(inputPrint(firstAccount, reader) == false){}
                    System.out.printf("\nOlá, %s! Seu saldo é R$ %.2f", firstAccount.getClient().split(" ")[0], firstAccount.getBalance());                
                    break;

                case 3: // Saca um valor

                    System.out.println("\nDigite o valor do saque: ");
                    float withdraw = reader.nextFloat();

                    while(inputPrint(firstAccount, reader) == false){}

                    if(firstAccount.toWithdraw(withdraw)){
                        System.out.printf("\nParabéns! O saque foi realizado com sucesso\nSeu novo saldo é R$ %.2f", firstAccount.getBalance());
                    }else{
                        System.out.println("\nOperação inválida");
                    }
                        
                    break;

                case 4: // Deposita um valor

                    System.out.println("\nDigite o valor do depósito: ");
                    float deposit = reader.nextFloat();

                    while(inputPrint(firstAccount, reader) == false){}

                    if(firstAccount.toDeposit(deposit)){
                        System.out.printf("\nParabéns! O depósito foi realizado com sucesso\nSeu novo saldo é R$ %.2f", firstAccount.getBalance());
                    }else{
                        System.out.println("\nOperação inválida");
                    }

                    break;

                case 5:

                    break;

                default:

                    System.out.println("Operação Inválida!");
                    break;
            }
        }
    }     
}