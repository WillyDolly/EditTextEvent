package com.popland.pop.edittextevent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
EditText edtA, edtB;
    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edtA = (EditText)findViewById(R.id.EDTa);
        edtB = (EditText)findViewById(R.id.EDTb);
        txtv = (TextView)findViewById(R.id.TV);
        edtA.addTextChangedListener (new TextWatcher(){// lắng nghe Text thay đổi trong EditText
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strA = s.toString(); // s thay cho edtA.getText()
                String strB = edtB.getText().toString();
               if((!strB.equals(""))&&(!strA.equals(""))){//! thay cho "==false"
                    int soA = Integer.parseInt(strA);
                    int soB = Integer.parseInt(strB);
                    int kq = soA + soB;
                   DecimalFormat dcf = new DecimalFormat("#.0");
                    txtv.setText(dcf.format(Math.sqrt(kq)));//math.sqrt trả về double
                }
                else
                   txtv.setText("0.0");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

       /* edtB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String strB = s.toString();
                String strA = edtA.getText().toString();
                if ((!strB.equals(""))&&(!strA.equals(""))) {
                    int soB = Integer.parseInt(strB);
                    int soA = Integer.parseInt(strB);
                    int kq = soA + soB;
                    DecimalFormat dcf = new DecimalFormat("#.00");
                    txtv.setText(dcf.format(Math.sqrt(kq)));
                }
                else
                    txtv.setText("0.00");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
    }
}
