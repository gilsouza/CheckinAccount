package br.com.gilsouza.checkingaccountmanager.domain;

/**
 * Created by gilmar on 27/05/17.
 */

public interface ITypeAccountRules {
    double getServiceCharge();
    double getServiceChargeOverdraft();
    double getServiceChargeTransference();
    double getLimitTransference();
}
