package com.bancodd;

public class SavingsAccount extends BankAccount {

    //ATRIBUTOS
    private int income_day; //t: dia de rendimento

    //CONSTRUTOR PADRÃO
    public SavingsAccount(){
    }

    //METÓDOS

    //Novo Saldo
    public void calculateNewBalance(float receipt_rate, float up_balance){
        this.balance = up_balance; 
    }

    //Get & Set
    public int getIncome_Day(){
        return income_day;
    }

    public void setIncome_Day(int income_day){
        this.income_day = income_day;
    }
    
}
