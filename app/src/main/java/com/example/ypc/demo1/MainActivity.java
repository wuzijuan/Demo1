package com.example.ypc.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ypc.demo1.dao.DaoMaster;
import com.example.ypc.demo1.dao.DemoBeanDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DemoBeanDao demoBeanDao = DaoMaster.newDevSession(this, DemoBeanDao.TABLENAME).getDemoBeanDao();
        List<DemoBean> demoBeans = demoBeanDao.loadAll();

        if(demoBeans.size()==0){
           Log.e("无数据","无数据");

        }else{
            DemoBean demoBean = demoBeans.get(0);
            Log.d("TAG",demoBeans.toString());
            textView.setText(demoBean.getCriy()+":"+demoBean.getPrice()+":"+demoBean.getStare()+"::"+demoBean.getType());
        }
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(this, CityActivity.class));
                break;
        }
    }
}
