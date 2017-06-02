package br.com.gilsouza.checkingaccountmanager.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.gilsouza.checkingaccountmanager.dao.daointerface.ICheckingAccountDAO;
import br.com.gilsouza.checkingaccountmanager.db.DbContentProvider;
import br.com.gilsouza.checkingaccountmanager.db.schema.ICheckingAccountSchema;
import br.com.gilsouza.checkingaccountmanager.domain.TypeAccount;
import br.com.gilsouza.checkingaccountmanager.model.account.CheckingAccount;

/**
 * Created by gilmar on 31/05/17.
 */

public class CheckingAccountDAO extends DbContentProvider implements ICheckingAccountDAO, ICheckingAccountSchema {

    private Cursor cursor;
    private ContentValues initialValues;

    public CheckingAccountDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public CheckingAccount fetchCheckingAccountByAccountNumber(int accountNumber) {
        final String selectionArgs[] = { String.valueOf(accountNumber) };
        final String selection = accountNumber + " = ?";

        CheckingAccount account = new CheckingAccount();
        cursor = super.query(CHECKING_ACCOUNT_TABLE, COLUMNS, selection,
                selectionArgs, COLUMN_ACCOUNT_NUMBER);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                account = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return account;
    }

    @Override
    public boolean addCheckingAccount(CheckingAccount account) {
        setContentValue(account);
        try {
            return super.insert(CHECKING_ACCOUNT_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }
    }

    @Override
    protected CheckingAccount cursorToEntity(Cursor cursor) {

        if (cursor != null) {
            CheckingAccount account = new CheckingAccount();

            account.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
            account.setAccountHolderName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ACCOUNT_HOLDER_NAME)));
            account.setAccountNumber(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ACCOUNT_NUMBER)));
            account.setAccountType(TypeAccount.values()[cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_TYPE_ACCOUNT_ID))]);
            account.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD)));

            return account;
        }

        return null;

    }

    private void setContentValue(CheckingAccount account) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_ID, account.getId());
        initialValues.put(COLUMN_ACCOUNT_HOLDER_NAME, account.getAccountHolderName());
        initialValues.put(COLUMN_ACCOUNT_NUMBER, account.getAccountNumber());
        initialValues.put(COLUMN_PASSWORD, account.getPassword());
        initialValues.put(COLUMN_TYPE_ACCOUNT_ID, account.getAccountType().getType());
    }

    private ContentValues getContentValue() {
        return initialValues;
    }
}
