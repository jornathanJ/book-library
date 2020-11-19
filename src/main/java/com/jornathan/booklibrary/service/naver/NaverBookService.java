package com.jornathan.booklibrary.service.naver;


// 네이버 검색 API 예제 - blog 검색
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornathan.booklibrary.model.hibernate.NvBookInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Naver 에서 제공하는 OpenAPI 를 호출하는 데 사용합니다.
 */
@Service
public class NaverBookService {

    private static final Logger logger = LoggerFactory.getLogger(NaverBookService.class);

    public static final String clientId = "ckVne5boPXRuKVgan28B"; //애플리케이션 클라이언트 아이디값"

    public static final String clientSecret = "fD4f7i8Kq_"; //애플리케이션 클라이언트 시크릿값"

    @Autowired
    private ObjectMapper objectMapper;

    public NvBookInfo GetBookInfo(String paramName, String paramValue) {
        String text = null;

        try {
            text = URLEncoder.encode(paramValue, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //throw new RuntimeException("검색어 인코딩 실패",e);
            logger.error("검색어 인코딩 실패", e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/book_adv?" + paramName + "=" + text;    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);

        NvBookInfo nvBookInfo = null;
        try {
            nvBookInfo = objectMapper.readValue(responseBody, NvBookInfo.class);
        } catch (JsonProcessingException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
        }
        return nvBookInfo;
    }

    private String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
            //logger.error("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
            //logger.error("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
            //logger.error("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
            //logger.error("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}