package br.com.gilsouza.checkingaccountmanager.dao.daointerface;

import br.com.gilsouza.checkingaccountmanager.model.account.CheckingAccount;

/**
 * Created by gilmar on 27/05/17.
 */

public interface ICheckingAccountDAO {
    CheckingAccount fetchCheckingAccountByAccountNumber(int accountNumber);
    boolean addCheckingAccount(CheckingAccount account);
}
