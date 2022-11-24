package exam.lesson.myapplication.Service;

import java.util.List;

import exam.lesson.myapplication.Model.Album;
import exam.lesson.myapplication.Model.Baihat;
import exam.lesson.myapplication.Model.Playlist;
import exam.lesson.myapplication.Model.Quangcao;
import exam.lesson.myapplication.Model.Theloaitrongngay;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();


    @GET ("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("chudevatheloaitrongngay.php")
     Call<Theloaitrongngay> GetCategoryMusic() ;

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao")String idquangcao);




}
