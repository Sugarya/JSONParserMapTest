package com.sugary.jsonparsermaptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.reflect.TypeToken;
import com.sugary.jsonparsermaptest.entity.CategoryEntity;
import com.sugary.jsonparsermaptest.utils.LOG;
import com.sugary.jsonparsermaptest.utils.json.FastJsonUtil;
import com.sugary.jsonparsermaptest.utils.json.GsonUtil;
import com.sugary.jsonparsermaptest.utils.json.JacksonUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onParseClick(View view) {
        fastJsonTest();
    }

    /**
     * jackson解析Map
     */
    private void jackJsonTest(){
        LinkedHashMap<CategoryEntity, List<CategoryEntity>> linkedHashMap = createMap();
        String json = JacksonUtil.getInstance().toJson(linkedHashMap);
        LOG.D(TAG, "jackJson = " + json);

        LinkedHashMap<CategoryEntity, List<CategoryEntity>> parseMap = JacksonUtil.getInstance().fromJson(
                json,
                new com.fasterxml.jackson.core.type.TypeReference<LinkedHashMap<CategoryEntity,List<CategoryEntity>>>() {});
        LOG.D(TAG, "parse map = " + parseMap.toString());
        List<CategoryEntity> categoryEntityList = parseMap.get(new CategoryEntity("121", "厨房用品", false));
        LOG.D(TAG, "jackson list = " + categoryEntityList.toString());
    }

    /**
     * fastjson解析Map
     */
    private void fastJsonTest() {
        LinkedHashMap<CategoryEntity, List<CategoryEntity>> linkedHashMap = createMap();
        String s = FastJsonUtil.getInstance().toJson(linkedHashMap);
        LOG.D(TAG, "fastJson = " + s);

        LinkedHashMap<CategoryEntity, List<CategoryEntity>> parseHashMap =
                FastJsonUtil.getInstance().fromJson(
                        s,
                        new TypeReference<LinkedHashMap<CategoryEntity, List<CategoryEntity>>>() {
                        }.getType());

        LOG.D(TAG, "fastJson json2 = " + parseHashMap.toString());
    }

    /**
     * Gson解析Map
     */
    private void gsonMapTest() {
        LinkedHashMap<CategoryEntity, List<CategoryEntity>> linkedHashMap = createMap();
        String toJson = GsonUtil.getInstance().toJson(linkedHashMap);
        LOG.D(TAG, "toJson = " + toJson);

        LinkedHashMap<CategoryEntity, List<CategoryEntity>> parserMap =
                GsonUtil.getInstance().fromJson(
                        toJson,
                        new TypeToken<LinkedHashMap<CategoryEntity, List<CategoryEntity>>>() {
                        }.getType());
        LOG.D(TAG, "fromJson = " + parserMap.toString());
        List<CategoryEntity> parseCategoryList = parserMap.get(new CategoryEntity("121", "厨房用品", false));
        LOG.D(TAG, "parseCategoryList = " + parseCategoryList.toString());
    }

    /**
     * 生成Map数据
     *
     * @return
     */
    private LinkedHashMap<CategoryEntity, List<CategoryEntity>> createMap() {
        LinkedHashMap<CategoryEntity, List<CategoryEntity>> categoryMap = new LinkedHashMap<>();

        List<CategoryEntity> firstCategoryList = new ArrayList<>();
        firstCategoryList.add(new CategoryEntity("201", "全部分类", true));
        categoryMap.put(new CategoryEntity("101", "全部分类", true), firstCategoryList);

        List<CategoryEntity> secondCategoryList = new ArrayList<>();
        secondCategoryList.add(new CategoryEntity("211", "遥控赛车", false));
        secondCategoryList.add(new CategoryEntity("212", "乐高积木", false));
        secondCategoryList.add(new CategoryEntity("213", "泰迪小熊", false));
        categoryMap.put(new CategoryEntity("111", "儿童玩具", false), secondCategoryList);

        List<CategoryEntity> thirdCategoryList = new ArrayList<>();
        thirdCategoryList.add(new CategoryEntity("221", "电磁炉", false));
        thirdCategoryList.add(new CategoryEntity("222", "电饭煲", false));
        categoryMap.put(new CategoryEntity("121", "厨房用品", false), thirdCategoryList);

        List<CategoryEntity> fourthCategoryList = new ArrayList<>();
        fourthCategoryList.add(new CategoryEntity("231", "Java8函数式编程", false));
        fourthCategoryList.add(new CategoryEntity("232", "美的历程", false));
        fourthCategoryList.add(new CategoryEntity("232", "黑客与画家", false));
        fourthCategoryList.add(new CategoryEntity("232", "代码的未来", false));
        categoryMap.put(new CategoryEntity("131", "自营书籍", false), fourthCategoryList);

        return categoryMap;
    }


    private CategoryEntity createCategoryEntity(){
        return new CategoryEntity("000", "测试分类", false);
    }
}
