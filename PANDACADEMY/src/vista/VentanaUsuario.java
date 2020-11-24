package vista;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VentanaUsuario {
	
	BorderPane nombre = new BorderPane();
	Scene user=new Scene(nombre,800,700);

	MenuBar barraMenu = new MenuBar();

	Menu archivo = new Menu("Archivo");
	MenuItem usuarioMenu = new MenuItem("Usuario");
	MenuItem salir=new MenuItem("Salir");

	Menu procesos = new Menu("Procesos y consultas");

	Menu perfil = new Menu("Perfil");
	MenuItem mostrarPerfil = new MenuItem("Mostrar perfil");
	MenuItem editarPerfil = new MenuItem("Editar Perfil");
	

	MenuItem asignatura = new MenuItem("Asignaturas");
	/*MenuItem mostrarAsignaturas = new MenuItem("Mostrar Asignaturas");
	MenuItem editarAsignaturas = new MenuItem("Editar Asignaturas");
	MenuItem crearAsignaturas = new MenuItem("Crear Asignaturas");
	MenuItem borrarAsignaturas = new MenuItem("Borrar Asignaturas");
	*/


	MenuItem calcularPAPA = new MenuItem("Calcular PAPA");


	MenuItem horario = new MenuItem("Horario");


	MenuItem profesores = new MenuItem("Profesores");

	MenuItem semestres = new MenuItem("Semestres");
	
	/*MenuItem nuevoSemestre = new MenuItem("Nuevo semestre");
	MenuItem editarSemestre = new MenuItem("Editar semestre");
	MenuItem eliminarSemestre = new MenuItem("Eliminar semestre");
	MenuItem CambiarSemestre = new MenuItem(
			"Cambiar semestre");
	 */

	Menu ayuda = new Menu("Ayuda");
	MenuItem acerca = new MenuItem("Acerca de");

	
	VBox barra = new VBox(barraMenu);

	public VentanaUsuario(){
		
		archivo.getItems().addAll(usuarioMenu,salir);
		perfil.getItems().addAll(mostrarPerfil,editarPerfil);


		procesos.getItems().addAll(perfil,asignatura,calcularPAPA,horario,profesores,semestres);
		ayuda.getItems().add(acerca);

		barraMenu.getMenus().addAll(archivo,procesos,ayuda);

		nombre.setTop(barra);
	}
	
	

}