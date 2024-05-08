package admin.model;

import java.util.List;


import com.excel.ExcelLecturaTabla;

import common.model.IGestorCrud;
import common.model.Paciente;


public class GestorCrudAdmin implements IGestorCrud{
	private List<Paciente> list;

	public GestorCrudAdmin(List<Paciente> list) {
		this.list = list;
	}
	public void create(Object elemento) {

		list.add((Paciente)elemento);
	}
	/**
	 * @return devuelve la lista
	 */
	public String read() {
		String sRet="";
		for(int i=0;i<list.size();i++)
			sRet+=i+". "+list.get(i)+"\r\n";
		return sRet;
	}
	public static void lecturaExcel() {
		ExcelLecturaTabla leerExcel = new ExcelLecturaTabla("lectura_datos.xlsx");
	}
	@Override
	public boolean update(int pos, Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(int pos) {
		// TODO Auto-generated method stub
		return false;
	}
}
