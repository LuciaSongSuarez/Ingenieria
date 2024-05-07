package sanitario.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import common.model.IGestorCrud;
import common.model.Paciente;


public class VMenuPrincipalSanitario{
	IGestorCrud gestor;
	public VMenuPrincipalSanitario(IGestorCrud gestor) {
		this.gestor=gestor;
		this.sc = new Scanner(System.in);
	}
	/**
	 * Muestra menu principal de Programador
	 */
	private Scanner sc;


	/**
	 * Decide la opcion en funcion del menu
	 */
	public void menu() {

		//Bucle para la contrasena
		
		String usersc= "";
		System.out.println("Introduce usuario");
		usersc=sc.next();

		String passsc="";
		System.out.println("Introduce contrasena");
		passsc=sc.next();

		//_______________________________________Menu____________________________________________
		if(usersc.equals("s")&&passsc.equals("1234")) {
			//bucle para pedir datos

			VMenuCrudSanitario datos=new VMenuCrudSanitario(gestor);//Creamos instancia para pedir los datos
			int opcion=datos.menu();
			while(opcion!=0) {
				if (opcion==1) {
					//READ
					datos.read();

				}else if (opcion==2) {
					datos.lecturaExcel();
				}
				opcion=datos.menu();
			}
		} 
	}
}
