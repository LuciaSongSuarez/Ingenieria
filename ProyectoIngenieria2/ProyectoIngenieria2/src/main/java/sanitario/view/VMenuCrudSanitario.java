package sanitario.view;

import java.util.Scanner;
import com.excel.ExcelLecturaTabla;
import common.model.IGestorCrud;
import common.model.Paciente;

public class VMenuCrudSanitario {

	private IGestorCrud gc;
	private Scanner sc;
	/**
	 * 
	 * @param meds gestor crud
	 */
	public VMenuCrudSanitario(IGestorCrud meds) {
		this.gc = meds;
		this.sc = new Scanner(System.in);
	}
	/**
	 * muestra menu principal
	 * @return opcion seleccionada o -1 si da un error
	 */
	public int menu() {
		try {
			System.out.println("Introduce una opcion");
			System.out.println("1. Read (R)");
			System.out.println("2. Leer Excel");
			System.out.println("0. Otra para salir");
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println("Opcion erronea");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
			return -1;
		}
	}
	
	/**
	 * muestra por pantalla los pacientes
	 */
	public void read() {
		System.out.println(gc.read());
	}
	/**
	 * actualiza
	 * @return verdadero si actualiza
	 */
	public static void lecturaExcel() {
		ExcelLecturaTabla leerExcel = new ExcelLecturaTabla("lectura_datos.xlsx");
		leerExcel.lecturaExcel();
	}
}
