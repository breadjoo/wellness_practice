//package org.example.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//@RestController
//public class RestTestController {
//
//    @GetMapping("/apitest")
//    public String callApiWithXml() {
//        StringBuffer result = new StringBuffer();
//        try {
//            String apiUrl = "https://api.odcloud.kr/api/15068730/v1/uddi:12fe14fb-c8ca-47b1-9e53-97a93cb214ed?page=1&perPage=10&serviceKey=X%2BK%2FqJic5IGtMIij8SqaqTXrqno%2Blr%2FnYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA%3D%3D";
//            URL url = new URL(apiUrl);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("GET");
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
//
//            String returnLine;
//            result.append("<xmp>");
//            while((returnLine = bufferedReader.readLine()) != null) {
//                result.append(returnLine + "\n");
//            }
//            urlConnection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result + "</xmp>";
//    }
//}
//
