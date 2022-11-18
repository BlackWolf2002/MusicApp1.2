package exam.lesson.myapplication.Service;

import java.util.List;

import exam.lesson.myapplication.Model.Quangcao;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();
}
