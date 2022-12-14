package exam.lesson.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import exam.lesson.myapplication.Model.Baihat;
import exam.lesson.myapplication.Model.Quangcao;
import exam.lesson.myapplication.R;
import exam.lesson.myapplication.Service.APIService;
import exam.lesson.myapplication.Service.DataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerViewdanhsachbaihat;
    Quangcao  quangcao;
    ImageView imgdanhsachcakhuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DateIntent();
        anhxa();
        inint();
        if (quangcao != null && !quangcao.getTenBaiHat().equals("")){
         setValueInView(quangcao.getTenBaiHat(), quangcao.getHinhanh());
         getDataQuangCao(quangcao.getIdQuangCao());
        }
    }


    private void getDataQuangCao(String idquangcao) {
        DataService dataService = APIService.getService();
        Call<List<Baihat>> callback = dataService.GetDanhsachbaihattheoquangcao(idquangcao);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> mangbaihat = (ArrayList<Baihat>) response.body();
                Log.d("BBB",mangbaihat.get(0).getTenBaiHat());
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
    private void setValueInView(String ten , String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable =new BitmapDrawable(getResources(),bitmap);
            collapsingToolbarLayout.setBackground((bitmapDrawable));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachcakhuc);
    }

    private void inint(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

    }

    private void anhxa() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout= findViewById(R.id.collapsingtoolbar);
        toolbar = findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton = findViewById( R.id.floatingactionbutton);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
    }

    private void DateIntent() {
        Intent intent = getIntent();
        if(intent!= null){
            if(intent.hasExtra("Banner")){
                quangcao =(Quangcao) intent.getSerializableExtra("Banner");
                Toast.makeText(this,quangcao.getTenBaiHat(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}