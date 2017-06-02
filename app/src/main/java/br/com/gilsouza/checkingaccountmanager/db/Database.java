package br.com.gilsouza.checkingaccountmanager.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.gilsouza.checkingaccountmanager.dao.CheckingAccountDAO;
import br.com.gilsouza.checkingaccountmanager.dao.OperationDAO;
import br.com.gilsouza.checkingaccountmanager.dao.TypeAccountDAO;
import br.com.gilsouza.checkingaccountmanager.dao.TypeOperationDAO;
import br.com.gilsouza.checkingaccountmanager.db.schema.ICheckingAccountSchema;
import br.com.gilsouza.checkingaccountmanager.db.schema.IOperationSchema;
import br.com.gilsouza.checkingaccountmanager.db.schema.ITypeAccountSchema;
import br.com.gilsouza.checkingaccountmanager.db.schema.ITypeOperationSchema;
import br.com.gilsouza.checkingaccountmanager.domain.TypeAccount;
import br.com.gilsouza.checkingaccountmanager.domain.TypeOperation;
import br.com.gilsouza.checkingaccountmanager.model.account.NormalAccount;
import br.com.gilsouza.checkingaccountmanager.model.account.VipAccount;

/**
 * Created by gilmar on 30/05/17.
 */

public class Database {
    private static final String TAG = "AccountManagerDatabase";
    private static final String DATABASE_NAME = "AccountManager_database.db";
    private DatabaseHelper mDbHelper;

    private static final int DATABASE_VERSION = 7;
    private final Context mContext;
    public static OperationDAO mOperationDAO;
    public static CheckingAccountDAO mCheckingAccountDAO;
    public static TypeAccountDAO mTypeAccountDAO;
    public static TypeOperationDAO mTypeOperationDAO;

    public Database open() throws SQLException {
        mDbHelper = new DatabaseHelper(mContext);
        SQLiteDatabase mDb = mDbHelper.getWritableDatabase();

        mOperationDAO = new OperationDAO(mDb);
        mCheckingAccountDAO = new CheckingAccountDAO(mDb);
        mTypeAccountDAO = new TypeAccountDAO(mDb);
        mTypeOperationDAO = new TypeOperationDAO(mDb);

        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public Database(Context context) {
        this.mContext = context;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ITypeAccountSchema.TYPE_ACCOUNT_TABLE_CREATE);
            db.execSQL(ITypeOperationSchema.TYPE_OPERATION_TABLE_CREATE);
            db.execSQL(ICheckingAccountSchema.CHECKING_ACCOUNT_TABLE_CREATE);
            db.execSQL(IOperationSchema.OPERATION_TABLE_CREATE);

            mTypeAccountDAO = new TypeAccountDAO(db);
            for (TypeAccount typeAccount : TypeAccount.values()) {
                mTypeAccountDAO.addTypeAccount(typeAccount);
            }

            mTypeOperationDAO = new TypeOperationDAO(db);
            for (TypeOperation typeOperation : TypeOperation.values()) {
                mTypeOperationDAO.addTypeOperation(typeOperation);
            }

            mCheckingAccountDAO = new CheckingAccountDAO(db);

            NormalAccount normalAccount = new NormalAccount();
            normalAccount.setId(1);
            normalAccount.setAccountHolderName("João");
            normalAccount.setAccountNumber(11111);
            normalAccount.setPassword("111111");
            mCheckingAccountDAO.addCheckingAccount(normalAccount);

            VipAccount vipAccount = new VipAccount();
            vipAccount.setId(2);
            vipAccount.setAccountHolderName("José");
            vipAccount.setAccountNumber(22222);
            vipAccount.setPassword("22222");
            mCheckingAccountDAO.addCheckingAccount(vipAccount);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            Log.w(TAG, "Upgrading database from version "
                    + oldVersion + " to "
                    + newVersion + " which destroys all old data");

            db.execSQL("DROP TABLE IF EXISTS " + ITypeAccountSchema.TYPE_ACCOUNT_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + ITypeOperationSchema.TYPE_OPERATION_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + ICheckingAccountSchema.CHECKING_ACCOUNT_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + IOperationSchema.OPERATION_TABLE);
            onCreate(db);

        }
    }

}
