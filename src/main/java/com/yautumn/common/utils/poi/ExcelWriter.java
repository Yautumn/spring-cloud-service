package com.yautumn.common.utils.poi;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelWriter {

    private static final int DEFAULT_COLUMN_SIZE = 60000;

    /**
     * 判断是否可以生成文件
     * @param fileCreatePath
     * @param fileName
     * @return
     * @throws Exception
     */
    private static File assertFile(String fileCreatePath,String fileName) throws Exception{
        File tempFile = new File(fileCreatePath + File.separator + fileName + ".xlsx");
        if (tempFile.exists()){
            if (tempFile.isDirectory()){
                throw new IOException("File '" + tempFile + "' exists but is a directory");
            }
            if (!tempFile.canWrite()){
                throw new IOException("File '" + tempFile + "' cannot be written to");
            }
        }else {
            File parent = tempFile.getParentFile();
            if (null != parent){
                if (!parent.mkdirs() && !parent.isDirectory()){
                    throw new IOException("File '" + parent + "' cannot be created");
                }
            }
        }
        return tempFile;
    }

    /**
     * 生成导出excel的文件并添加标题
     * @param directory 文件路径
     * @param fileName  文件名
     * @param sheetName sheet页名
     * @param columnNames      title内容
     * @param append    是否在现有excel下追加sheet
     * @return
     * @throws Exception
     */
    public static File writeExcelTitle(String directory,String fileName,String sheetName,List<String> columnNames, boolean append) throws Exception{
        File tempFile = assertFile(directory,fileName);
        return exportExcelTitle(tempFile,sheetName,columnNames,append);
    }

    public static File writeExcelData(String directory,String fileName,String sheetName,List<List<Object>> objs, boolean append) throws Exception{
        File tempFile = assertFile(directory,fileName);
        return exportExcelData(tempFile,sheetName,objs,append);
    }

    private static File exportExcelData(File tempFile, String sheetName, List<List<Object>> objs,boolean append) throws Exception {
        // 声明一个工作薄
        Workbook workBook;
        if (tempFile.exists()) {
            workBook = new XSSFWorkbook(new FileInputStream(tempFile));
        } else {
            workBook = new XSSFWorkbook();
        }

        Map<String, CellStyle> cellStyleMap = styleMap(workBook);
        // 正文样式
        CellStyle contentStyle = cellStyleMap.get("content");
        //正文整数样式
        CellStyle contentIntegerStyle = cellStyleMap.get("integer");
        //正文带小数整数样式
        CellStyle contentDoubleStyle = cellStyleMap.get("double");
        // 生成一个表格
        Sheet sheet = workBook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workBook.createSheet(sheetName);
        }
        //最新Excel列索引,从0开始
        int lastRowIndex = sheet.getLastRowNum();
        if (lastRowIndex > 0) {
            lastRowIndex++;
        }
        // 设置表格默认列宽度
        sheet.setDefaultColumnWidth(DEFAULT_COLUMN_SIZE);
        // 遍历集合数据,产生数据行,前两行为标题行与表头行
        for (List<Object> dataRow : objs) {
            Row row = sheet.createRow(lastRowIndex);
            lastRowIndex++;
            for (int j = 0; j < dataRow.size(); j++) {
                Cell contentCell = row.createCell(j);
                Object dataObject = dataRow.get(j);
                if (dataObject != null) {
                    if (dataObject instanceof Integer) {
                        contentCell.setCellStyle(contentIntegerStyle);
                        contentCell.setCellValue(Integer.parseInt(dataObject.toString()));
                    } else if (dataObject instanceof Double) {
                        contentCell.setCellStyle(contentDoubleStyle);
                        contentCell.setCellValue(Double.parseDouble(dataObject.toString()));
                    } else if (dataObject instanceof Long && dataObject.toString().length() == 13) {
                        contentCell.setCellStyle(contentStyle);
                        contentCell.setCellValue(getCnDate(new Date(Long.parseLong(dataObject.toString()))));
                    } else if (dataObject instanceof Date) {
                        contentCell.setCellStyle(contentStyle);
                        contentCell.setCellValue(getCnDate((Date) dataObject));
                    } else {
                        contentCell.setCellStyle(contentStyle);
                        contentCell.setCellValue(dataObject.toString());
                    }
                } else {
                    contentCell.setCellStyle(contentStyle);
                    // 设置单元格内容为字符型
                    contentCell.setCellValue("");
                }
            }
        }
        try {
            OutputStream ops = new FileOutputStream(tempFile);
            workBook.write(ops);
            ops.flush();
            ops.close();
        } catch (IOException e) {
            throw new Exception(e);
        }
        return tempFile;
    }

    /**
     * 日期转化为字符串,格式为yyyy-MM-dd HH:mm:ss
     */
    private static String getCnDate(Date date) {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 给生成excel文件添加标题
     * @param tempFile
     * @param sheetName
     * @param columnNames
     * @param append
     * @return
     */
    private static File exportExcelTitle(File tempFile, String sheetName, List<String> columnNames, boolean append) throws Exception{
        Workbook workBook;
        if (tempFile.exists() && append){
            workBook = new XSSFWorkbook(new FileInputStream(tempFile));
        }else {
            workBook = new XSSFWorkbook();
        }
        Map<String, CellStyle> cellStyleMap = styleMap(workBook);
        // 表头样式
        CellStyle headStyle = cellStyleMap.get("head");
        // 生成一个表格
        Sheet sheet = workBook.getSheet(sheetName);
        if (sheet == null) {
            sheet = workBook.createSheet(sheetName);
        }
        //最新Excel列索引,从0开始
        int lastRowIndex = sheet.getLastRowNum();
        if (lastRowIndex > 0) {
            lastRowIndex++;
        }
        // 设置表格默认列宽度
        sheet.setDefaultColumnWidth(DEFAULT_COLUMN_SIZE);
        // 合并单元格
        sheet.addMergedRegion(new CellRangeAddress(lastRowIndex, lastRowIndex, 0, columnNames.size() - 1));
        // 产生表格标题行
        Row rowMerged = sheet.createRow(lastRowIndex);
        lastRowIndex++;
        Cell mergedCell = rowMerged.createCell(0);
        mergedCell.setCellStyle(headStyle);
        mergedCell.setCellValue(new XSSFRichTextString(sheetName));
        // 产生表格表头列标题行
        Row row = sheet.createRow(lastRowIndex);
        for (int i = 0; i < columnNames.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(headStyle);
            RichTextString text = new XSSFRichTextString(columnNames.get(i));
            cell.setCellValue(text);
        }
        try {
            OutputStream ops = new FileOutputStream(tempFile);
            workBook.write(ops);
            ops.flush();
            ops.close();
        } catch (IOException e) {
            throw new Exception(e);
        }
        return tempFile;
    }

    private static Map<String, CellStyle> styleMap(Workbook workbook) {
        Map<String,CellStyle> styleMap = new LinkedHashMap<>();
        styleMap.put("head",creatCellHeadStyle(workbook));
        styleMap.put("content", createCellContentStyle(workbook));
        styleMap.put("integer", createCellContent4IntegerStyle(workbook));
        styleMap.put("double", createCellContent4DoubleStyle(workbook));
        return styleMap;
    }

    private static CellStyle createCellContent4DoubleStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置边框样式
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //设置对齐样式
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成字体
        Font font = workbook.createFont();
        // 正文样式
        style.setFillPattern(FillPatternType.NO_FILL);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));//保留两位小数点
        return style;
    }

    private static CellStyle createCellContent4IntegerStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置边框样式
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //设置对齐样式
        //设置对齐样式
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成字体
        Font font = workbook.createFont();
        // 正文样式
        style.setFillPattern(FillPatternType.NO_FILL);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));//数据格式只显示整数
        return style;
    }

    private static CellStyle createCellContentStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置边框样式
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //设置对齐样式
        //设置对齐样式
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成字体
        Font font = workbook.createFont();
        // 正文样式
        style.setFillPattern(FillPatternType.NO_FILL);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));//数据格式只显示整数
        return style;
    }

    private static CellStyle creatCellHeadStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置边框样式
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //设置对齐样式
        //设置对齐样式
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成字体
        Font font = workbook.createFont();
        // 正文样式
        style.setFillPattern(FillPatternType.NO_FILL);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }
}
