package com.dicoding.picodiploma.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtWidth, edtHeight, edtLenght;
    private Button btnCalculate;
    private TextView tvResult; 
    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLenght = findViewById(R.id.edt_lenght);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListner(this);
    }

    @Override
    public void onClick(View v){
        if (v.get()== R.id.btn_calculate){
            String inputLength = edtLenght.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString.trim();
            String inputHeight = edtHeight.getText().toString.trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.IsEmpty(inputWidth)){
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.IsEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            Double length = toDouble(inputLenght);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (lenght == null ){
                isInvalidDouble = true;
                edtLenght.setError("Field ini harus berupa nomer yang valid");
            }

            if (width == null ){
                isInvalidDouble = true;
                edtWidth.setError("Field ini harus berupa nomer yang valid");
            }

            if (height == null ){
                isInvalidDouble = true;
                edtHeight.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble){
                double volume = length * width * height;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    private void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outside);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}
