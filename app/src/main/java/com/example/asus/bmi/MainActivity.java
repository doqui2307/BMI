package com.example.asus.bmi;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtvTen, txtvChieuCao, txtvCanNang, txtvBMI, txtvKetLuan, txtvKQBMI, txtvKQKetLuan, txtvTieuDe;
    Button btnBMI;
    EditText edtTen, edtCanNang, edtChieuCao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvTieuDe = (TextView) findViewById(R.id.textViewTieuDe);
        txtvTen =(TextView) findViewById(R.id.textViewTen);
        txtvChieuCao = (TextView) findViewById(R.id.textViewChieuCao);
        txtvCanNang = (TextView) findViewById(R.id.textViewCanNang);
        txtvBMI = (TextView) findViewById(R.id.textViewBMI);
        txtvKetLuan = (TextView) findViewById(R.id.textViewKetLuan);
        txtvKQKetLuan = (TextView) findViewById(R.id.textViewKQKetLuan);
        txtvKQBMI = (TextView) findViewById(R.id.textViewKQBMI);
        btnBMI =(Button) findViewById(R.id.buttonBMI);
        edtTen = (EditText) findViewById(R.id.editTextTen);
        edtCanNang = (EditText) findViewById(R.id.editTextCanNang);
        edtChieuCao = (EditText) findViewById(R.id.editTextChieuCao);

        //Xử lý sự kiện click
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //Lấy chuỗi
                String ten = edtTen.getText().toString();
                String canNang = edtCanNang.getText().toString();
                String chieuCao = edtChieuCao.getText().toString();
                //Chuyển kiểu
                double w = Double.parseDouble(canNang);
                double h = Double.parseDouble(chieuCao);
                final double bmi = w/(h*h);
                String ketluan ="";
                if(bmi<18)
                {
                    ketluan = "Ốm đói";
                }
                else if(bmi<=24.9)
                {
                    ketluan = "Bình thường";
                }
                else if(bmi<=29.9)
                {
                    ketluan = "Bạn béo phì độ 1";
                }
                else if(bmi<=34.9)
                {
                    ketluan = "Bạn béo phì độ 2";
                }
                else
                {
                    ketluan = "Bạn béo phì độ 3";
                }
                DecimalFormat df = new DecimalFormat("#.0");
                txtvKQBMI.setText(df.format(bmi));
                //txtvKQBMI.setText(String.valueOf(bmi));
                txtvKQKetLuan.setText(ketluan);
            }
        });
    }
}
