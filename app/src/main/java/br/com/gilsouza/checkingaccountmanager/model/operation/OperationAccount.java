package br.com.gilsouza.checkingaccountmanager.model.operation;

import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;

/**
 * Created by gilmar on 30/05/17.
 */

public class OperationAccount {
    private int id;
    private int checkingAccountId;
    private TypeOperation typeOperation;
    protected double value;
    private int destiny;
    private String description;
    private long date;

    public OperationAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheckingAccountId() {
        return checkingAccountId;
    }

    public void setCheckingAccountId(int checkingAccountId) {
        this.checkingAccountId = checkingAccountId;
    }

    public double getValue() { return this.value; }

    public void setValue(double value) {
        this.value = value;
    }

    public int getDestiny() {
        return destiny;
    }

    public void setDestiny(int destiny) {
        this.destiny = destiny;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }
}
