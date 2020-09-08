package com.example.tongpao.ui.myOwn.perinfofragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.tongpao.R;
import com.example.tongpao.base.BaseFragment;
import com.example.tongpao.base.IBasePresenter;
import com.example.tongpao.bean.PerInfoBean;
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.constract.home.IHome;
import com.example.tongpao.ui.myOwn.activity.PerInfoActivity;
import com.example.tongpao.util.DateUtil;
import com.google.gson.Gson;

import butterknife.BindView;

public class InformationFragment extends BaseFragment {
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.tv_constellations)
    TextView tvConstellations;
    @BindView(R.id.tv_des)
    TextView tvLocation;
    @BindView(R.id.card)
    CardView cardView;

    private int TYPE;
    private PerInfoBean data;
    public IHome.ILoadData iLoadData;

    public static InformationFragment getInstance(int type, IHome.ILoadData iLoadData){
        InformationFragment informationFragment = new InformationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        informationFragment.iLoadData = iLoadData;
        informationFragment.setArguments(bundle);
        return informationFragment;
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (!EventBus.getDefault().isRegistered(this)){
//            EventBus.getDefault().register(this);
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (EventBus.getDefault().isRegistered(this)){
//            EventBus.getDefault().unregister(this);
//        }
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void getData(EventContant eventContant){
//        PerInfoBean perInfoBean = eventContant.getPerInfoBean();
//        PerInfoBean.DataBean data = perInfoBean.getData();
//        if (data.getSex().equals("1")){
//            tvSex.setText("女");
//        }
//        if (!TextUtils.isEmpty(data.getBirthday())){
//            tvBirthday.setText(data.getBirthday());
//        }
//        if (!TextUtils.isEmpty(data.getCity())){
//            tvLocation.setText(data.getCity());
//        }
//    }

    @Override
    protected void initView(View view) {
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("type")){
            TYPE = bundle.getInt("type");
        }
        if(iLoadData != null){
            iLoadData.loadData(TYPE);
        }
        ((PerInfoActivity)getActivity()).setVpTouch(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences login = context.getSharedPreferences("login", 0);
        String dataStr = login.getString("data", "");
        if (!TextUtils.isEmpty(dataStr)){
            UserLoginBean userLoginBean = new Gson().fromJson(dataStr, UserLoginBean.class);
            UserLoginBean.DataBean dataBean = userLoginBean.getData();
            if (!TextUtils.isEmpty(dataBean.getAdress())){
                tvLocation.setText(dataBean.getAdress());
            }
            if (!TextUtils.isEmpty(dataBean.getBirthday())){
                tvBirthday.setText(DateUtil.getDateToString(Long.parseLong(dataBean.getBirthday()+"000"),"yyyy-MM-dd"));
            }
            if (dataBean.getSex() == 0){
                tvSex.setText("男");
            }else {
                tvSex.setText("女");
            }
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_information;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && cardView != null){
            if (data != null){
                if (iLoadData != null){
                    iLoadData.loadData(TYPE);
                }
            }
        }
    }
    public void setData(PerInfoBean data){
        this.data = data;
        PerInfoBean.DataBean data1 = data.getData();
        if (tvSex == null) return;
        if (data1.getSex().equals("1")){
            tvSex.setText("女");
        }
        if (!TextUtils.isEmpty(data1.getBirthday())){
            tvBirthday.setText(data1.getBirthday());
        }
        if (!TextUtils.isEmpty(data1.getCity())){
            tvLocation.setText(data1.getCity());
        }
    }
}
