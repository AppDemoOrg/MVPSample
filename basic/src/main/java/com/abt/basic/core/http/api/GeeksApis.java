package com.abt.basic.core.http.api;


import com.abt.basic.core.bean.BaseResponse;
import com.abt.basic.core.bean.hierarchy.KnowledgeHierarchyData;
import com.abt.basic.core.bean.main.banner.BannerData;
import com.abt.basic.core.bean.main.collect.FeedArticleListData;
import com.abt.basic.core.bean.main.login.LoginData;
import com.abt.basic.core.bean.main.search.TopSearchData;
import com.abt.basic.core.bean.main.search.UsefulSiteData;
import com.abt.basic.core.bean.navigation.NavigationListData;
import com.abt.basic.core.bean.project.ProjectClassifyData;
import com.abt.basic.core.bean.project.ProjectListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @描述： @GeeksApis
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public interface GeeksApis {

    String HOST = "http://www.wanandroid.com/";

    /**
     * 获取feed文章列表
     *
     * @param num 页数
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @GET("article/list/{num}/json")
    Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(@Path("num") int num);

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     * @param page page
     * @param k POST search key
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<BaseResponse<FeedArticleListData>> getSearchList(@Path("page") int page, @Field("k") String k);

    /**
     * 热搜
     * http://www.wanandroid.com//hotkey/json
     *
     * @return Observable<BaseResponse<List<TopSearchData>>>
     */
    @GET("hotkey/json")
    @Headers("Cache-Control: public, max-age=36000")
    Observable<BaseResponse<List<TopSearchData>>> getTopSearchData();

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     *
     * @return Observable<BaseResponse<List<UsefulSiteData>>>
     */
    @GET("friend/json")
    Observable<BaseResponse<List<UsefulSiteData>>> getUsefulSites();

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return Observable<BaseResponse<List<BannerData>>>
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerData>>> getBannerData();

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return Observable<BaseResponse<List<KnowledgeHierarchyData>>>
     */
    @GET("tree/json")
    Observable<BaseResponse<List<KnowledgeHierarchyData>>> getKnowledgeHierarchyData();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0?cid=60
     *
     * @param page page num
     * @param cid second page id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @GET("article/list/{page}/json")
    Observable<BaseResponse<FeedArticleListData>> getKnowledgeHierarchyDetailData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 导航
     * http://www.wanandroid.com/navi/json
     *
     * @return Observable<BaseResponse<List<NavigationListData>>>
     */
    @GET("navi/json")
    Observable<BaseResponse<List<NavigationListData>>> getNavigationListData();

    /**
     * 项目分类
     * http://www.wanandroid.com/project/tree/json
     *
     * @return Observable<BaseResponse<List<ProjectClassifyData>>>
     */
    @GET("project/tree/json")
    Observable<BaseResponse<List<ProjectClassifyData>>> getProjectClassifyData();

    /**
     * 项目类别数据
     * http://www.wanandroid.com/project/list/1/json?cid=294
     *
     * @param page page num
     * @param cid second page id
     * @return Observable<BaseResponse<ProjectListData>>
     */
    @GET("project/list/{page}/json")
    Observable<BaseResponse<ProjectListData>> getProjectListData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return Observable<BaseResponse<LoginData>>
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginData>> getLoginData(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     *
     * @param username user name
     * @param password password
     * @param repassword re password
     * @return Observable<BaseResponse<LoginData>>
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<LoginData>> getRegisterData(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 收藏站内文章
     * http://www.wanandroid.com/lg/collect/1165/json
     *
     * @param id article id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseResponse<FeedArticleListData>> addCollectArticle(@Path("id") int id);

    /**
     * 收藏站外文章
     * http://www.wanandroid.com/lg/collect/add/json
     *
     * @param title title
     * @param author author
     * @param link link
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @POST("lg/collect/add/json")
    @FormUrlEncoded
    Observable<BaseResponse<FeedArticleListData>> addCollectOutsideArticle(@Field("title") String title, @Field("author") String author, @Field("link") String link);


    /**
     * 获取收藏列表
     * http://www.wanandroid.com/lg/collect/list/0/json
     *
     * @param page page number
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @GET("lg/collect/list/{page}/json")
    Observable<BaseResponse<FeedArticleListData>> getCollectList(@Path("page") int page);

    /**
     * 取消站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @param originId origin id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<BaseResponse<FeedArticleListData>> cancelCollectPageArticle(@Path("id") int id, @Field("originId") int originId);

    /**
     * 取消收藏页面站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @param originId origin id
     * @return Observable<BaseResponse<FeedArticleListData>>
     */
    @POST("lg/uncollect_originId/{id}/json")
    @FormUrlEncoded
    Observable<BaseResponse<FeedArticleListData>> cancelCollectArticle(@Path("id") int id, @Field("originId") int originId);

}
