package exam.lesson.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import exam.lesson.myapplication.Adapter.MainViewPageAdapter;
import exam.lesson.myapplication.Fragment.Fragment_Tim_Kiem;
import exam.lesson.myapplication.Fragment.Fragment_Trang_Chu;
import exam.lesson.myapplication.R;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private  void init(){
        MainViewPageAdapter mainViewPageAdapter=new MainViewPageAdapter(getSupportFragmentManager());
        mainViewPageAdapter.addFragment(new Fragment_Trang_Chu(),"Trang chủ");
        mainViewPageAdapter.addFragment(new Fragment_Tim_Kiem(),"Tìm kiếm");
        viewPager.setAdapter(mainViewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.img_1);
        tabLayout.getTabAt(1).setIcon(R.drawable.img);
    }

    private void  anhxa(){
        tabLayout=findViewById(R.id.myTablayout);
        viewPager=findViewById(R.id.myViewPager);
    }
}