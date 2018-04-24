import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailUtils {


    private static final int ALIDM_SMTP_PORT = 25;
    private static final String ALIDM_SMTP_HOST = "smtp.51nbapi.com";
    private static String SEND_MAIL_ADDRESS = "";
    private static String SEND_MAIL_PASSWORD = "";

    /**
     * 发送邮件
     *
     * @return boolean
     * @author 陈旭
     * @version 1.0
     * @date 2017/10/16
     */
    public static boolean send(String subject, String text, String receiveAddress) {

        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);

        // 发件人的账号
        props.put("mail.user", SEND_MAIL_ADDRESS);
        // 访问SMTP服务时需要提供的密码(邮箱密码)
        props.put("mail.password", SEND_MAIL_PASSWORD);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);

        try {
            // 设置发件人
            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);
            // 设置收件人
            InternetAddress to = new InternetAddress(receiveAddress);
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            // 设置邮件标题
            message.setSubject(subject);
            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            //发送附件


            // 发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功");
//            LoggerUtil.getMailLogger().info("发送邮件成功:" + receiveAddress);
            return true;
        } catch (Exception e) {
            System.out.println("邮件发送失败");
//            LoggerUtil.getMailLogger().error("发送邮件失败:" + receiveAddress, e);
            return false;
        }
    }


    public static void main(String[] args) throws MessagingException {
//        sendMail("测试邮件", "测试邮件111", "monitor_datacenter");

//        String a = "45274627@qq.com";
//
//        String[] arr = a.split(",");
//
//        System.out.println(JSONObject.toJSONString(arr));

//        System.out.println(JSONObject.toJSONString(getMailConfig("monitor_heartbeat"))) ;

        MailUtils.send("wode","你好","wuzhongwen@51nbapi.com");
    }


}
