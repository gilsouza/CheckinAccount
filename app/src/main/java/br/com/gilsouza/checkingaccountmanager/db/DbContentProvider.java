package br.com.gilsouza.checkingaccountmanager.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gilmar on 27/05/17.
 */

public abstract class DbContentProvider {
    private SQLiteDatabase cpDb;

    public DbContentProvider(SQLiteDatabase db) {
        cpDb = db;
    }

    public long insert(String table, ContentValues values) {
        return cpDb.insert(table, null, values);
    }

    public int delete(String tableName, String selection, String[] selectionArgs) {
        return cpDb.delete(tableName, selection, selectionArgs);
    }

    protected abstract <T> T cursorToEntity(Cursor cursor);

    public Cursor query(String tableName, String[] columns, String selection, String[] selectionArgs,
                        String orderBy) {

        final Cursor cursor = cpDb.query(tableName, columns, selection, selectionArgs, null, null,
                orderBy);
        return cursor;
    }

    public Cursor query(String tableName, String[] columns, String selection, String[] selectionArgs,
                        String orderBy, String limit) {
        return cpDb.query(tableName, columns, selection, selectionArgs, null, null, orderBy, limit);
    }

    public Cursor query(String tableName, String[] columns, String selection, String[] selectionArgs,
                        String groupBy, String having, String orderBy, String limit) {
        return cpDb.query(tableName, columns, selection, selectionArgs, groupBy, having, orderBy,
                limit);
    }

    public int update(String tableName, ContentValues values, String selection,
                      String[] selectionArgs) {
        return cpDb.update(tableName, values, selection, selectionArgs);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return cpDb.rawQuery(sql, selectionArgs);
    }

}
