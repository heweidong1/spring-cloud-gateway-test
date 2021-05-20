
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;


public class HttpUtil {

    volatile List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }


//

    public static   ResponseEntity  exchangeCookie(RestTemplate restTemplate,HttpMethod httpMethod,String url,List<String> cookies,Class returnType){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("Cookie",cookies);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        return  restTemplate.exchange(url, httpMethod, httpEntity, returnType);
    }

    public static String getQueryUrl(String url,Map<String,String> query){
        StringBuilder queryUrl = new StringBuilder(url);
        queryUrl.append("");
        for (Map.Entry<String, String> entry : query.entrySet()) {
            if (queryUrl.indexOf("?")==-1){
                queryUrl.append("?");
            }
            queryUrl.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        if (queryUrl.indexOf("&")!=-1) {
            queryUrl.replace(queryUrl.lastIndexOf("&"),queryUrl.length(),"");
        }
        return queryUrl.toString();
    }

    public static void main(String[] args)    {

        RestTemplate restTemplate =new RestTemplate();
        String url  = "http://localhost:8000/getUser";
        Map<String,String> query = new HashMap<>();
        List<String> cookies  = new ArrayList<>();
        query.put("name","1");
        query.put("age","1");
        cookies.add("login=user-1");
        System.out.println(exchangeCookie(restTemplate, HttpMethod.GET, getQueryUrl(url, query), cookies, String.class).getBody());
    }

}