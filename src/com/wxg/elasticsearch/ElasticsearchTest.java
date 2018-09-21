package com.wxg.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.Date;

import static com.wxg.elasticsearch.Constants.*;

/**
 * Created by wuxg-a on 2018/9/20.
 */
public class ElasticsearchTest {

    private static final int PAGE_SIZE = 50000;

    public static Client client = ClientUtils.getClient();

    public static void main(String[] args) {
        //fromAndSize();
        scroll();
    }

    public static void fromAndSize(){
        System.out.println("from size 模式启动！");
        Date begin = new Date();
        long count = client.prepareCount(INDEX_BOOK).setTypes(INDEX_BOX_TYPE_IT).execute().actionGet().getCount();
        SearchRequestBuilder requestBuilder = client.prepareSearch(INDEX_BOOK).setTypes(INDEX_BOX_TYPE_IT).setQuery(QueryBuilders.matchAllQuery());
        for(int i=0,sum=0; sum<count; i++){
            SearchResponse response = requestBuilder.setFrom(i).setSize(PAGE_SIZE).execute().actionGet();
            sum += response.getHits().hits().length;
            System.out.println("总量"+count+" 已经查到"+sum);
        }
        Date end = new Date();
        System.out.println("耗时: "+(end.getTime()-begin.getTime()));

    }

    public static void scroll(){
        System.out.println("scroll 模式启动！");
        Date begin = new Date();
        SearchResponse scrollResponse = client.prepareSearch(INDEX_BOOK).setTypes(INDEX_BOX_TYPE_IT)
                .setSearchType(SearchType.SCAN).setSize(PAGE_SIZE/3).setScroll(TimeValue.timeValueMinutes(1))
                .execute().actionGet();
        long count = scrollResponse.getHits().getTotalHits();//第一次不返回数据
        for(int i=0,sum=0; sum<count; i++){
            scrollResponse = client.prepareSearchScroll(scrollResponse.getScrollId())
                    .setScroll(TimeValue.timeValueMinutes(8))
                    .execute().actionGet();
            sum += scrollResponse.getHits().hits().length;
            System.out.println("总量"+count+" 已经查到"+sum);
        }
        Date end = new Date();
        System.out.println("耗时: "+(end.getTime()-begin.getTime()));
    }


    public static void update(Book book) {
        UpdateRequestBuilder builder = client.prepareUpdate(INDEX_BOOK, INDEX_BOX_TYPE_IT, "1");
        try {
            builder.setDoc(JSONObject.toJSONString(book).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UpdateResponse resp = builder.execute().actionGet();
        System.out.println(resp);
    }

    public static void index(Book book){
        client = ClientUtils.getClient();
        IndexRequestBuilder builder = client.prepareIndex(INDEX_BOOK, INDEX_BOX_TYPE_IT, book.getNum());
        ObjectMapper mapper = new ObjectMapper();

        String source = JSONObject.toJSONString(book);

        builder.setSource(source);
        IndexResponse response = builder.execute().actionGet();
        System.out.println();


    }
}
