package br.com.gilsouza.checkingaccountmanager.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.gilsouza.checkingaccountmanager.dao.daointerface.ITypeOperationDAO;
import br.com.gilsouza.checkingaccountmanager.db.DbContentProvider;
import br.com.gilsouza.checkingaccountmanager.db.schema.ITypeOperationSchema;
import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;

/**
 * Created by gilmar on 31/05/17.
 */

public class TypeOperationDAO extends DbContentProvider implements ITypeOperationDAO, ITypeOperationSchema {
    private Cursor cursor;
    private ContentValues initialValues;

    public TypeOperationDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected <T> T cursorToEntity(Cursor cursor) {
        return null;
    }


    @Override
    public boolean addTypeOperation(TypeOperation typeOperation) {

        setContentValue(typeOperation);
        try {
            return super.insert(TYPE_OPERATION_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }

    }

    private void setContentValue(TypeOperation typeOperation) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_ID, typeOperation.getType());
        initialValues.put(COLUMN_NAME, typeOperation.getName());
    }

    private ContentValues getContentValue() {
        return initialValues;
    }
}
