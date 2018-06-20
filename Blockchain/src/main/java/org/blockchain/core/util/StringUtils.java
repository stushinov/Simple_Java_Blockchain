package org.blockchain.core.util;

import com.google.gson.Gson;
import org.bouncycastle.crypto.digests.SHA256Digest;

public class StringUtils {

    private static final Gson gson = new Gson();

    private StringUtils(){}

    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    public static byte[] calcSHA256(String text) {
        byte[] bytes = text.getBytes();
        SHA256Digest digest = new SHA256Digest();
        digest.update(bytes, 0, bytes.length);
        byte[] result = new byte[digest.getDigestSize()];
        digest.doFinal(result, 0);
        return result;
    }
}
