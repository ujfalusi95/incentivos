package com.edu4java.servelets;

import java.io.File;




import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportarExcel {
	 
    public	static ArrayList<String> data= new ArrayList<String>();
	public static  ArrayList<Double> data2=new ArrayList<Double>();
	
	public static  void ObtenerArchivos() throws IOException{
	
	FileInputStream file = new FileInputStream(new File("C:\\Users\\Emilio Espejo\\eclipse-workspace\\INCENTIVOS2\\war\\excelbuenobueno.xlsx"));
	// Crear el objeto que tendra el libro de Excel
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	Iterator<Row> rowIterator = sheet.iterator();
	Row row;
	while (rowIterator.hasNext()){
	    row = rowIterator.next();
	    Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;
	    while (cellIterator.hasNext()){
	    	
	       
			celda = cellIterator.next();
			
			 if (celda.getCellType() == Cell.CELL_TYPE_STRING) {
				 data.add(celda.getStringCellValue());
				
			 }
			 if (celda.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				    
				    data2.add(celda.getNumericCellValue());
				    
					//for(Double valores : data2){
						//System.out.println(valores );
					//}
					}
	    }
	}
	workbook.close();
}

}
