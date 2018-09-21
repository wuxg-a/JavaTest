package com.wxg.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import static com.wxg.elasticsearch.Constants.*;
import retrofit2.http.POST;

/**
 * Created by wuxg-a on 2018/9/20.
 */
public class ClientUtils {
    private static InetSocketTransportAddress addresses = new InetSocketTransportAddress(HOST, PORT);

    public static Client getClient(){
        ImmutableSettings.Builder settingsBuilder = ImmutableSettings.settingsBuilder();
        //settingsBuilder.put("client.transport.sniff", true);
        settingsBuilder.put("cluster.name", Constants.CLUSTER_NAME);
        Settings settings = settingsBuilder.build();
        return new TransportClient(settings).addTransportAddresses(addresses);
    }
}
