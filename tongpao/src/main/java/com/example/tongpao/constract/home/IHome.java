package com.example.tongpao.constract.home;

import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.base.IBaseView;
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

public interface IHome {

    interface IView extends IBaseView{

    }
    interface IPresenter extends IBasePresenter{

    }
    //首页推荐
    interface IRecommendView extends IBaseView{
        void setBanner(BannerBean bannerBean);
        void setHotTopic(HotTopicBean hotTopicBean);
        void setRecommend(RecommendBean recommendBean);
        void setHotUser(HotUserBean hotUserBean);
    }
    interface IRecommendPresenter extends IBasePresenter<IRecommendView>{
        void getBanner(String url);
        void getRecommend(String url);
        void getHotUser(String url);
        void getHotTopic(String url);
    }
    //个人信息  社团信息  文章信息
    interface IPerInfoView extends IBaseView{
        void setPersonal(PerInfoBean personal);
        void setCommunity(PerCommunityBean community);
        void setArticle(PerArticleBean article);
    }
    interface IPerInfoPresenter extends IBasePresenter<IPerInfoView>{
        void getPersonal(String url);
        void getCommunity(String url);
        void getArticle(String url);
    }
    //ta的主页 动态信息
    interface IPerDynamicView extends IBaseView{
        void setDynamic(PerDynamicStateBean perDynamicStateBean);
    }
    interface IPerDynamicPresenter extends IBasePresenter<IPerDynamicView>{
        void getDynamic(String url);
    }
    //ta的主页 动态信息
    interface IPerActivitiesView extends IBaseView{
        void setActivities(PerActiviesBean activiesBean);
    }
    interface IPerActivitiesPresenter extends IBasePresenter<IPerActivitiesView>{
        void getActivities(String url);
    }
    //activity请求网络数据 传入fragment回调接口
    interface ILoadData {
        void loadData(int type);
    }
    //首页广场
    interface ISquareView extends IBaseView{
        void setSquare(SquareBean square);
    }
    interface ISquarePresenter extends IBasePresenter<ISquareView>{
        void getSquare(String url);
    }

    //首页视频
    interface IVideoView extends IBaseView{
        void setVideo(VideoBean video);
    }
    interface IVideoPresenter extends IBasePresenter<IVideoView>{
        void getVideo(String url);
    }

    //首页摄影
    interface IPhotoView extends IBaseView{
        void setPhoto(PhotoBean video);
    }
    interface IPhotoPresenter extends IBasePresenter<IPhotoView>{
        void getPhoto(String url);
    }

    //首页知识文章
    interface IArticleView extends IBaseView{
        void setArticle(ArticleBean article);
    }
    interface IArticlePresenter extends IBasePresenter<IArticleView>{
        void getArticle(String url);
    }

    //首页知识文章
    interface IRewardView extends IBaseView{
        void setReward(RewardBean rewardBean);
    }
    interface IRewardPresenter extends IBasePresenter<IRewardView>{
        void getReward(String url);
    }

    //首页认识汉服
    interface IAboutHanFuView extends IBaseView{
        void setAboutHanFu(AboutHanFuBean aboutHanFuBean);
    }
    interface IAboutHanFuPresenter extends IBasePresenter<IAboutHanFuView>{
        void getAboutHanFu(String url);
    }
    //首页认识汉服详情
    interface IAboutHanFuDetailView extends IBaseView{
        void setAboutHanFuDetail(AboutHanFuDetailBean aboutHanFuDetailBean);
    }
    interface IAboutHanFuDetailPresenter extends IBasePresenter<IAboutHanFuDetailView>{
        void getAboutHanFuDetail(String url);
    }

    //首页传统礼仪
    interface ISingleView extends IBaseView{
        void setSingle(SingleBean singleBean);
    }
    interface ISinglePresenter extends IBasePresenter<ISingleView>{
        void getSingle(String url);
    }
    //首页传统礼仪详情
    interface ISingleDetailView extends IBaseView{
        void setSingleDetail(SingleDetailBean singleBean);
    }
    interface ISingleDetailPresenter extends IBasePresenter<ISingleDetailView>{
        void getSingleDetail(String url);
    }

    //首页汉服演进史
    interface IHistoryView extends IBaseView{
        void setHistory(HistoryBean histroyBean);
    }
    interface IHistoryPresenter extends IBasePresenter<IHistoryView>{
        void getHistory(String url);
    }
    //首页汉服演进史详情
    interface IHistoryDetailView extends IBaseView{
        void setHistoryDetail(HistoryDetailBean historyDetailBean);
    }
    interface IHistoryDetailPresenter extends IBasePresenter<IHistoryDetailView>{
        void getHistoryDetail(String url);
    }

    //首页汉服大事件
    interface IEventsHanFuView extends IBaseView{
        void setEventsHanFu(EventsHanFuBean eventsHanFuBean);
    }
    interface IEventsHanFuPresenter extends IBasePresenter<IEventsHanFuView>{
        void getEventsHanFu(String url);
    }
    //首页汉服大事件详情
    interface IEventsHanFuDetailView extends IBaseView{
        void setEventsHanFuDetail(EventsHanFuDetailBean eventsHanFuDetailBean);
    }
    interface IEventsHanFuDetailPresenter extends IBasePresenter<IEventsHanFuDetailView>{
        void getEventsHanFuDetail(String url);
    }
}
