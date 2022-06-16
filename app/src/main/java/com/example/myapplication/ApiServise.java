package com.example.myapplication;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiServise {

    /**
     * get请求方式
     * @Query
     * 形成单个查询参数, 将接口url中追加类似于"page=1"的字符串,形成提交给服务器端的参数,
     * 主要用于Get请求数据，用于拼接在拼接在url路径后面的查询参数，一个@Query相当于拼接一个参数
     */
    String HOST = "https://mock.presstime.cn/mock/627d02e5a4d920002f108c46/";        //接口地址
    @GET("query")
    Observable<BaseReponse<Object>> getList();


}

