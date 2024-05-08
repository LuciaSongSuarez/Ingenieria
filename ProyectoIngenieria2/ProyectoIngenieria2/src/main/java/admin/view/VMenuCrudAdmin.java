package admin.view;

import java.util.Scanner;
import com.excel.ExcelLecturaTabla;
import common.model.IGestorCrud;
import common.model.Paciente;

public class VMenuCrudAdmin {

	private IGestorCrud gc;
	private Scanner sc;
	/**
	 * 
	 * @param meds gestor crud
	 */
	public VMenuCrudAdmin(IGestorCrud meds) {
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
			System.out.println("1. Create (C)");
			System.out.println("2. Read (R)");
			System.out.println("3. Leer Excel");
			System.out.println("0. Otra para salir");
			return sc.nextInt();
		} catch (Exception e) {
			System.out.println("Opcion erronea");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
			return -1;
		}
	}
	/**
	 * agrega elementos
	 */
	public void create() {
		try {
			System.out.println("Ingrese el nombre del paciente:");
			String nombre = sc.next();

			System.out.println("Ingrese la edad del paciente:");
			int edad = sc.nextInt();

			System.out.println("Ingrese sexo del paciente(H: hombre/ M:Mujer:");
			String sexo = sc.next();
			gc.create(new Paciente(nombre,edad,sexo));
		} catch (Exception e) {
			System.out.println("Error en create");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
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
