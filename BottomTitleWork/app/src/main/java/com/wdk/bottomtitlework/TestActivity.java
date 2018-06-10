package com.wdk.bottomtitlework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {


    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    EditText txt2;
    @BindView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        Toast.makeText(this,txt2.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.txt1, R.id.txt2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt1:
                break;
            case R.id.txt2:
                break;
        }
    }
}
