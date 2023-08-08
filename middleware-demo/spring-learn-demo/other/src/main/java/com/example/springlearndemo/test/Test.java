package com.example.springlearndemo.test;


/**
 * @author: liubiao
 * @date: 2021/6/9 17:18
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] a= new int[] {4000,3000,1000,2000};

        System.out.println( average(a));
    }

    public static double average(int[] salary) {
        int max = salary[0], min = salary[0],sum = 0,maxCount  = 0 ,minCount = 0 ;

        for(int i = 0 ; i < salary.length ; i++){
            if(max < salary[i]){
                max = salary[i];
                maxCount = 1 ;
            }else
            if(max == salary[i]){
                maxCount ++  ;
            }

            if(min >  salary[i]){
                min = salary[i];
                minCount  = 1 ;
            }else if (min == salary[i]){
                minCount ++  ;
            }
            sum += salary[i];
        }
        System.out.println("max: " + max);

        System.out.println("maxCount: " + maxCount);
        System.out.println("min: " + min);

        System.out.println("minCount: " + minCount);
        double ping = (double)(sum - (max*maxCount) - (min * minCount) ) / (salary.length-minCount-maxCount);
        return ping;
    }

/*
    public static void docTurnPdf(String sourceFileName,String newFileName) throws Exception {
        if (!getLicense()) {// 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        File file = new File(newFileName);  //新建一个空白pdf文档
        FileOutputStream os = new FileOutputStream(file);
        Document doc = new Document(sourceFileName);//Address是将要被转化的word文档
        doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
        os.close();
        //删除doc文件，用不到就删掉
        File f = new File(sourceFileName);
        if(f.exists()){
            f.delete();
        }
    }



    public static boolean getLicense(){
        boolean result = false;
        try {
            InputStream is = Test.class.getClassLoader().getResourceAsStream("xml/license.xml"); //Test要替换成当前类名  license.xml应放在..\WebRoot\WEB-INF\classes路径下
            License aposeLic = new License();
            aposeLic.setLicense(is);
            is.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/
}
