package weather;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import common.Interface.Common;
import common.Interface.HttpRequest;
public class WeatherTest {
    public String httpResult= null, weatherinfo= null, city=null,exp_city = null;
    public static String cityCode="";
    
    @Test(groups = { "BaseCase"})
    public void getShenZhen_Succ() throws IOException{
        exp_city="深圳";
        cityCode="101280601";
        resultCheck(cityCode, exp_city);
    }
    
    @Test(groups = { "BaseCase"})
    public void getBeiJing_Succ() throws IOException{
        exp_city="北京";
        cityCode="101010100";
        resultCheck(cityCode, exp_city);
    }
    
    @Test(groups = { "BaseCase"})
    public void getShangHai_Succ() throws IOException{
        exp_city="上海";
        cityCode="101020100";
        resultCheck(cityCode, exp_city);
    }
    
    public void resultCheck(String cityCode_str, String exp_city_str) throws IOException{
        Reporter.log("【正常用例】:获取"+exp_city_str+"天气成功!");
        httpResult=HttpRequest.sendGet(cityCode_str);
        System.out.println(httpResult);
        Reporter.log("请求地址: "+HttpRequest.geturl());
        Reporter.log("返回结果: "+httpResult);
        weatherinfo=Common.getJsonValue(httpResult, "weatherinfo");
        city=Common.getJsonValue(weatherinfo, "city");
        Reporter.log("用例结果: resultCode=>expected: " + exp_city_str + " ,actual: "+ city);
        Assert.assertEquals(city,exp_city_str);        
    }
}
