package com.example.test_pptr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Search_Delate_Update extends AppCompatActivity {

    EditText Ename_search;
    TextView name_search, lastname_search;
    Button btnNowSearch;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_search_delate_update);

        Ename_search = (EditText) findViewById(R.id.Ename_search);
        name_search = (TextView) findViewById(R.id.name_search);
        lastname_search = (TextView) findViewById(R.id.lastname_search);
        btnNowSearch = (Button) findViewById(R.id.btnNowSearch);

        btnNowSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(), null, null, 1);
                String search = Ename_search.getText().toString();
                String[] datas;
                datas = db.search_reg(search);
                name_search.setText(datas[0]);
                lastname_search.setText(datas[1]);

                Toast.makeText(getApplicationContext(), datas[2], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
