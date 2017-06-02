package br.com.gilsouza.checkingaccountmanager.dao.daointerface;

import java.util.List;

import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;
import br.com.gilsouza.checkingaccountmanager.model.operation.OperationAccount;

/**
 * Created by gilmar on 30/05/17.
 */

public interface IOperationDAO {
    OperationAccount fetchOperationById(int operationId);
    OperationAccount fetchOperationByType(TypeOperation operationType);
    List<OperationAccount> fetchAllOperations();
    boolean addOperation(OperationAccount operation);
}
