package com.dzs.ezpay.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dzs.ezpay.R;
import com.dzs.ezpay.common.BaseActivity;
import com.dzs.ezpay.view.adapter.FmPagerAdapter;
import com.dzs.ezpay.view.customview.NoScrollViewPager;
import com.dzs.ezpay.view.fragment.MenuFinFragment;
import com.dzs.ezpay.view.fragment.MenuLifeFragment;
import com.dzs.ezpay.view.fragment.MenuPayFragment;
import com.dzs.ezpay.view.fragment.MenuPersonFragment;
import com.dzs.ezpay.view.impl.IHomeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IHomeView{

    @Bind(R.id.tvRecordList)
    TextView tvRecordList;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.Container)
    NoScrollViewPager Container;
    @Bind(R.id.rbPay)
    RadioButton rbPay;
    @Bind(R.id.rbLife)
    RadioButton rbLife;
    @Bind(R.id.rbFin)
    RadioButton rbFin;
    @Bind(R.id.rbMe)
    RadioButton rbMe;
    @Bind(R.id.rgBottoms)
    RadioGroup rgBottoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        adapter = new FmPagerAdapter(getSupportFragmentManager());
        Container.setAdapter(adapter);
        rgBottoms.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbPay:
                        Container.setCurrentItem(0);
                        break;
                    case R.id.rbLife:
                        Container.setCurrentItem(1);

                        break;
                    case R.id.rbFin:
                        Container.setCurrentItem(2);

                        break;
                    case R.id.rbMe:
                        Container.setCurrentItem(3);

                        break;
                }
            }
        });
        initFragments();
    }

    private FmPagerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<>();
    private MenuPayFragment menuPayFragment = new MenuPayFragment();
    private MenuLifeFragment menuLifeFragment = new MenuLifeFragment();
    private MenuFinFragment menuFinFragment = new MenuFinFragment();
    private MenuPersonFragment menuPersonFragment = new MenuPersonFragment();

    @Override
    public void initFragments() {
        fragments.clear();
        fragments.add(menuPayFragment);
        fragments.add(menuLifeFragment);
        fragments.add(menuFinFragment);
        fragments.add(menuPersonFragment);
        adapter.setFragments(fragments);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);
                builder.setTitle("温馨提示：")
                        .setMessage("您确定退出程序吗？")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        finish();
                                    }
                                })
                        .setNegativeButton("取消",
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        dialog.dismiss();
                                    }
                                }).create().show();
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

}
