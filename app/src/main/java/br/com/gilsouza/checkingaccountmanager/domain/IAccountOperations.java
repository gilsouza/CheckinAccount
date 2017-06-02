package br.com.gilsouza.checkingaccountmanager.domain;

/**
 * Created by gilmar on 27/05/17.
 */

public interface IAccountOperations {
    boolean viewStatementAccount();
    boolean makeWithdrawal();
    boolean makeDeposit(double value, String description);
    boolean makeTransfer(double value, int accountDestination, String description);
    boolean makeServiceCharge(double value, String description);
    boolean requestVisit();
}
