/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */

import netty.io.IoTest;

import java.io.UnsupportedEncodingException;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: PathTest, v0.1 2018年03月28日 14:14 吴中稳(WuZhongWen) Exp $
 */
public class PathTest {

    public static void main(String[] args) {
        try {
            String path = java.net.URLDecoder.decode(PathTest.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
            System.out.println(path);
            System.out.println(PathTest.class.getClassLoader().getResource("").getPath());
            IoTest ioTest = new IoTest();
            System.out.println(ioTest.getClass().getClassLoader().getResource("")
            .getPath());
            System.out.println(ioTest.getClass().getResource(""));
            System.out.println(ioTest.getClass().getResource("/"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
