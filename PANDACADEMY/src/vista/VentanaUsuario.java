package vista;

import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Persona.Estudiante;
import gestorAplicacion.Persona.Profesor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import paneles.ListaProfesores;
import paneles.PanelEditP;
import paneles.*;

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


	Menu horario = new Menu("Horario");
	MenuItem horariosClase = new MenuItem("Mostrar horarios de clase");
	MenuItem horariosAsesoria = new MenuItem(
			"Mostrar horarios de asesoría");

	Menu profesores = new Menu("Profesores");
	MenuItem listaProfesores = new MenuItem("Lista profesores");
	MenuItem editarProfesores = new MenuItem(
			"Editar profesores");

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
		horario.getItems().addAll(horariosClase,horariosAsesoria);
		profesores.getItems().addAll(listaProfesores,editarProfesores);
		//semestres.getItems().addAll(nuevoSemestre,editarSemestre,eliminarSemestre,CambiarSemestre);
		procesos.getItems().addAll(perfil,asignatura,calcularPAPA,horario,profesores,semestres);
		ayuda.getItems().add(acerca);

		barraMenu.getMenus().addAll(archivo,procesos,ayuda);

		nombre.setTop(barra);
	}
	
	

}