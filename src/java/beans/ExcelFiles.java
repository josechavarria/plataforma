/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 *
 * @author Carlos
 */
public class ExcelFiles {
    

    /**
     *
     * @param strem
     * @return
     */
    public byte[] ficheiroExcell(HashMap<Integer,linha> linhas , String nomePagina){
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet =  workbook.createSheet(nomePagina);
            Set<Integer> keys= linhas.keySet();
            for(Integer lin: keys){
                
                HSSFRow row;
                row = sheet.createRow((short)lin.intValue());
                for(celula c:linhas.get(lin).celulas){
                    if(c.isFormula()){
                        HSSFCell cell;
                     cell=row.createCell((short) c.id);
                            cell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                           cell.setCellFormula(c.valor);
                    
                    }else{
                    row.createCell((short) c.id).setCellValue(c.valor);
                    }
                }
                
                
            }
            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            workbook.write(outByteStream);
            byte [] outArray = outByteStream.toByteArray();
            return outArray;
        } catch (IOException ex) {
            Logger.getLogger(ExcelFiles.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public  void excell(HashMap<Integer,linha> linhas ,String fileName, String nomePagina) throws IOException{
    File f = new File(fileName);
     HSSFWorkbook workbook = new HSSFWorkbook();
     HSSFSheet sheet =  workbook.createSheet(nomePagina); 
     Set<Integer> keys= linhas.keySet();
     
    for(Integer lin: keys){
          
      HSSFRow row;
        row = sheet.createRow((short)lin.intValue());
        for(celula c:linhas.get(lin).celulas){
             row.createCell((short) c.id).setCellValue(c.valor);
                
        }
  
    }
      FileOutputStream fileOut =  new FileOutputStream(f);
                workbook.write(fileOut);
                fileOut.close();
    
    
    
    
    }
    
    public  static void criarexcel(){
        
        try {
            String filename="C:/NewExcelFile.xls" ;

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet =  workbook.createSheet("Pagina1");  
                 HSSFRow rowhead=   sheet.createRow((short)0);
                rowhead.createCell((short) 0).setCellValue("Numero");


                HSSFRow row =   sheet.createRow((short)1);
                row.createCell((short) 0).setCellValue("15362");
                

                FileOutputStream fileOut =  new FileOutputStream(new File(filename));
                workbook.write(fileOut);
                fileOut.close();
                System.out.println("Your excel file has been generated!");

        } catch (IOException e) {
            }
     
    }
  
    /* uhsjbvsakBXKSAbjas*/
    //Inserir teste  
}
 
