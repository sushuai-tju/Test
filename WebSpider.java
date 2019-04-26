package Spider;
/**网络爬虫，获取天津大学精仪学院官网研究生导师姓名、电话、邮箱等信息
 * author:苏帅
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {
    public static String getURLContent(String urlStr){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL( urlStr );
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String temp = "";
                while((temp = reader.readLine()) !=null){
                    sb.append(temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static List<String> getMatcherStr(String destStr,String regexStr){

        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(destStr);
        List<String> result = new ArrayList<String>();
        while (m.find()){
           result.add(m.group());

        }
        return result;
    }
    public static void main(String[] args) {
        String destStr = getURLContent("http://jyxy.tju.edu.cn/html/Teachers.html");
        List<String> result = new ArrayList<String>();
        result = getMatcherStr(destStr,"<p.*</p>");
            for(String a: result){
                System.out.println(a);
            }

    }
}
