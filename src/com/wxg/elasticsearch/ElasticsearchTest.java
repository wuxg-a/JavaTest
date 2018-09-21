package com.wxg.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;

import static com.wxg.elasticsearch.Constants.*;

/**
 * Created by wuxg-a on 2018/9/20.
 */
public class ElasticsearchTest {

    public static Client client = ClientUtils.getClient();

    public static void main(String[] args) {
            Book book = new Book();
            book.setNum(String.valueOf(25));
            book.setAuthor("广联达科技股份有限公司");
            book.setName("years of agitation");
            index(book);
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
