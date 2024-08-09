//package org.example.springapi;
//
//import org.json.JSONObject;
//import org.json.XML;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class OpenApiExplorer {
//
//    public JSONObject getSport() throws IOException {
//        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15068730/v1/uddi:12fe14fb-c8ca-47b1-9e53-97a93cb214ed?"+
//                "page=1&perPage=20" +
//                "&serviceKey=X%2BK%2FqJic5IGtMIij8SqaqTXrqno%2Blr%2FnYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA%3D%3D");
//        URL url = new URL(urlBuilder.toString());
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        StringBuilder xmlSb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            xmlSb.append(line);
//        }
//        rd.close();
//        conn.disconnect();
//        JSONObject jsonSb = XML.toJSONObject(xmlSb.toString());
////        JSONObject jsonSb = xmlSb.toString();
//        return jsonSb;
//
//    }
//}
