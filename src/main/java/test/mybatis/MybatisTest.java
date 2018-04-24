
package test.mybatis;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.StringTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.omg.CORBA.OBJ_ADAPTER;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MybatisTest {
    public static void main(String[] args) {

        InputStream inputStream;
        try {
            inputStream = new FileInputStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("");
            DOMParser domParser = new DOMParser();
            Plugin plugin = null;
            Configuration configuration = new Configuration();
            MappedStatement mappedStatement;
            MapperProxy mapperProxy ;
            MapperProxyFactory mapperProxyFactory;
            TypeHandler typeHandler = new StringTypeHandler();
            try {
                domParser.parse(new InputSource());
                Document document = domParser.getDocument();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
    }
    }


}
