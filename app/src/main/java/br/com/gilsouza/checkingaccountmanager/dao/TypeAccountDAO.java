package br.com.gilsouza.checkingaccountmanager.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.gilsouza.checkingaccountmanager.dao.daointerface.ITypeAccountDAO;
import br.com.gilsouza.checkingaccountmanager.db.DbContentProvider;
import br.com.gilsouza.checkingaccountmanager.db.schema.ITypeAccountSchema;
import br.com.gilsouza.checkingaccountmanager.domain.TypeAccount;

/**
 * Created by gilmar on 31/05/17.
 */

public class TypeAccountDAO extends DbContentProvider implements ITypeAccountDAO, ITypeAccountSchema {
    private Cursor cursor;
    private ContentValues initialValues;

    public TypeAccountDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected <T> T cursorToEntity(Cursor cursor) {
        return null;
    }

    @Override
    public boolean addTypeAccount(TypeAccount typeAccount) {

        setContentValue(typeAccount);
        try {
            return super.insert(TYPE_ACCOUNT_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }

    }

    private void setContentValue(TypeAccount typeAccount) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_ID, typeAccount.getType());
        initialValues.put(COLUMN_NAME, typeAccount.getName());
    }

    private ContentValues getContentValue() {
        return initialValues;
    }

}
