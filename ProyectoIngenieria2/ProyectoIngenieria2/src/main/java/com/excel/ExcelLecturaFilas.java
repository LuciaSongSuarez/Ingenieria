package com.excel;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

public class ExcelLecturaFilas {
	private File archivo;
	
	/**
	 * @param archivo
	 */
	public ExcelLecturaFilas(File archivo) {
		this.archivo = archivo;
	}

	public  void main(String[] args) {
		//File archivo=new File("lectura_datos.xlsx");
		try {
			InputStream input=new FileInputStream(archivo);
			
			XSSFWorkbook libro=new XSSFWorkbook(input);
			
			XSSFSheet hoja=libro.getSheetAt(0);
			
			Row fila=hoja.getRow(1);
			Iterator<Cell> columnas=fila.cellIterator();
			
			while(columnas.hasNext()) {
				Cell celda=columnas.next();
				if(celda.getCellType()==CellType.STRING) {
					String valor=celda.getStringCellValue();
					System.out.println(valor);
				}
				if(celda.getCellType()==CellType.NUMERIC) {
					double valor=celda.getNumericCellValue();
					System.out.println(valor);
				}
				if(celda.getCellType()==CellType.NUMERIC && DateUtil.isCellDateFormatted(celda)) {
					Date fecha =celda.getDateCellValue();
					System.out.println(fecha);
				}
			}
			input.close();
			libro.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
