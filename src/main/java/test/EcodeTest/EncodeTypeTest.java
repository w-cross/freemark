package test.EcodeTest; /**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: test.EcodeTest.EncodeTypeTest, v0.1 2018年03月27日 9:47 吴中稳(WuZhongWen) Exp $
 */
public class EncodeTypeTest {
    public static void main(String[] args) {
        try {
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream(
                    "D:/ideawork/Test/target/classes/spring-config.xml"));
//            System.out.println(ClassLoader.getSystemResource("spring-config.xml"));
            ClassPathResource classPathResource = new ClassPathResource("spring-config.xml");
            BufferedInputStream bin = new BufferedInputStream(classPathResource.getInputStream());
            int p = (bin.read() << 8) + bin.read();
            String code = null;
            //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                case 0x5c75:
                    code = "ANSI|ASCII" ;
                    break ;
                default:
                    code = "GBK";
            }
            System.out.println(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
