package br.com.gilsouza.checkingaccountmanager.domain;

/**
 * Created by gilmar on 30/05/17.
 */

public enum TypeOperation {

    Withdrawal("Saque", 1),
    Deposit("Deposito", 2),
    Transference("Transferencia", 3),
    ServiceCharge("Tarifa", 4);

    private String name;
    private int type;

    TypeOperation(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
