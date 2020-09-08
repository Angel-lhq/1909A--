package com.example.tongpao.ui.myOwn.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.tongpao.R;
import com.example.tongpao.app.GlideEngine;
import com.example.tongpao.base.BaseActivity;
import com.example.tongpao.bean.JsonBean;
import com.example.tongpao.bean.UserLoginBean;
import com.example.tongpao.bean.UserUpdateBean;
import com.example.tongpao.constract.myOwn.IMyOwn;
import com.example.tongpao.net.UpLoadApi;
import com.example.tongpao.presenter.myOwn.UpDatePresenter;
import com.example.tongpao.util.DateUtil;
import com.example.tongpao.util.GetJsonDataUtil;
import com.example.tongpao.util.HttpUtil;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.soundcloud.android.crop.Crop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class EditPerInfoActivity extends BaseActivity<IMyOwn.IUpDatePresenter> implements IMyOwn.IUpDateView,View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.img_name_into)
    ImageView imgName;
    @BindView(R.id.img_birth_into)
    ImageView imgBirth;
    @BindView(R.id.img_location_into)
    ImageView imgLocation;
    @BindView(R.id.img_sex_into)
    ImageView imgSex;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_phone)
    TextView tvPhone;


    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;

    DateFormat format= DateFormat.getDateTimeInstance();
    Calendar calendar= Calendar.getInstance(Locale.CHINA);
    private UserLoginBean.DataBean dataBean;
    private String url;
    private UserLoginBean userLoginBean;
    private SharedPreferences login;
    private String location;
    private String sex;
    private String phone;
    private static String birth;
    private String name;

    @Override
    protected IMyOwn.IUpDatePresenter initPresenter() {
        return new UpDatePresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        login = getSharedPreferences("login", 0);
        String data = login.getString("data", "");
        if (!TextUtils.isEmpty(data)){
            userLoginBean = new Gson().fromJson(data, UserLoginBean.class);
            dataBean = userLoginBean.getData();
        }
        initJsonData();
        imgBack.setOnClickListener(this);
        imgHead.setOnClickListener(this);
        imgBirth.setOnClickListener(this);
        imgSex.setOnClickListener(this);
        imgLocation.setOnClickListener(this);
        imgName.setOnClickListener(this);
        tvPhone.setOnClickListener(this);

        if (!TextUtils.isEmpty(dataBean.getAvater())){
            Glide.with(this).load(dataBean.getAvater()).apply(RequestOptions.circleCropTransform()).into(imgHead);
        }
        if(dataBean.getNickname() != null && !TextUtils.isEmpty(dataBean.getNickname())){
            tvName.setText(dataBean.getNickname());
        }else if (!TextUtils.isEmpty(dataBean.getUsername())){
            tvName.setText(dataBean.getUsername());
        }
        if (dataBean.getSex() == 0){
            tvSex.setText("男");
        }else if (dataBean.getSex() == 1){
            tvSex.setText("女");
        }else {
            tvSex.setText("请选择性别");
        }
        if (!TextUtils.isEmpty(dataBean.getBirthday())){
            tvBirth.setText(DateUtil.getDateToString(Long.parseLong(dataBean.getBirthday()+"000"),"yyyy-MM-dd"));
        }else {
            tvBirth.setText("请选择生日");
        }
        if (!TextUtils.isEmpty(dataBean.getAdress())){
            tvLocation.setText(dataBean.getAdress());
        }else {
            tvLocation.setText("请选择地区");
        }
        if (!TextUtils.isEmpty(dataBean.getPhone())){
            tvPhone.setText(dataBean.getPhone());
        }else {
            tvPhone.setText("请输入手机号");
        }


        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_edit_per_info;
    }

    //打开相册
    private void openPhoto(){
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
                .maxSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_head:
                openPhoto();
                break;
            case R.id.img_birth_into:
//                showDialog(DATE_DIALOG);
                showDatePickerDialog(this,  2, tvBirth, calendar);
                break;
            case R.id.img_location_into:
                showPickerView();
                break;
            case R.id.img_name_into:
                EditText etName = new EditText(this);
                new AlertDialog.Builder(this)
                        .setView(etName)
                        .setTitle("输入新的昵称")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                name = etName.getText().toString();
                                tvName.setText(name);
                                Map<String,String> map = new HashMap<>();
                                map.put("nickname", name);
                                presenter.upDate(map);
                            }
                        }).show();
                break;
            case R.id.img_sex_into:
                new AlertDialog.Builder(this)
                        .setTitle("选择性别")
                        .setNegativeButton("男", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sex = "男";
                                tvSex.setText(sex);
                                Map<String,String> map = new HashMap<>();
                                map.put("sex", 0+"");
                                presenter.upDate(map);
                            }
                        })
                        .setPositiveButton("女", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sex = "女";
                                tvSex.setText(sex);
                                Map<String,String> map = new HashMap<>();
                                map.put("sex", 1+"");
                                presenter.upDate(map);
                            }
                        }).show();
                break;
            case R.id.tv_phone:
                EditText etPhone = new EditText(this);
                new AlertDialog.Builder(this)
                        .setView(etPhone)
                        .setTitle("输入手机号")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                phone = etPhone.getText().toString();
                                tvPhone.setText(phone);
                                Map<String,String> map = new HashMap<>();
                                map.put("phone",phone);
                                presenter.upDate(map);
                            }
                        }).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                // onResult Callback
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                if(selectList.size() == 0) return;
                //获取本地图片的选择地址，上传到服务器
                //头像的压缩和二次采样
                Uri inputUri = Uri.fromFile(new File(selectList.get(0).getPath()));
                Uri outUri = Uri.fromFile(new File(getCacheDir(),"crop_"+selectList.get(0).getFileName()));
                Crop.of(inputUri, outUri).asSquare().start(this);
                break;
            case Crop.REQUEST_CROP:
                if(resultCode == RESULT_OK){
                    //获取剪切以后的图片
                    Uri uri = (Uri) data.getExtras().get("output");
                    try {
                        uploadImage(uri.toString());
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    imgHead.setImageURI(uri);
                }
            default:
                break;
        }
    }
    /**
     * 缺少图片上传的功能
     * @param path
     */
    private void uploadImage(String path) throws URISyntaxException {

        String img_format = "image/jpg";
        String key = "1909";
        //sd卡图片文件
        File file = new File(new URI(path));
        if(file.exists()){
            //创建一个RequestBody 封装文件格式以及文件内容
            RequestBody requestFile = MultipartBody.create(MediaType.parse(img_format),file);
            //创建一个MultipartBody.Part 封装的文件数据（文件流） file参数是给后台接口读取文件用，file.getName() 保存到后台的文件名字
            MultipartBody.Part part = MultipartBody.Part.createFormData("file",file.getName(),requestFile);
            //设置对应的key application/json; charset=utf-8
            RequestBody key_file = RequestBody.create(MediaType.parse("multipart/form-data"),key);
            //通过requestbody传值到后台接口
            //RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),key);
            //创建retrofit
            UpLoadApi uploadApi = HttpUtil.getInstance().getUpLoadApi();
            retrofit2.Call<ResponseBody> call = uploadApi.uploadFile(key_file,part);
            call.enqueue(new retrofit2.Callback<ResponseBody>() {
                @Override
                public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                    try {
                        String result = response.body().string();
                        if(!TextUtils.isEmpty(result)){
                            JSONObject json = new JSONObject(result);
                            int code = json.getInt("code");
                            if(code == 200){
                                JSONObject dataJson = new JSONObject(json.getString("data"));
                                url = dataJson.getString("url");
                                Map<String,String> map = new HashMap<>();
                                map.put("avater", url);
                                if (dataBean != null){
                                    String token = dataBean.getToken();
                                }
                                //更新服务器上的头像
                                presenter.upDate(map);
                            }
                        }
                        Log.i("onResponse",response.body().string());
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                        Log.i("e","解析上传结果json失败");
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                    Log.i("onFailure",t.getMessage());
                }
            });
        }else{
            Toast.makeText(this,"找不到本地文件",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void upDateReturn(UserUpdateBean userUpdateBean) {
        if (userUpdateBean.getErr() == 200){
            if (userLoginBean != null && login != null){
                if (userUpdateBean.getData().getType() == 1){
                    if (url != null) {
                        dataBean.setAvater(url);
                        RequestOptions options = RequestOptions.bitmapTransform(new CircleCrop());
                        Glide.with(this).load(url).apply(options).into(imgHead);
                    }
                }
                if (userUpdateBean.getData().getType() == 8){
                    if (location != null){
                        dataBean.setAdress(location);
                    }
                }
                if (userUpdateBean.getData().getType() == 4){
                    if (sex != null){
                        if (sex.equals("男")){
                            dataBean.setSex(0);
                        }else {
                            dataBean.setSex(1);
                        }
                    }
                }
                if (userUpdateBean.getData().getType() == 7){
                    if (birth != null){
                        dataBean.setBirthday(String.valueOf(DateUtil.getStringToDate(birth,"yyyy-MM-dd")));
                    }
                }
                if (userUpdateBean.getData().getType() == 2) {
                    if (phone != null) {
                        dataBean.setPhone(phone);
                    }
                }
                if (userUpdateBean.getData().getType() == 3){
                    if (name != null){
                        dataBean.setNickname(name);
                    }
                }
            }
            String s = new Gson().toJson(userLoginBean);
            login.edit().putString("data",s).commit();
        }
        Log.i("lllllllllllqqqqqqqqqq", "upDateReturn: "+userUpdateBean.getErr());
    }

    /**
     * 日期选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    public static void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                birth = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                tv.setText(birth);
                String time = String.valueOf(DateUtil.getStringToDate(birth,"yyyy-MM-dd"));
                Map<String,String> map = new HashMap<>();
                map.put("birthday", time);
                ((EditPerInfoActivity)activity).presenter.upDate(map);
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        tvBirth.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };


    private void showPickerView() {// 弹出选择器（省市区三级联动）
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                location = options1Items.get(options1) + "  "
                        + options2Items.get(options1).get(options2) + "  "
                        + options3Items.get(options1).get(options2).get(options3);
                tvLocation.setText(location);
                Map<String,String> map = new HashMap<>();
                map.put("adress", location);
                presenter.upDate(map);
            }
        }).setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();
        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private ArrayList<String> options1Items = new ArrayList<>(); //省
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();//市
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();//区
    private void initJsonData() {//解析数据 （省市区三级联动）
        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
//        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            options1Items.add(jsonBean.get(i).getName());
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三级）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市
                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {
                    City_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }
    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

}