package br.com.gilsouza.checkingaccountmanager.dao.daointerface;

import br.com.gilsouza.checkingaccountmanager.domain.TypeAccount;

/**
 * Created by gilmar on 30/05/17.
 */

public interface ITypeAccountDAO {
    boolean addTypeAccount(TypeAccount typeAccount);
}
