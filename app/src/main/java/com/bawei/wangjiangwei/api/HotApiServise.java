package com.bawei.wangjiangwei.api;

import com.bawei.wangjiangwei.model.entity.HotEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface HotApiServise {

    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<HotEntity> hot(@Query("page") int page, @Query("count") int count);

}
