package com.example.ypc.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ypc.demo1.dao.DaoMaster;
import com.example.ypc.demo1.dao.DemoBeanDao;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity implements View.OnClickListener {

    private Button screen;
    private RecyclerView recycler;
    private RadioGroup typegroup;
    private RadioGroup pricegroup;
    private RecyclerView recycler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initView();
        initData();
    }
    private DemoBeanDao demoBeanDao;
    public static List<List<String>> city = new ArrayList<>();
    private DemoBean demoBean=new DemoBean();
    private void initData() {
        final List<String> state = new ArrayList<>();
        state.add("美国");
        state.add("法国");
        state.add("中国");

        List<String> mg = new ArrayList<>();
        mg.add("华盛顿");
        mg.add("纽约");
        mg.add("芝加哥");
        mg.add("洛杉矶");
        mg.add("费城");
        mg.add("波士顿");
        mg.add("旧金山");
        mg.add("休斯敦");
        mg.add("亚特兰大");
        city.add(mg);
        List<String> els = new ArrayList<>();
        els.add("莫斯科");
        els.add("圣彼得堡");
        els.add("符拉迪沃斯托克（海参崴");
        els.add("叶卡捷琳堡");
        els.add("新西伯利亚");
        els.add("下诺夫哥罗德 ");
        els.add("罗斯托夫");
        els.add("乌兰乌德");
        els.add("摩尔曼斯克");
        els.add("索契");
        city.add(els);
        List<String> zg = new ArrayList<>();
        zg.add("石家庄");
        zg.add("天津");
        zg.add("福建省");
        zg.add("甘肃省");
        zg.add("贵州省");
        zg.add("海南省");
        zg.add("河北省");
        zg.add("黑龙江省");
        zg.add("山东省");
        zg.add("山西省");
        zg.add("陕西省");
        zg.add("四川省");
        zg.add("云南省");
        city.add(zg);


        List<Bean> ppps=new ArrayList<>();
        for (int i = 0; i < state.size(); i++) {
            ppps.add(new Bean(false));
        }
        final Recycle ab1=new Recycle(this,state,city,ppps);
        recycler.setAdapter(ab1);

        final List<Bean> pppssss=new ArrayList<>();
        demoBeanDao = DaoMaster.newDevSession(this, DemoBeanDao.TABLENAME).getDemoBeanDao();
        ab1.setOnItemClickListener(new Recycle.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int postion) {
                final List<String> stringList;
                stringList = city.get(postion);
                for (int i = 0; i < stringList.size(); i++) {
                    pppssss.add(new Bean(false));
                }
                Ab2 ab2=new Ab2(CityActivity.this,stringList,pppssss);
                recycler2.setAdapter(ab2);
                final CheckBox checkBox=view.findViewById(R.id.cicyitemtext111);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            Toast.makeText(CityActivity.this, "选中", Toast.LENGTH_SHORT).show();
                            demoBean.setStare(state.get(postion));
                        }else {
                            Toast.makeText(CityActivity.this, "取消", Toast.LENGTH_SHORT).show();

                        }
                        ab1.notifyDataSetChanged();
                    }
                });
                ab2.setOnItemClickListener(new Ab2.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int postion) {
                        final CheckBox checkBox=view.findViewById(R.id.cicyitemtext);
                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked){
                                    Toast.makeText(CityActivity.this, "选中", Toast.LENGTH_SHORT).show();
                                    demoBean.setCriy(stringList.get(postion));
                                }else {
                                    Toast.makeText(CityActivity.this, "取消", Toast.LENGTH_SHORT).show();
                                }
                                ab1.notifyDataSetChanged();
                            }
                        });
                    }
                });
                ab2.notifyDataSetChanged();

            }
        });

        typegroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.type1:
                        demoBean.setType("别墅");
                        break;
                    case R.id.type2:
                        demoBean.setType("一居室");

                        break;
                    case R.id.type3:
                        demoBean.setType("二居室");
                        break;
                    case R.id.type4:
                        demoBean.setType("三居室");
                        break;
                }
            }
        });
        pricegroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.price1:
                        demoBean.setPrice("50-1000");
                        break;
                    case R.id.price2:
                        demoBean.setPrice("20000");

                        break;
                    case R.id.price3:
                        demoBean.setPrice("200000");

                        break;

                }
            }
        });
    }

    private void initView() {
        screen = (Button) findViewById(R.id.screen);

        screen.setOnClickListener(this);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setOnClickListener(this);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        typegroup = (RadioGroup) findViewById(R.id.typegroup);
        typegroup.setOnClickListener(this);
        pricegroup = (RadioGroup) findViewById(R.id.pricegroup);
        pricegroup.setOnClickListener(this);
        recycler2 = (RecyclerView) findViewById(R.id.recycler2);
        recycler2.setOnClickListener(this);
        recycler2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.screen:
                demoBeanDao.insertOrReplaceInTx(demoBean);
                finish();
                break;
        }
    }
}
