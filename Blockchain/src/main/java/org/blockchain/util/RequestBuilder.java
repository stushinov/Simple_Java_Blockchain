package org.blockchain.util;

public interface RequestBuilder {

   String doPost(String url, String jsonObj);
   String doGet(String url);
}
