package com.brokurly.service.oauth;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KaKaoService {

    public String getReturnAccessToken(String code){

        String access_token = "";
        String refresh_token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        try{

            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            // HttpURLConnection 설정 값 셋팅
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // buffer 스트림 객체 값 셋팅 후 요청
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code")
                    .append("&client_id=f39a2fb5e58b5dd7a5dce238991677e8")
                    .append("&redirect_uri=http://localhost:80/kakao_callback") // 앱 callback 경로
                    .append("&code="+code);
            bw.write(sb.toString());
            bw.flush();

            // return 값 result 변수에 저장
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String br_line = "";
            String result = "";

            while((br_line = br.readLine()) != null){
                result += br_line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            // 토큰 값 저장 및 리턴
            access_token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();

            br.close();
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return access_token;

    }

    public Map<String, Object> getUserInfo(String access_token){
        Map<String,Object> resultMap = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";

        try{
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            log.info("url = {}",url);

            conn.setRequestProperty("Authorization", "Bearer " + access_token);
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            int responseCode = conn.getResponseCode();
            log.info("responseCode = {}", responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String br_line = "";
            String result = "";

            while((br_line = br.readLine()) != null){
                result += br_line;
            }

            log.info("response = {} ", result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            log.warn("element::"+element);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String id = element.getAsJsonObject().get("id").getAsString();
            String name = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();

            resultMap.put("name", name);
            resultMap.put("id",id);
            resultMap.put("email",email);

        }catch (IOException e){
            e.printStackTrace();
        }

        return resultMap;
    }


}