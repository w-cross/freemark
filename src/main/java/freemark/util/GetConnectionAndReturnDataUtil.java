/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */
package freemark.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import freemark.model.MetaDataModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: GetConnectionAndReturnDataUtil, v0.1 2018年03月29日 12:33 吴中稳(WuZhongWen) Exp $
 */
public class GetConnectionAndReturnDataUtil {
    public static DruidPooledConnection getConnection() {
        //建立与数据库的连接
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ttms?characterEncoding=utf-8");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        try {
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> getTableData(String tableName, String dataBaseName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String, Object> map = new HashMap();
        try {
            DruidPooledConnection druidPooledConnection = getConnection();
            ps = druidPooledConnection.prepareStatement("SELECT TABLE_NAME,COLUMN_NAME,COLUMN_KEY,DATA_TYPE,COLUMN_TYPE,COLUMN_COMMENT "
                    + "FROM information_schema. COLUMNS WHERE table_schema = ?  AND table_name = ?");
            ps.setString(1, dataBaseName);
            ps.setString(2, tableName);
            rs = ps.executeQuery();
            List<MetaDataModel> list = new ArrayList<MetaDataModel>();
            while (rs.next()) {
                MetaDataModel metaDataModel = new MetaDataModel();
                String s = rs.getString("COLUMN_NAME");
                //向表字段对象内塞值
                metaDataModel.setColumnName(handleTuoFeng(s, "lower").get("data"));
                metaDataModel.setColumnComment(rs.getString("COLUMN_COMMENT"));
                metaDataModel.setDataType(rs.getString("DATA_TYPE"));
                metaDataModel.setSetAndGetName(handleTuoFeng(s, "up").get("data"));
                list.add(metaDataModel);
            }
            map.put("tableData", list);
            map.put("voName", handleTuoFeng(tableName, "up").get("data"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, String> handleTuoFeng(String data, String type) {
        String[] dataArray = data.split("_");
        Map<String, String> map = new HashMap<String, String>();
        String name = "";
        if (dataArray.length > 1) {
            for (int i = 1; i < dataArray.length; i++) {
                String s = new StringBuilder(dataArray[i]).replace(0, 1, dataArray[i].substring(0, 1).toUpperCase()).toString();
                name += s;
            }
        }
        if (!"up".equals(type)) {
            name = dataArray[0] + name;
        } else {
            name = new StringBuilder(dataArray[0]).
                    replace(0, 1, data.substring(0, 1).toUpperCase()).toString() + name;
        }
        map.put("data", name);
        return map;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map = handleTuoFeng("wu", "up");
    }

}
