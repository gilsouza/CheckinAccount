package br.com.gilsouza.checkingaccountmanager.domain;

/**
 * Created by gilmar on 27/05/17.
 */

public enum TypeAccount {

    Normal("Normal", 1),
    VIP("VIP", 2);

    private String name;
    private int type;

    TypeAccount(String name, int type) {
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
