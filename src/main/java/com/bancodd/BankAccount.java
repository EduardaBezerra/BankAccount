package com.bancodd;

public class BankAccount {

    //ATRIBUTOS
    protected String client;    
    protected int accountNum;  // t: número da conta
    protected float balance;   // t: saldo
    protected int password;    // t: senha

    //CONSTRUTOR PADRÃO
    public BankAccount(){
    }

    //MÉTODOS
    
    //Saque
    public boolean toWithdraw(float withdraw){ 
        if(withdraw > balance){ // impede que o saldo fique negativo
            return false;
        }else {
            balance = balance - withdraw;
            return true;
        }
    }

    /*----------------------------------
    public float toWithdrawSecondOption(float withdraw){
        if(withdraw <= balance){ // impede que o saldo fique negativo
            balance = balance - withdraw;
            return balance;
        }
        System.out.println("Operação inválida!");
        return balance;
    }
    ----------------------------------*/

    //Depósito
    public float toDeposit(float deposit){
        balance = balance + deposit; 
        return balance;
    }

    //Get & Set
    public String getClient(){
        return client;
    }

    public void setClient(String client){
        this.client = client;
    }

    public int getAccountNum(){
        return accountNum;
    }

    public void setAccountNum(int accountNum){
        this.accountNum = accountNum;
    }

    public float getBalance(){
        return balance;
    }

    public void setBalance(float balance){
        this.balance = balance;
    }

    public int getPassword(){
        return password;
    }

    public void setPassword(int password){
        this.password = password;
    }
        
}
