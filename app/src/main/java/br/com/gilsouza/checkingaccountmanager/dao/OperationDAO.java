package br.com.gilsouza.checkingaccountmanager.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import br.com.gilsouza.checkingaccountmanager.dao.daointerface.IOperationDAO;
import br.com.gilsouza.checkingaccountmanager.db.DbContentProvider;
import br.com.gilsouza.checkingaccountmanager.db.schema.IOperationSchema;
import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;
import br.com.gilsouza.checkingaccountmanager.model.operation.OperationAccount;

/**
 * Created by gilmar on 31/05/17.
 */

public class OperationDAO extends DbContentProvider implements IOperationDAO, IOperationSchema {
    private Cursor cursor;
    private ContentValues initialValues;

    public OperationDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public OperationAccount fetchOperationById(int operationId) {
        return null;
    }

    @Override
    public OperationAccount fetchOperationByType(TypeOperation operationType) {
        return null;
    }

    @Override
    public List<OperationAccount> fetchAllOperations() {
        return null;
    }

    @Override
    public boolean addOperation(OperationAccount operation) {

        setContentValue(operation);
        try {
            return super.insert(OPERATION_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }

    }

    @Override
    protected OperationAccount cursorToEntity(Cursor cursor) {

        if (cursor != null) {
            OperationAccount operation = new OperationAccount();

            operation.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
            operation.setTypeOperation(TypeOperation.values()[cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_TYPE_OPERATION_ID))]);
            operation.setCheckingAccountId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ACCOUNT_HOLDER_ID)));
            operation.setValue(cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_VALUE)));
            operation.setDestiny(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ACCOUNT_DESTINATION)));
            operation.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION)));
            operation.setDate(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_DATE)));

            return operation;
        }

        return null;

    }

    private void setContentValue(OperationAccount operation) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_ID, operation.getId());
        initialValues.put(COLUMN_ACCOUNT_HOLDER_ID, operation.getCheckingAccountId());
        initialValues.put(COLUMN_TYPE_OPERATION_ID, operation.getTypeOperation().getType());
        initialValues.put(COLUMN_VALUE, operation.getValue());
        initialValues.put(COLUMN_ACCOUNT_DESTINATION, operation.getDestiny());
        initialValues.put(COLUMN_DESCRIPTION, operation.getDescription());
        initialValues.put(COLUMN_DATE, operation.getDate());
    }

    private ContentValues getContentValue() {
        return initialValues;
    }
}
