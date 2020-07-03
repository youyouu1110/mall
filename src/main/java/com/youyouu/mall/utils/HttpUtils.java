package com.youyouu.mall.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HttpUtils {

    public static String getRequestBody(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while((length = inputStream.read(bytes))!= -1){
            outputStream.write(bytes,0,length);
        }
        //JSON字符串
        return outputStream.toString("utf-8");
    }
}
