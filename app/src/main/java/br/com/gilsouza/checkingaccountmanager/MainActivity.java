package br.com.gilsouza.checkingaccountmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.gilsouza.checkingaccountmanager.db.Database;

public class MainActivity extends AppCompatActivity {
    private Database mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdb = new Database(this);
        mdb.open();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mdb.close();
    }
}
