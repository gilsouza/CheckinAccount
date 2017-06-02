package br.com.gilsouza.checkingaccountmanager.db.schema;

/**
 * Created by gilmar on 30/05/17.
 */

public interface ITypeAccountSchema {
    String TYPE_ACCOUNT_TABLE = "tipo_conta";
    String COLUMN_ID = "tipo_conta_id";
    String COLUMN_NAME = "tipo_conta_nome";
    String TYPE_ACCOUNT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TYPE_ACCOUNT_TABLE
            + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_NAME + " TEXT NOT NULL"
            + ");";
    String[] COLUMNS = new String[] {
            COLUMN_ID, COLUMN_NAME
    };
}
