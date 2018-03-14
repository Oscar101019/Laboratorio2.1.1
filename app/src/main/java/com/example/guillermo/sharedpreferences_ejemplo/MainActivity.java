package com.example.guillermo.sharedpreferences_ejemplo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private final String EMAIL="Email";
    private EditText mEditTextName;
    private RadioGroup radioGroup;
    private CheckBox check1,check2,check3;
    private Spinner seiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView textView=(TextView) findViewById(R.id.textView);

        mEditTextName=(EditText) findViewById(R.id.editText);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        check1=(CheckBox) findViewById(R.id.checkBox);
        check2=(CheckBox) findViewById(R.id.checkBox2);
        check3=(CheckBox) findViewById(R.id.checkBox3);
        seiner = (Spinner) findViewById(R.id.spinnerzo);
        String[] letra = {"Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario","Piscis"};


        seiner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));

        seiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        //SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        //String email=sharedPreferences.getString(EMAIL,null);

    }
    public void saveText(View view){
        //SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        //String email=sharedPreferences.getString(EMAIL,null);

        SharedPreferences.Editor editor=getPreferences(MODE_PRIVATE).edit();
        editor.putString(EMAIL,mEditTextName.getText().toString());
        editor.putInt("Radio",radioGroup.getCheckedRadioButtonId());
        editor.putBoolean("Check1",check1.isChecked());
        editor.putBoolean("Check2",check2.isChecked());
        editor.putBoolean("Check3",check3.isChecked());
        editor.putInt("Spinner", seiner.getSelectedItemPosition());
        editor.commit();
    }
    public void getTodo(View view){
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        String email=sharedPreferences.getString(EMAIL,null);
        int radio=sharedPreferences.getInt("Radio",0);
        boolean che1=sharedPreferences.getBoolean("Check1",false);
        boolean che2=sharedPreferences.getBoolean("Check2",false);
        boolean che3=sharedPreferences.getBoolean("Check3",false);
        int spiner=sharedPreferences.getInt("Spinner",0);
        radioGroup.check(radio);
        mEditTextName.setText(email);
        check1.setChecked(che1);
        check2.setChecked(che2);
        check3.setChecked(che3);
        seiner.setSelection(spiner);
    }

}
