package com.xfy.wanandroid.http;

import com.example.baselibrary.utils.MmkvUtils;
import com.xfy.wanandroid.constants.Constants;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * des 请求天假cookie
 * @author xfy
 * @date 2020-03-09
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> cookies = (HashSet<String>) MmkvUtils.INSTANCE.decodeStringSet(Constants.COOKIE);
        if (cookies != null) {
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
            }
        }
        return chain.proceed(builder.build());
    }

}
