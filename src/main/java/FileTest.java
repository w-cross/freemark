/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */

import test.mailtest.MailTest;

import java.io.*;

/**
 * @author
 * @version $Id: FileTest, v0.1 2018年04月13日 18:58  Exp $
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("classpath:txt");
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(1);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println(bufferedReader.readLine());
            file.delete();
//            PrintWriter printWriter = new PrintWriter(file);
//            printWriter.write(1);
            MailTest mailTest = new MailTest();
            mailTest.sendAttachmentMail(file);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
