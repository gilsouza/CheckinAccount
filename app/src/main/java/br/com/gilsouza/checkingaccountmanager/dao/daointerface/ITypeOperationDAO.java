package br.com.gilsouza.checkingaccountmanager.dao.daointerface;

import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;

/**
 * Created by gilmar on 30/05/17.
 */

public interface ITypeOperationDAO {
    boolean addTypeOperation(TypeOperation typeOperation);
}
