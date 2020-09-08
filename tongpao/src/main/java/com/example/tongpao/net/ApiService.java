package com.example.tongpao.net;

import com.example.tongpao.bean.AboutHanFuBean;
import com.example.tongpao.bean.AboutHanFuDetailBean;
import com.example.tongpao.bean.ArticleBean;
import com.example.tongpao.bean.BannerBean;
import com.example.tongpao.bean.EventsHanFuBean;
import com.example.tongpao.bean.EventsHanFuDetailBean;
import com.example.tongpao.bean.HistoryBean;
import com.example.tongpao.bean.HistoryDetailBean;
import com.example.tongpao.bean.HotTopicBean;
import com.example.tongpao.bean.HotUserBean;
import com.example.tongpao.bean.PerActiviesBean;
import com.example.tongpao.bean.PerArticleBean;
import com.example.tongpao.bean.PerCommunityBean;
import com.example.tongpao.bean.PerDynamicStateBean;
import com.example.tongpao.bean.PerInfoBean;
import com.example.tongpao.bean.PhotoBean;
import com.example.tongpao.bean.RecommendBean;
import com.example.tongpao.bean.RewardBean;
import com.example.tongpao.bean.SingleBean;
import com.example.tongpao.bean.SingleDetailBean;
import com.example.tongpao.bean.SquareBean;
import com.example.tongpao.bean.VideoBean;
import com.example.tongpao.bean.discover.AssociationBean;
import com.example.tongpao.bean.discover.DisCoverTopicBean;
import com.example.tongpao.bean.discover.DiscoverBaikeBean;
import com.example.tongpao.bean.discover.DiscoverRankMoneyBean;
import com.example.tongpao.bean.discover.DiscoverRankSignBean;
import com.example.tongpao.bean.discover.DiscoverRedianBean;
import com.example.tongpao.bean.discover.DiscoverTushangBean;
import com.example.tongpao.bean.discover.DiscoverZhuangzaoBean;
import com.example.tongpao.bean.discover.DiscoverranklevelBean;
import com.example.tongpao.bean.discover.NearByBean;
import com.example.tongpao.bean.discover.RoommateBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    String baseUrl = "http://cdwan.cn:7000/tongpao/";

    //获取轮播图数据
    @GET
    Flowable<BannerBean> getBanner(@Url String url);

    //获取热门话题数据
    @GET
    Flowable<HotTopicBean> getHotTopic(@Url String url);

    //获取推荐数据
    @GET
    Flowable<RecommendBean> getRecommend(@Url String url);

    //获取热门用户数据
    @GET
    Flowable<HotUserBean> getHotUser(@Url String url);

    //获取个人信息数据
    @GET
    Flowable<PerInfoBean> getPerInfo(@Url String url);

    //获取个人信息动态页面数据
    @GET
    Flowable<PerDynamicStateBean> getPerDynamic(@Url String url);

    //获取个人信息活动页面数据
    @GET
    Flowable<PerActiviesBean> getPerActivities(@Url String url);

    //获取个人信息社团页面数据
    @GET
    Flowable<PerCommunityBean> getPerCommunity(@Url String url);

    //获取个人信息文章页面数据
    @GET
    Flowable<PerArticleBean> getPerArticle(@Url String url);

    //获取首页广场页面数据
    @GET
    Flowable<SquareBean> getSqare(@Url String url);

    //获取首页视频页面数据
    @GET
    Flowable<VideoBean> getVideo(@Url String url);

    //获取首页摄影页面数据
    @GET
    Flowable<PhotoBean> getPhoto(@Url String url);

    //获取首页知识文章页面数据
    @GET
    Flowable<ArticleBean> getArticle(@Url String url);

    //获取首页悬赏页面数据
    @GET
    Flowable<RewardBean> getReward(@Url String url);

    //获取认识汉服页面数据
    @GET
    Flowable<AboutHanFuBean> getAboutHanFu(@Url String url);

    //获取认识汉服详情页面数据
    @GET
    Flowable<AboutHanFuDetailBean> getAboutHanFuDetail(@Url String url);

    //获取传统礼仪页面数据
    @GET
    Flowable<SingleBean> getSingle(@Url String url);

    //获取传统礼仪详情页面数据
    @GET
    Flowable<SingleDetailBean> getSingleDetail(@Url String url);

    //获取汉服演进史页面数据
    @GET
    Flowable<HistoryBean> getHistory(@Url String url);

    //获取汉服演进史详情页面数据
    @GET
    Flowable<HistoryDetailBean> getHistoryDetail(@Url String url);

    //获取汉服大事件页面数据
    @GET
    Flowable<EventsHanFuBean> getEventsHanFu(@Url String url);

    //获取汉服大事件详情页面数据
    @GET
    Flowable<EventsHanFuDetailBean> getEventsHanFuDetail(@Url String url);

    //发现页面  热门活动
    @GET("discover/hot_activity.json")
    Flowable<DisCoverTopicBean> getDiscoverTopic();
    //发现页面 点击排行榜跳转到等级榜数据
    @GET("discover/rank_level.json")
    Flowable<DiscoverranklevelBean> getLevel();
    //发现页面 点击排行榜跳转到土豪榜数据
    @GET("discover/rank_money.json")
    Flowable<DiscoverRankMoneyBean> getMoney();
    //发现页面 点击排行榜跳转到签到榜数据
    @GET("discover/rank_sign.json")
    Flowable<DiscoverRankSignBean> getSign();
    //发现页面 点击社团跳转到相应页面
    //社团
    @GET("discover/association.json")
    Flowable<AssociationBean> getAssociationData();
    //袍子
    @GET("discover/robe.json")
    Flowable<RoommateBean> getRoommate();
    //袍子附近
    @GET("discover/robe_near.json")
    Flowable<NearByBean> getNearBeanData();
    //发现页面 热点数据
    @GET("discover/news_1.json")
    Flowable<DiscoverRedianBean> getRedian();

    //发现页面 妆造数据
    @GET("discover/news_2.json")
    Flowable<DiscoverZhuangzaoBean> getZhuangzao();
    //发现页面 图赏数据
    @GET("discover/news_3.json")
    Flowable<DiscoverTushangBean> getTushang();
    //发现页面 百科数据
    @GET("discover/news_4.json")
    Flowable<DiscoverBaikeBean> getBaike();
}
