/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package freemark;


import freemark.util.GetConnectionAndReturnDataUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: FreeMarkTest, v0.1 2018年03月28日 15:31 吴中稳(WuZhongWen) Exp $
 */
public class FreeMarkTest {
    public static void main(String[] args) {
        String tableName = "test";        //表名
        String dataBaseName = "test";    //数据库的名字
        String tableComment = "test表";  //对表的注释
        String packageName = "query";    //包名
        String author = "吴中稳";
        Map<String, Object> map = GetConnectionAndReturnDataUtil.getTableData(tableName, dataBaseName);
        map.put("packageName", packageName);
        map.put("author",author);
        map.put("tableComment",tableComment);
        Configuration configuration = new Configuration();
        String path = FreeMarkTest.class.getResource("/").getPath().replace("target/classes", "src/main/java");
        //模板的位置
        String templeLocation = path + "temple/";
        try {
            //指定模板存放的路径
            configuration.setDirectoryForTemplateLoading(new File(templeLocation));
            Template template = configuration.getTemplate("javaVO.ftl");
            //生成文件的存放路径
            String outPath = path +"com/freemark/" + packageName ;
            File file = new File(outPath);
            // 判断目标文件所在的目录是否存在
            if (!file.getParentFile().exists()) {
                // 如果目标文件所在的文件夹不存在，则创建父文件夹
                if (!file.getParentFile().mkdirs()) {// 判断创建目录是否成功
                    System.out.println("创建目标文件所在的目录失败！");
                }
            }
            if (!file.exists() && !file.isDirectory()) {
                file.mkdir();
            }
            String name = GetConnectionAndReturnDataUtil.handleTuoFeng(tableName + "VO","up").get("data") + ".java";
            Writer tempWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file + "/"+ name )));
            try {
                template.process(map, tempWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            tempWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
