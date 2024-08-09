package org.example.springapi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RealController {

    @Autowired
    private SportsInfoRepository infoRepository;

    @GetMapping("/api2")
    public String index() {
        return "index";
    }

    @PostMapping("/api2")
    public String load_save(@RequestParam("date") String date, Model model) {


        String result = "";

        String urlStr = "https://api.odcloud.kr/api/15068730/v1/uddi:12fe14fb-c8ca-47b1-9e53-97a93cb214ed?" +
                "page=1&perPage=260" +
                "&serviceKey=X%2BK%2FqJic5IGtMIij8SqaqTXrqno%2Blr%2FnYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA%3D%3D";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            bf.close();

            result = sb.toString();

            // JSONObject 파싱
            JSONObject jsonObject = new JSONObject(result);
            Long currentCount = jsonObject.getLong("currentCount");
            JSONArray dataArray = jsonObject.getJSONArray("data");

//            Long totalCount = jsonObject.getLong("currentCount");

//            JSONObject subResult = CardSubwayStatsNew.getJSONObject("RESULT");
//            JSONArray infoArr = CardSubwayStatsNew.getJSONArray("row");
//            JSONArray infoArr = jsonObject.getJSONArray("row");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject tmp = dataArray.getJSONObject(i);
                SportsInfo infoObj = new SportsInfo(
                        i + 1L,
                        tmp.getDouble("MET 계수"),
                        tmp.getString("운동명")
                );

                infoRepository.save(infoObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/findname";
    }
}


//package org.example.springapi;
//
//import org.apache.tomcat.util.json.JSONParser;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//
//@Controller
//public class RealController{
//
//    @Autowired
//    private SportsInfoRepository infoRepository;
//
//    @GetMapping("/api2")
//    public String index(){
//        return "index";
//    }
//
//    @PostMapping("/api2")
//    public String load_save(@RequestParam("date") String date, Model model){
//        String result = "";
//
//        String urlStr = "https://api.odcloud.kr/api/15068730/v1/uddi:12fe14fb-c8ca-47b1-9e53-97a93cb214ed?" + // api endpoint
//                "page=1&perPage=20"+
//                "&serviceKey=X%2BK%2FqJic5IGtMIij8SqaqTXrqno%2Blr%2FnYPhHzoJlGTbVDhXZKUj8nzkAcVxnnMXCXiaf0Od7VOfOnMfZoPAqkA%3D%3D"; // 서비스 키
//        try {
//            String requestDate=date;
//            URL url = new URL(urlStr);
//            BufferedReader bf;
//            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//            result = bf.readLine();
//
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
//            JSONObject CardSubwayStatsNew = (JSONObject)jsonObject.get("CardSubwayStatsNew");
//            Long totalCount=(Long)CardSubwayStatsNew.get("list_total_count");
//
//            JSONObject subResult = (JSONObject)CardSubwayStatsNew.get("RESULT");
//            JSONArray infoArr = (JSONArray) CardSubwayStatsNew.get("row");
//
//            for(int i=0;i<infoArr.length();i++){
//                JSONObject tmp = (JSONObject)infoArr.get(i);
//                SportsInfo infoObj=new SportsInfo(i+1L,
//                        (String)tmp.get("use_dt"),
//                        (double)tmp.get("met"),
//                        (String)tmp.get("sport"));
//
//
//                infoRepository.save(infoObj);
//            }
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/findname";
//    }
//}