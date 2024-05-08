package programador.view;

import java.util.Scanner;
import com.excel.ExcelLecturaTabla;
import common.model.IGestorCrud;
import common.model.Paciente;

public class VMenuCrudProgramador {

	private IGestorCrud gc;
	private Scanner sc;
	/**
	 * 
	 * @param meds gestor crud
	 */
	public VMenuCrudProgramador(IGestorCrud meds) {
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
			System.out.println("3. Update (U)");
			System.out.println("4. Delete (D)");
			System.out.println("5. Leer Excel");
			System.out.println("6. Config software");
			System.out.println("7. Config hardware");
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
	public boolean update() {
		boolean bRet=false;
		try{
			System.out.println("Introduce la pos");
			int pos=sc.nextInt();
			System.out.println("Ingrese el nombre del paciente:");
			String nombre = sc.next();

			System.out.println("Ingrese la edad del paciente:");
			int edad = sc.nextInt();

			System.out.println("Ingrese sexo del paciente(H: hombre/ M:Mujer:");
			String sexo = sc.next();
			bRet=gc.update(pos, new Paciente(nombre,edad,sexo));
		} catch (Exception e) {
			System.out.println("Error en update");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}
	/**
	 * borra
	 * @return verdadero si borra
	 */
	public boolean delete() {
		boolean bRet=false;
		try {
			System.out.println("Introduce la pos");
			int pos=sc.nextInt();
			bRet=gc.delete(pos);
		} catch (Exception e) {
			System.out.println("Error en delete");
			sc=new Scanner(System.in); //inicializamos o capturamos toda la linea sc.nextLine()
		}
		return bRet;
	}
	public void cSoft() {
		
		System.out.println("Informacion Config Software. \n La recibira en siguientes actualizaciones del sistema. \nRealizar test de prueba y comprobar manual.");
	}
	
	public void cHard() {
		
		System.out.println("Informacion Config Hardware. \nLa recibira en siguientes actualizaciones del sistema. \nCalibre los sensores y realice test de prueba.");
	}
	
	
	public static void lecturaExcel() {
		ExcelLecturaTabla leerExcel = new ExcelLecturaTabla("lectura_datos.xlsx");
		leerExcel.lecturaExcel();
	}
}



