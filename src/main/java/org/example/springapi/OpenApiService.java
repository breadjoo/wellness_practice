//package org.example.springapi;
//
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OpenApiService {
//
//    private final OpenApiExplorer openApiExplorer;
//    private final SportsInfoRepository sportsInfoRepository;
//
//
//    public List<SportsInfo> getSportsInfo() throws IOException {
//
//        List<SportsInfo> sportsInfo = new ArrayList<>();
//
//        JSONObject jsonData = openApiExplorer.getSport();
//        JSONObject body = jsonData.getJSONObject("response").getJSONObject("body");
//
//
//
//    }
//
//
//}
