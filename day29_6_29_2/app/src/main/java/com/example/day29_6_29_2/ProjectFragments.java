package com.example.day29_6_29_2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.day29_6_29_2.databinding.FragmentProjectFragmentsBinding;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ProjectFragments extends Fragment {
    private FragmentProjectFragmentsBinding root;
    private int page = 1;
    private String path;
    private InfoRclAdapter infoRclAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = FragmentProjectFragmentsBinding.inflate(LayoutInflater.from(getContext()));
        return root.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        int id = arguments.getInt("id");
        path = "https://www.wanandroid.com/project/list/"+page+"/json?cid="+id;
        initView();
        initData();
    }

    private void initData() {
        new OkHttpClient().newCall(new Request.Builder().get().url(path).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final TabItemData tabItemData = new Gson().fromJson(response.body().string(), TabItemData.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        infoRclAdapter.setList(tabItemData.getData().getDatas());
                    }
                });
            }
        });
    }

    private void initView() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.rlv_line));
        root.rlvProject.addItemDecoration(dividerItemDecoration);
        root.rlvProject.setLayoutManager(new LinearLayoutManager(getContext()));
        infoRclAdapter = new InfoRclAdapter(getContext());
        root.rlvProject.setAdapter(infoRclAdapter);
        infoRclAdapter.setOnItemClickListener(new InfoRclAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position) {
                View view1 = root.rlvProject.getLayoutManager().findViewByPosition(position);
                ImageView love = view1.findViewById(R.id.img_heart);
                if (love.isSelected()){
                    love.setSelected(false);
                }else {
                    love.setSelected(true);
                }
            }
        });
    }
}
