package com.example.day29_6_29_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.day29_6_29_2.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(root.getRoot());
        initData();
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            final TabData tabData = new Gson().fromJson(responseBody.string(), TabData.class);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    List<TabData.DataBean> data = tabData.getData();
                                    List<Fragment> fragments = new ArrayList<>();
                                    for (int i = 0; i < data.size(); i++) {
                                        int id = data.get(i).getId();
                                        ProjectFragments projectFragments = new ProjectFragments();
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("id",id);
                                        projectFragments.setArguments(bundle);
                                        fragments.add(projectFragments);
                                    }
                                    VpFragmentAdapter vpProFragmentAdapter = new VpFragmentAdapter(getSupportFragmentManager(), fragments);
                                    root.vpProject.setAdapter(vpProFragmentAdapter);
                                    root.tab.setupWithViewPager(root.vpProject);
                                    for (int i = 0; i < fragments.size(); i++) {
                                        root.tab.getTabAt(i).setCustomView(getView(data.get(i).getName()));
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private View getView(String name) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_tab_item, null);
        TextView tv_pro_tab = inflate.findViewById(R.id.tv_pro_tab);
        tv_pro_tab.setText(name);
        return inflate;
    }
}
