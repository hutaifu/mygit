+ 工具类静态方法中注入

+ ```
  public static Map<String,Object> getFlowActionEnityInfo(String businessId){
          // 从ApplicationContext中获取ZhywWfPpreciseDiagnosisMapper的实例
          ZhywWfPpreciseDiagnosisService mapper = SpringUtils.getBean(ZhywWfPpreciseDiagnosisService.class);
          // 使用获取到的mapper实例进行数据库操作
          Flow flow = mapper.getFlowActionEnityInfo(businessId);

          Map<String,Object> result = new HashMap<>();
          result.put("code",10000);
          result.put("data",flow);
          result.put("msg","操作成功");
          return result;
      }这样写可以
  ```

+ docx文件后台转pdf

+ ```
  import org.apache.poi.xwpf.usermodel.*;
  import com.itextpdf.text.*;
  import com.itextpdf.text.pdf.*;

  public static void convertDocxToPdf(String docxFilePath, String pdfFilePath) {
      try {
          // 读取Word文档
          XWPFDocument document = new XWPFDocument(new FileInputStream(docxFilePath));
          
          // 创建PDF文档
          com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
          PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFilePath));
          pdfDocument.open();
          
          // 将Word文档内容写入PDF文档
          for (IBodyElement element : document.getBodyElements()) {
              if (element instanceof XWPFParagraph) {
                  XWPFParagraph paragraph = (XWPFParagraph) element;
                  Paragraph pdfParagraph = new Paragraph();
                  for (XWPFRun run : paragraph.getRuns()) {
                      if (run.getEmbeddedPictures().size() > 0) {
                          for (XWPFPicture picture : run.getEmbeddedPictures()) {
                              byte[] pictureData = picture.getPictureData().getData();
                              Image image = Image.getInstance(pictureData);
                              pdfParagraph.add(new com.itextpdf.text.Chunk(image, 0, 0, true));
                          }
                      } else {
                          pdfParagraph.add(new com.itextpdf.text.Paragraph(run.getText()));
                      }
                  }
                  pdfDocument.add(pdfParagraph);
              } else if (element instanceof XWPFTable) {
                  XWPFTable table = (XWPFTable) element;
                  PdfPTable pdfTable = new PdfPTable(table.getNumberOfColumns());
                  for (XWPFTableRow row : table.getRows()) {
                      for (XWPFTableCell cell : row.getTableCells()) {
                          pdfTable.addCell(cell.getText());
                      }
                  }
                  pdfDocument.add(pdfTable);
              }
          }
          
          // 关闭文档
          pdfDocument.close();
          document.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  ```
  + doc文件后台

  + ```
    import org.apache.poi.hwpf.HWPFDocument;
    import org.apache.poi.hwpf.converter.WordToPdfConverter;
    import org.apache.poi.hwpf.usermodel.*;
    import com.itextpdf.text.*;
    import com.itextpdf.text.pdf.*;

    public static void convertDocToPdf(String docFilePath, String pdfFilePath) {
        try {
            // 读取Word文档
            HWPFDocument document = new HWPFDocument(new FileInputStream(docFilePath));
            
            // 创建PDF文档
            com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
            PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFilePath));
            pdfDocument.open();
            
            // 将Word文档内容写入PDF文档
            Range range = document.getRange();
            WordToPdfConverter converter = new WordToPdfConverter(pdfDocument);
            converter.processDocument(range);
            
            // 处理图片
            for (Picture picture : document.getPicturesTable().getAllPictures()) {
                byte[] pictureData = picture.getContent();
                Image image = Image.getInstance(pictureData);
                pdfDocument.add(image);
            }
            
            // 处理表格
            for (Table table : document.getRange().getTables()) {
                PdfPTable pdfTable = new PdfPTable(table.numColumns());
                for (int rowIndex = 0; rowIndex < table.numRows(); rowIndex++) {
                    TableRow row = table.getRow(rowIndex);
                    for (int colIndex = 0; colIndex < row.numCells(); colIndex++) {
                        TableCell cell = row.getCell(colIndex);
                        pdfTable.addCell(cell.text());
                    }
                }
                pdfDocument.add(pdfTable);
            }
            
            // 关闭文档
            pdfDocument.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ```

    ​

+ JSONArray是Java中处理JSON数据的一个类，常用的方法包括：

  1. length()：返回JSONArray中元素的个数。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[1,2,3]");
  int length = jsonArray.length(); // length = 3

      
  ```

  1. get(int index)：返回JSONArray中指定位置的元素。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[1,2,3]");
  int element = jsonArray.getInt(1); // element = 2

      
  ```

  1. put(Object value)：向JSONArray中添加元素。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[1,2,3]");
  jsonArray.put(4);

      
  ```

  1. remove(int index)：从JSONArray中删除指定位置的元素。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[1,2,3]");
  jsonArray.remove(1); // jsonArray = [1,3]

      
  ```

  1. toString()：将JSONArray转换为字符串。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[1,2,3]");
  String jsonString = jsonArray.toString(); // jsonString = "[1,2,3]"

      
  ```

  1. getJSONObject(int index)：返回JSONArray中指定位置的JSONObject对象。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[{\"name\":\"Tom\",\"age\":18},{\"name\":\"Jerry\",\"age\":20}]");
  JSONObject jsonObject = jsonArray.getJSONObject(1); // jsonObject = {"name":"Jerry","age":20}

      
  ```

  1. getJSONArray(int index)：返回JSONArray中指定位置的JSONArray对象。

  ```
  java
  插入代码复制代码JSONArray jsonArray = new JSONArray("[[1,2],[3,4]]");
  JSONArray subArray = jsonArray.getJSONArray(1); // subArray = [3,4]
  ```

+ ```
  java
  插入代码复制代码public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
      Map<String, Object> map = new HashMap<>();
      Class<?> clazz = obj.getClass();
      for (Field field : clazz.getDeclaredFields()) {
          field.setAccessible(true);
          String fieldName = field.getName();
          Object fieldValue = field.get(obj);
          map.put(fieldName, fieldValue);
      }
      return map;
  }

      
  ```

  这个方法接收一个Java对象作为参数，然后使用反射获取对象的所有字段，将字段名和字段值存储到一个Map中，并返回该Map。需要注意的是，该方法只能处理对象的非静态字段。

