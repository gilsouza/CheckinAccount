package br.com.gilsouza.checkingaccountmanager.db.schema;

/**
 * Created by gilmar on 30/05/17.
 */

public interface IOperationSchema {
    String OPERATION_TABLE = "operacao";
    String COLUMN_ID = "operacao_id";
    String COLUMN_TYPE_OPERATION_ID = "operacao_tipo_operacao_id";
    String COLUMN_ACCOUNT_HOLDER_ID = "operacao_correntista_id";
    String COLUMN_DATE = "operacao_data";
    String COLUMN_VALUE = "operacao_valor";
    String COLUMN_ACCOUNT_DESTINATION = "operacao_destino";
    String COLUMN_DESCRIPTION = "operacao_descricao";
    String OPERATION_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + OPERATION_TABLE
            + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TYPE_OPERATION_ID + " INTEGER NOT NULL, "
            + COLUMN_ACCOUNT_HOLDER_ID + " INTEGER NOT NULL, "
            + COLUMN_DATE + " INTEGER NOT NULL, "
            + COLUMN_VALUE + " REAL NOT NULL, "
            + COLUMN_ACCOUNT_DESTINATION + " INTEGER NOT NULL, "
            + COLUMN_DESCRIPTION + " TEXT NOT NULL, "
            + "FOREIGN KEY(" + COLUMN_ACCOUNT_HOLDER_ID + ") REFERENCES correntista(correntista_id), "
            + "FOREIGN KEY(" + COLUMN_TYPE_OPERATION_ID + ") REFERENCES tipo_operacao(tipo_operacao_id) "
            + ");";
    String[] COLUMNS = new String[] {
            COLUMN_ID, COLUMN_TYPE_OPERATION_ID, COLUMN_ACCOUNT_HOLDER_ID, COLUMN_DATE,
            COLUMN_VALUE, COLUMN_ACCOUNT_DESTINATION, COLUMN_DESCRIPTION
    };
}