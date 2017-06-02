package br.com.gilsouza.checkingaccountmanager.db.schema;

/**
 * Created by gilmar on 30/05/17.
 */

public interface ITypeOperationSchema {
    String TYPE_OPERATION_TABLE = "tipo_operacao";
    String COLUMN_ID = "tipo_operacao_id";
    String COLUMN_NAME = "tipo_operacao_nome";
    String TYPE_OPERATION_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TYPE_OPERATION_TABLE
            + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_NAME + " TEXT NOT NULL"
            + ");";
    String[] COLUMNS = new String[] {
            COLUMN_ID, COLUMN_NAME
    };
}
