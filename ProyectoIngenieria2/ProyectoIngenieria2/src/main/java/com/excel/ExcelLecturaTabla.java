package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLecturaTabla {
	private File archivo;
	
	/**
	 * @param file
	 */
	public ExcelLecturaTabla(String file) {
		archivo=new File(file);
	}

	public void lecturaExcel() {
		//File archivo=new File("lectura_datos.xlsx");
		try {
			InputStream input=new FileInputStream(archivo);
			XSSFWorkbook libro=new XSSFWorkbook(input);
			XSSFSheet hoja=libro.getSheetAt(0);
			
			Iterator<Row> filas=hoja.rowIterator();
			Iterator<Cell> columnas=null;
			Row filaActual=null;
			Cell columnaActual=null;
			
			while(filas.hasNext()) {
				filaActual=filas.next();
				columnas=filaActual.cellIterator();
				while(columnas.hasNext()) {
					columnaActual=columnas.next();
					if(columnaActual.getCellType()==CellType.STRING) {
						String valor=columnaActual.getStringCellValue();
						System.out.println(valor);
					}
					if(columnaActual.getCellType()==CellType.NUMERIC) {
						double valor=columnaActual.getNumericCellValue();
						System.out.println(valor);
					}
					if(columnaActual.getCellType()==CellType.NUMERIC&& DateUtil.isCellDateFormatted(columnaActual)) {
						Date fecha =columnaActual.getDateCellValue();
						System.out.println(fecha);
					}
				}

			}
			input.close();
			libro.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
