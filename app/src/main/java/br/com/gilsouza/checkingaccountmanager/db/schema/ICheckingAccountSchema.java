package br.com.gilsouza.checkingaccountmanager.db.schema;

/**
 * Created by gilmar on 27/05/17.
 */

public interface ICheckingAccountSchema {
    String CHECKING_ACCOUNT_TABLE = "correntista";
    String COLUMN_ID = "correntista_id";
    String COLUMN_ACCOUNT_HOLDER_NAME = "correntista_nome";
    String COLUMN_ACCOUNT_NUMBER = "correntista_n_conta";
    String COLUMN_TYPE_ACCOUNT_ID = "correntista_tipo_conta_id";
    String COLUMN_PASSWORD = "correntista_password";
    String CHECKING_ACCOUNT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + CHECKING_ACCOUNT_TABLE
            + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ACCOUNT_HOLDER_NAME + " TEXT NOT NULL, "
            + COLUMN_ACCOUNT_NUMBER + " INTEGER NOT NULL, "
            + COLUMN_TYPE_ACCOUNT_ID + " INTEGER NOT NULL, "
            + COLUMN_PASSWORD + " TEXT NOT NULL, "
            + "FOREIGN KEY(" + COLUMN_TYPE_ACCOUNT_ID + ") REFERENCES tipo_conta(tipo_conta_id)"
            + ");";
    String[] COLUMNS = new String[] {
            COLUMN_ID, COLUMN_ACCOUNT_HOLDER_NAME, COLUMN_ACCOUNT_NUMBER, COLUMN_TYPE_ACCOUNT_ID, COLUMN_PASSWORD
    };
}
