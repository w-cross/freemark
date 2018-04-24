//package test;
//
//import com.jade.comm.utils.StrUtils;
//import com.jade.spider.comm.HttpUtils;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.message.BasicHeader;
//import org.apache.http.util.EntityUtils;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.poi.hssf.usermodel.*;
//
///**
// * @author 欧阳杰
// * @version $Id: GanJiGrab
// * @company 杭州信牛网络科技有限公司
// * @Date: 2018/4/11 18:09
// *
// * 赶集网贷款电话爬取
// */
//
//public class GanJiGrab {
//
////    private static int line = 1;
//    private static int column = 0;
//
//    public void ganji() throws IOException {
//        //创建一个workbook对应一个excel文件
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("赶集网贷款电话");
//        HSSFRow row = sheet.createRow(0);
//        HSSFCell cell;
//        for (CityName cityName : CityName.values()) {
//            String city = cityName.toString();
//            //创建单元格，设置表头
//            cell = row.createCell(column);
//            cell.setCellValue(new HSSFRichTextString(city));
//            int line = 1;
//            for (int i = 1; i <= 2; i++){
//                String  page = (i > 9) ? ("" + i) : ( "o" +i);
//                try {
//                    String getUrl = "http://"+city+".ganji.com/daikuan/"+page+"/";
//                    HttpGet httpGet = new HttpGet(getUrl);
//                    httpGet.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36"));
//                    httpGet.setHeader(new BasicHeader("Referer","http://jilin.ganji.com/"));
//                    CloseableHttpClient httpClient = HttpUtils.CreatHttpClient();
//                    CloseableHttpResponse httpResp = httpClient.execute(httpGet);
//                    int statusCode = httpResp.getStatusLine().getStatusCode();
//                    String contentStr = StrUtils.trim(EntityUtils.toString(httpResp.getEntity(), "UTF-8"));
//                    if (statusCode != 200 || StrUtils.isEmpty(contentStr)){
//                        return;
//                    }
//                    HttpUtils.close(httpResp);
//                    HttpUtils.close(httpClient);
//                    //抓取电话号码
//                    phoneList(contentStr,sheet,row,line);
//                }catch (Exception e){
//                    System.out.println("发送请求出现异常！" + e);
//                    e.printStackTrace();
//                }
//            }
//            //列的改变
//            column++;
//        }
//        FileOutputStream fos = new FileOutputStream("E:\\phone.xls");
//        workbook.write(fos);
//        System.out.println("写入成功");
//        fos.close();
//    }
//
//
//    private static void phoneList(String contentStr, HSSFSheet sheet, HSSFRow row, int line) throws IOException {
//        contentStr = StrUtils.clearDoubleBlank(contentStr).replaceAll("<a","\n<a");
//        Pattern p = Pattern.compile("<a[^/]*?href=\"(?<url>[^\"]*?)\"[^>]*?\">");
//        Matcher m = p.matcher(contentStr);
//        String oldUrl = "";
//        while (m.find()){
//            String url = m.group("url");
//            if (oldUrl.equals(url)){
//                continue;
//            }
//            if (url.contains("wuba_info") || url.contains("fuwu_dian")){
//                oldUrl = url;
//                if (!url.contains("//jilin.ganji.com")){
//                    url = "http://jilin.ganji.com"+url;
//                }else {
//                    url = "http:"+url;
//                }
//                HttpGet httpGet = new HttpGet(url);
//                httpGet.setHeader(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36"));
//                httpGet.setHeader(new BasicHeader("Referer","http://jilin.ganji.com/daikuan/"));
//                CloseableHttpClient httpClient = HttpUtils.CreatHttpClient();
//                CloseableHttpResponse httpResp = httpClient.execute(httpGet);
//                int statusCode = httpResp.getStatusLine().getStatusCode();
//                contentStr = StrUtils.trim(EntityUtils.toString(httpResp.getEntity(), "UTF-8"));
//                if (statusCode != 200 || StrUtils.isEmpty(contentStr)){
//                    return;
//                }
//                contentStr = StrUtils.clearDoubleBlank(contentStr);
//                String phone = StrUtils.trim(StrUtils.regFind(contentStr,"\"phone_number\":\"[^\"]*?\",\"all_phone_number\":\"(?<phone>[^\"]*?)\"","phone"));
//                if (!StrUtils.isEmpty(phone)){
//                    row = sheet.getRow(line);
//                    if(row == null){
//                        row = sheet.createRow(line);
//                    }
//                    row.createCell(column).setCellValue(phone);
//                }
//                line ++;
//            }
//
//        }
//    }
//}
