//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.hssf.util.HSSFColor;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
///**
// * poi导出Excel工具类
// *
// * @author 吴中稳(WuZhongWen)
// * @version $Id: ExportUtils, v0.1 2018年03月19日 12:57 吴中稳(WuZhongWen) Exp $
// */
//public class ExportUtils {
//
//    /**
//     * 用poi获得excel表
//     *
//     * @param fileName:excel表的名字
//     * @param list:行数据
//     * @param out：输出流
//     * @param data:表头数据
//     */
//    public static void exportExcel(String fileName, List list, OutputStream out, String data) {
//        //声明一个工作簿
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        //生成一个表格
//        //表名防止乱码
//        try {
//            fileName = new String(fileName.getBytes("iso-8859-1"), "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        HSSFSheet sheet = workbook.createSheet(fileName);
//        //设置表格默认列宽度为15个字符
//        sheet.setDefaultColumnWidth(12);
//        //生成一个样式，用来设置标题样式
//        HSSFPalette palette = workbook.getCustomPalette();
//        palette.setColorAtIndex(HSSFColor.SKY_BLUE.index, (byte) 0, (byte) 176, (byte) 240);
//        HSSFCellStyle style = workbook.createCellStyle();
//        HSSFDataFormat format = workbook.createDataFormat();
//        //这样才能真正的控制单元格格式，@就是指文本型，具体格式的定义还是参考上面的原文吧
//        style.setDataFormat(format.getFormat("@"));
//        //设置这些样式
//        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//        //style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
//        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//        //生成一个字体
//        HSSFFont font = workbook.createFont();
//        font.setColor(HSSFColor.AUTOMATIC.index);
//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//        //把字体应用到当前的样式
//        style.setFont(font);
//        // 生成并设置另一个样式,用于设置内容样式
//        HSSFCellStyle style2 = workbook.createCellStyle();
//        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
//        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//
//
//        // 生成另一个字体
//        HSSFFont font2 = workbook.createFont();
//        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
//        // 把字体应用到当前的样式
//        style2.setFont(font2);
//
//        //创建单元格
//        HSSFRow row = sheet.createRow(0);
//        /*//该对象的名字
//        String voName = list.get(0).getClass().getSimpleName();
//        //获取EXCEL列字段信息
//        String data = ExcelPoiConstant.map.get(voName);*/
//
//        //列字段的英文名字
//        String[] column = data.split(",")[0].split("/");
//        //列字段的中文名字
//        String[] columnName = data.split(",")[1].split("/");
//
//        int length = column.length;
//        int index = 0;
//        for (int i = 0; i < length; i++) {
//            HSSFCell cell = row.createCell(index);
//            cell.setCellValue(new HSSFRichTextString(columnName[index]));
//            cell.setCellStyle(style);
//            index++;
//        }
//        //插入数据
//        Object vo = null;
//        for (int i = 0; i < list.size(); i++) {
//            vo = list.get(i);
//            JSONObject jsonObject = (JSONObject) JSON.toJSON(vo);
//            row = sheet.createRow(i + 1);
//            for (int k = 0; k < length; k++) {
//                row.createCell(k).setCellValue(jsonObject.get(column[k]) == null ? "" : jsonObject.get(column[k]).toString());
//            }
//        }
//        //流输出
//        try {
////            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/xinniu/Desktop/excel.xls");
////            workbook.write(fileOutputStream);
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
