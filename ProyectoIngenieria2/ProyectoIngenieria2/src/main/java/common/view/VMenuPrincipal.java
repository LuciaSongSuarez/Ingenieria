package common.view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import common.model.IGestorCrud;
import common.model.Paciente;
import common.util.FileUtil;
import programador.model.GestorCrudProgramador;
import programador.view.VMenuPrincipalProgramador;
import sanitario.view.VMenuPrincipalSanitario;
import sanitario.model.GestorCrudSanitario;
import admin.model.GestorCrudAdmin;
import admin.view.VMenuPrincipalAdmin;


/**
 * Muestra menu principal
 */
public class VMenuPrincipal {
	private Scanner sc;
	private final static String pathAdmin="data\\administrador.dat";
	//private final static String pathSin="data\\sintomas.dat";
	private IGestorCrud gestorAdmin;

	/**
	 * @param sc
	 */
	public VMenuPrincipal(IGestorCrud igAdmin) {
		gestorAdmin=igAdmin;
		this.sc = new Scanner(System.in);
	}
	/**
	 * Decide que usuario quiere abrir
	 */
	public void menu() {
		//bucle para pedir datos
		int opcion=menuOpcion();
		FileUtil fuPac=new FileUtil(this.pathAdmin);
		while(opcion!=0) {
			if (opcion==1) {
				//Lanzar menu Programador
				VMenuPrincipalProgramador principalprog=new VMenuPrincipalProgramador(new GestorCrudProgramador(new ArrayList<Paciente>()));
				principalprog.menu();
			}else if(opcion==2) {
				//Lanzar menu administrador
				VMenuPrincipalAdmin principalAdmin=new VMenuPrincipalAdmin(new GestorCrudAdmin(new ArrayList<Paciente>()));
				principalAdmin.menu();
			}else if(opcion==3) {
				//Lanzar menu Sanitario
				VMenuPrincipalSanitario principalSanitario=new VMenuPrincipalSanitario(new GestorCrudSanitario(new ArrayList<Paciente>()));
				principalSanitario.menu();
			}
			
			opcion=menuOpcion();
		}
	} 
	/**
	 * menu principal de opciones>
	 * @return entero introducido o -1 si hay error
	 */
	public int menuOpcion() {
		try {
			System.out.println("Introduce una opcion");
			System.out.println("1. Ir al menu de programador");
			System.out.println("2. Ir al menu de administrador");
			System.out.println("3. Ir al menu de sanitario");
			System.out.println("0. Para salir");
			return sc.nextInt();
		}catch (Exception e) {
			System.out.println("Opcion erronea");
			sc=new Scanner(System.in); //inicializamos
			return -1;
		}
	}
	
	public static void main(String[] args) {
		//declaro lista de pacientes
		List<Paciente> listPac=new ArrayList<Paciente>();
		//Lanzar aplicacion
		VMenuPrincipal principal=new VMenuPrincipal(new GestorCrudProgramador(listPac));
		principal.menu();
	}
}
