package br.com.gilsouza.checkingaccountmanager.model.account;

import java.util.Date;

import br.com.gilsouza.checkingaccountmanager.domain.IAccountOperations;
import br.com.gilsouza.checkingaccountmanager.domain.ITypeAccountRules;
import br.com.gilsouza.checkingaccountmanager.domain.TypeAccount;
import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;
import br.com.gilsouza.checkingaccountmanager.model.operation.OperationAccount;

/**
 * Created by gilmar on 27/05/17.
 */

public class NormalAccount extends CheckingAccount implements IAccountOperations, ITypeAccountRules {
    private TypeAccount accountType = TypeAccount.Normal;
    private final double SERVICE_CHARGE_TRANSFERENCE = 8.0;
    private final double LIMIT_TRANSFERENCE = 1000.0;

    public NormalAccount() { }

    public TypeAccount getAccountType() {
        return accountType;
    }

    @Override
    public boolean makeWithdrawal() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean makeDeposit(double value, String description) {
        return super.makeDeposit(value, description);
    }

    @Override
    public boolean makeTransfer(double value, int accountDestination, String description) {
        if (value > getLimitTransference()) return false;

        if (super.makeTransfer(value, accountDestination, description)) {
            OperationAccount debitService = new OperationAccount();
            debitService.setTypeOperation(TypeOperation.ServiceCharge);
            debitService.setId(this.getAccountNumber());
            debitService.setDate(new Date().getTime());
            debitService.setDescription("Taxa de transferência");
            debitService.setDestiny(accountDestination);
            debitService.setValue(SERVICE_CHARGE_TRANSFERENCE * -1);
        }

        return false;
    }

    @Override
    public boolean makeServiceCharge(double value, String description) {
        return false;
    }

    @Override
    public boolean requestVisit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getServiceCharge() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getServiceChargeOverdraft() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getServiceChargeTransference() {
        return SERVICE_CHARGE_TRANSFERENCE;
    }

    @Override
    public double getLimitTransference() {
        return LIMIT_TRANSFERENCE;
    }
}
