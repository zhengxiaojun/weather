package common.Interface;

import java.net.HttpURLConnection;
import java.net.URL;
public class URLConnection {    
    public static HttpURLConnection getConnection(String url){
        HttpURLConnection connection = null;
        try {
            // �򿪺�URL֮�������
            URL postUrl = new URL(url);
            connection = (HttpURLConnection) postUrl.openConnection();
             // ����ͨ�õ���������
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Accept-Charset", "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return connection;
    }
}
