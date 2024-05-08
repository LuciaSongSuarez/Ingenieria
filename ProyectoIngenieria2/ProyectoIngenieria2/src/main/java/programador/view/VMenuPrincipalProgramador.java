package programador.view;

import java.util.Scanner;
import common.model.IGestorCrud;

public class VMenuPrincipalProgramador{
	IGestorCrud gestor;
	public VMenuPrincipalProgramador(IGestorCrud gestor) {
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
		if(usersc.equals("p")&&passsc.equals("1234")) {
			//bucle para pedir datos

			VMenuCrudProgramador datos=new VMenuCrudProgramador(gestor);//Creamos instancia para pedir los datos
			int opcion=datos.menu();
			while(opcion!=0) {
				if (opcion==1) {
					//Create
					datos.create();

				}else if (opcion==2) {
					//READ
					datos.read();

				}else if (opcion==3) {
					datos.update();

				}else if (opcion==4) {
					datos.delete();
					
				}else if (opcion==5) {
					datos.lecturaExcel();
				}else if (opcion==6) {
					datos.cSoft();
				}else if (opcion==7) {
					datos.cHard();
				}
				opcion=datos.menu();
			}
		} 
	}
}
