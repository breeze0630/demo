package com.example.esdemo2.conf;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {

    @Value("${elasticsearch.host:localhost}")
    public String host;

    @Value("${elasticsearch.port:9200}")
    public int port;
    @Value("${elasticsearch.scheme:http}")
    public String scheme;

    @Value("${elasticsearch.username:admin}")
    public String username;


    @Bean("remoteHighLevelClient")
    public RestHighLevelClient restHighLevelClient(){
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider() ;
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, scheme)).
                setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                        .setDefaultCredentialsProvider(credentialsProvider));
        return new RestHighLevelClient(builder);

    }
}
