package com;

import com.bancodd.BankAccount;

public class SpecialAccount extends BankAccount {

    //ATRIBUTOS
      private float limit; 

    //CONSTRUTOR PADRÃO
    public SpecialAccount(){
    }

    //METÓDOS

    //Redefinição do metodo sacar permitindo saldo negativo até o valor do limite ???? - DUVIDA: COMO QUE REDEFINE UM METODO?

    //Get & Set
    public float getLimit(){
        return limit;
    }

    public void setIncome_Day(float limit){
        this.limit = limit;
    }

}
