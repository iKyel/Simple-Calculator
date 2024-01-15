package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonCong, buttonTru, buttonNhan, buttonChia;
    EditText etSoThuNhat, etSoThuHai;
    TextView TVkq;
    int so1, so2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCong = findViewById(R.id.btn_cong);
        buttonTru = findViewById(R.id.btn_tru);
        buttonChia = findViewById(R.id.btn_chia);
        buttonNhan = findViewById(R.id.btn_nhan);
        etSoThuNhat = findViewById(R.id.so_thu_nhat);
        etSoThuHai = findViewById(R.id.so_thu_hai);
        TVkq = findViewById(R.id.ket_qua);

        buttonCong.setOnClickListener(this);
        buttonTru.setOnClickListener(this);
        buttonNhan.setOnClickListener(this);
        buttonChia.setOnClickListener(this);
    }
    public int getIntFromEditText(EditText et){
        if (et.getText().toString().equals("")){
            Toast.makeText(this, "Nhập số!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        else return Integer.parseInt(et.getText().toString());
    }

    @Override
    public void onClick(View v) {
        so1 = getIntFromEditText(etSoThuNhat);
        so2 = getIntFromEditText(etSoThuHai);
        if (v.getId() == R.id.btn_cong) {
            TVkq.setText("kết quả = " + (so1 + so2));
        } else if (v.getId() == R.id.btn_tru) {
            TVkq.setText("kết quả = " + (so1 - so2));
        } else if (v.getId() == R.id.btn_nhan) {
            TVkq.setText("kết quả = " + (so1 * so2));
        } else if (v.getId() == R.id.btn_chia) {
            if (so2 != 0) {
                TVkq.setText("kết quả = " + ((float) so1 / so2));
            } else {
                Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}