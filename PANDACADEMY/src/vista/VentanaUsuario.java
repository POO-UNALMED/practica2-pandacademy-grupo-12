package vista;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VentanaUsuario  {

	VBox barra; 
	Scene user;
	MenuItem salir;
	MenuItem editarProfesores;

	public VentanaUsuario() {
		
		BorderPane nombre = new BorderPane();
		user = new Scene(nombre, 800, 700);
		
		MenuBar barraMenu = new MenuBar();
		
		Menu archivo = new Menu("Archivo");
		MenuItem usuarioMenu = new MenuItem("Usuario");
		 salir = new MenuItem("Salir");
		archivo.getItems().addAll(usuarioMenu, salir);
		
		Menu procesos = new Menu("Procesos y consultas");
		
		Menu perfil = new Menu("Perfil");
		MenuItem mostrarPerfil = new MenuItem("Mostrar perfil"); 
		MenuItem editarPerfil = new MenuItem("Editar Perfil");
		perfil.getItems().addAll(mostrarPerfil, editarPerfil);
		
		Menu asignatura = new Menu("Asignatura");
		MenuItem mostrarAsignaturas = new MenuItem("Mostrar Asignaturas"); 
		MenuItem editarAsignaturas = new MenuItem("Editar Asignaturas");
		MenuItem crearAsignaturas = new MenuItem("Crear Asignaturas");
		MenuItem borrarAsignaturas = new MenuItem("Borrar Asignaturas");
		asignatura.getItems().addAll(mostrarAsignaturas, editarAsignaturas, crearAsignaturas, borrarAsignaturas);

		
		Menu notas = new Menu("Notas");
		MenuItem mostrarNotas = new MenuItem("Mostrar notas"); 
		MenuItem calcularPAPA = new MenuItem("Calcular PAPA"); 
		MenuItem calculadora = new MenuItem("Calculadora"); 
		notas.getItems().addAll(mostrarNotas, calcularPAPA, calculadora);

		
		Menu horario = new Menu("Horario");
		MenuItem horariosClase = new MenuItem("Mostrar horarios de clase"); 
		MenuItem horariosAsesoria = new MenuItem("Mostrar horarios de asesoría"); 
		horario.getItems().addAll(horariosClase, horariosAsesoria);

		
		Menu profesores = new Menu("Profesores");
		MenuItem listaProfesores = new MenuItem("Lista profesores");
		MenuItem editarProfesores = new MenuItem("Editar profesores");
		profesores.getItems().addAll(listaProfesores, editarProfesores);

		
		Menu semestres = new Menu("Semestres");
		MenuItem nuevoSemestre = new MenuItem("Nuevo semestre");
		MenuItem editarSemestre = new MenuItem("Editar semestre");
		MenuItem eliminarSemestre = new MenuItem("Eliminar semestre");
		MenuItem CambiarSemestre = new MenuItem("Cambiar semestre");
		semestres.getItems().addAll(nuevoSemestre, editarSemestre, eliminarSemestre, CambiarSemestre);


		
		procesos.getItems().addAll(perfil, asignatura, notas, horario, profesores, semestres);
		
		Menu ayuda = new Menu("Ayuda");
		MenuItem acerca = new MenuItem("Acerca de");
		ayuda.getItems().add(acerca);
		
		
		barraMenu.getMenus().addAll(archivo, procesos, ayuda);
		VBox barra = new VBox(barraMenu); 
		
		
		nombre.setTop(barra);

		
		
	}

}
