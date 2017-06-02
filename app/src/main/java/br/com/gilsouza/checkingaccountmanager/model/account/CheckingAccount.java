package br.com.gilsouza.checkingaccountmanager.model.account;

import java.util.Date;

import br.com.gilsouza.checkingaccountmanager.db.Database;
import br.com.gilsouza.checkingaccountmanager.domain.TypeAccount;
import br.com.gilsouza.checkingaccountmanager.model.operation.OperationAccount;

/**
 * Created by gilmar on 27/05/17.
 */

public class CheckingAccount {
    private int id;
    private String accountHolderName;
    private int accountNumber;
    private TypeAccount accountType;
    //TODO: utilizar hash e salt
    private String password;

    public CheckingAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TypeAccount getAccountType() {
        return accountType;
    }

    public void setAccountType(TypeAccount accountType) {
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean viewStatementAccount() {
        return false;
    }

    public boolean makeTransfer(double value, int accountDestination, String description) {
        CheckingAccount aOrigin = Database.mCheckingAccountDAO.fetchCheckingAccountByAccountNumber(this.getAccountNumber());
        CheckingAccount aDestination = Database.mCheckingAccountDAO.fetchCheckingAccountByAccountNumber(accountDestination);

        if (aOrigin != null && aDestination != null) {
            OperationAccount transfer = new OperationAccount();
            transfer.setId(aOrigin.getId());
            transfer.setDate(new Date().getTime());
            transfer.setDescription(description);
            transfer.setDestiny(accountDestination);
            transfer.setValue(value * -1);

            boolean bOTransfer = Database.mOperationDAO.addOperation(transfer);

            transfer = new OperationAccount();
            transfer.setId(aDestination.getId());
            transfer.setDate(new Date().getTime());
            transfer.setDescription(description);
            transfer.setDestiny(accountDestination);
            transfer.setValue(value);

            boolean bDTransfer = Database.mOperationDAO.addOperation(transfer);



            return bOTransfer && bDTransfer;
        }

        return false;
    }

    public boolean makeDeposit(double value, String description) {
        OperationAccount deposit = new OperationAccount();
        deposit.setDate(new Date().getTime());
        deposit.setDescription(description);
        deposit.setDestiny(getAccountNumber());

        return Database.mOperationDAO.addOperation(deposit);
    }
}
