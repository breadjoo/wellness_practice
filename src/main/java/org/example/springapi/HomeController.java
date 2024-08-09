package org.example.springapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class HomeController {

    @GetMapping("/api") // http://localhost:8080/api 로 갔을 때 아래의 데이터를 보여주게 함
    public String callApi() {
        StringBuilder result = new StringBuilder();
        String urlStr = "https://api.odcloud.kr/api/15068730/v1/uddi:12fe14fb-c8ca-47b1-9e53-97a93cb214ed?" + // api endpoint
                "page=1&perPage=20"+
                "&serviceKey=X%2BK%2FqJic5IGtMIij8SqaqTXrqno%2Blr%2FnYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA%3D%3D"; // 서비스 키

        HttpURLConnection conn = null;
        BufferedReader br = null;

        try {
            URL url = new URL(urlStr); //url 넣고
            conn = (HttpURLConnection) url.openConnection(); //연결하고
            conn.setRequestMethod("GET"); //get방식으로다가

            // 응답 코드 확인
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); // 데이터 읽기도구
                String returnLine;
                while ((returnLine = br.readLine()) != null) { //반복문으로 데이터 읽어서 넣기
                    result.append(returnLine).append("\n");
                }
                //여기부턴 오류처리, 종료
            } else {
                result.append("Failed to fetch data. HTTP Response Code: ").append(responseCode);
            }

        } catch (IOException e) {
            result.append("Error occurred: ").append(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                result.append("Error closing BufferedReader: ").append(e.getMessage());
            }
            if (conn != null) {
                conn.disconnect();
            }
        }

        return result.toString();
    }
}



//
//
//@RestController
//public class HomeController {
//
//    @GetMapping("/api")
//    public String callApi() throws IOException {
//        StringBuilder result = new StringBuilder();
//        String urlStr = "https://api.odcloud.kr/api/15068730/v1/uddi:12fe14fb-c8ca-47b1-9e53-97a93cb214ed?" +
//                "page=1&perPage=10&serviceKey=X%2BK%2FqJic5IGtMIij8SqaqTXrqno%2Blr%2FnYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA%3D%3D";
////                "?serviceKey=X+K/qJic5IGtMIij8SqaqTXrqno+lr/nYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA=="+
////                "&numOfRows=10"+
////                "type=json";
//        URL url = new URL(urlStr);
//
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//
//        BufferedReader br;
//        br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
//
//        String returnLine;
//        while ((returnLine = br.readLine()) != null) {
//            result.append(returnLine+"\n");
//        }
//        conn.disconnect();
//
//        return result.toString();
//    }
//
//}