package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher
{
    RadioGroup unit;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit = findViewById(R.id.unit);
        //設定單選鈕的改變選擇監聽
        unit.setOnCheckedChangeListener(this);

        value = findViewById(R.id.value);
        //設定改變文字的監看器
        value.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }
    //自動加入的方法，在文字改變中，本次範例不用
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }
    //自動加入的方法，在文字改變後，要計算，所以直接使用自定義的方法
    @Override
    public void afterTextChanged(Editable editable) {
        //打完紅字用alt+enter加入方法
        calc();

    }
    //自動加入的方法，在改變單選鈕時，一樣加入計算方法
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        calc();

    }
    //自定義的計算方法
    private void calc() {
        //找到文字顯示物件
        TextView degF = findViewById(R.id.degF);
        TextView degC = findViewById(R.id.degC);


        //定義兩個數字，方便後面的運算
        double f, c;
        //判斷如果是華氏被選到的時候
        if (unit.getCheckedRadioButtonId() == R.id.unitF) {
            //取得輸入數字
            if (value.getText().toString().length() ==0)
                return;
            else {
                f = Double.parseDouble(value.getText().toString());
                //換算成c
                c = (f - 32) * 5 / 9;
            }
        } else {
            if (value.getText().toString().length() ==0)
                return;
            else {
                //取得輸入數字
                c = Double.parseDouble(value.getText().toString());
                //換算成f
                f = c * 9 / 5 + 32;}
        }
        //顯示結果
        //只顯示小數點後一位 然後加上符號 自資源檔取得字串
        degC.setText(String.format("%.1f", c) + getResources().getString(R.string.charC));
        degF.setText(String.format("%.1f", f) + getResources().getString(R.string.charF));

    }

}




