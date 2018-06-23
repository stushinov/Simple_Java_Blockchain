package org.blockchain.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RequestBuilderImpl implements RequestBuilder {

    private HttpClient httpClient;

    public RequestBuilderImpl(){
        this.httpClient = HttpClientBuilder.create().build();
    }

    @Override
    public String doPost(String url, String jsonObj){
        HttpPost request = new HttpPost(url);

        StringEntity params = null;
        try {
            params = new StringEntity(jsonObj);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(params);

        HttpResponse response = callRequest(request);
        String jsonEntity = this.extractJsonStringFromResponse(response);
        return jsonEntity;
    }

    @Override
    public String doGet(String url){
        HttpGet request = new HttpGet(url);

        HttpResponse response = callRequest(request);

        String jsonEntity = this.extractJsonStringFromResponse(response);
        return jsonEntity;
    }

    private HttpResponse callRequest(HttpRequestBase request) {
        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            System.out.println("Failed to get a response from: " + request.getURI().toString());
            System.out.println("Encountered protocol or connection problem!");
        }
        return response;
    }

    private String extractJsonStringFromResponse(HttpResponse response){
        HttpEntity respEntity = response.getEntity();
        String retSrc = null;
        try {
            retSrc =  EntityUtils.toString(respEntity);
        } catch (IOException e) {
            System.out.println("Entity not extracted from response. Response might be null!");
        }

        return retSrc;
    }
}
