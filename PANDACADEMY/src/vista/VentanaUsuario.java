package vista;

import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Persona.Profesor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	
	PanelEditP editp= new PanelEditP();
	Profesor[] ejemploProfesores = new Profesor[] {new Profesor("Ejemplo", "ejemplo", "ejemplo", new Asignatura()),  
			new Profesor("Ejemplo1", "ejemplo1", "ejemplo1", new Asignatura()),
			new Profesor("Ejemplo2", "ejemplo2", "ejemplo2", new Asignatura())};
	
	ListaProfesores listaP = new ListaProfesores(ejemploProfesores);
	MostrarPerfil mostrarp= new MostrarPerfil();
	PanelAsignatura asig= new PanelAsignatura();
	
	Handler evento= new Handler();
	
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

	Menu notas = new Menu("Notas");
	MenuItem mostrarNotas = new MenuItem("Mostrar notas");
	MenuItem calcularPAPA = new MenuItem("Calcular PAPA");
	MenuItem calculadora = new MenuItem("Calculadora");

	Menu horario = new Menu("Horario");
	MenuItem horariosClase = new MenuItem("Mostrar horarios de clase");
	MenuItem horariosAsesoria = new MenuItem(
			"Mostrar horarios de asesoría");

	Menu profesores = new Menu("Profesores");
	MenuItem listaProfesores = new MenuItem("Lista profesores");
	MenuItem editarProfesores = new MenuItem(
			"Editar profesores");

	Menu semestres = new Menu("Semestres");
	MenuItem nuevoSemestre = new MenuItem("Nuevo semestre");
	MenuItem editarSemestre = new MenuItem("Editar semestre");
	MenuItem eliminarSemestre = new MenuItem("Eliminar semestre");
	MenuItem CambiarSemestre = new MenuItem(
			"Cambiar semestre");


	Menu ayuda = new Menu("Ayuda");
	MenuItem acerca = new MenuItem("Acerca de");

	
	VBox barra = new VBox(barraMenu);

	public VentanaUsuario(){
		
		editarPerfil.setOnAction(evento);
		editarProfesores.setOnAction(evento);
		mostrarPerfil.setOnAction(evento);
		asignatura.setOnAction(evento);
		

		
		archivo.getItems().addAll(usuarioMenu,salir);
		perfil.getItems().addAll(mostrarPerfil,editarPerfil);
		notas.getItems().addAll(mostrarNotas,calcularPAPA,calculadora);
		horario.getItems().addAll(horariosClase,horariosAsesoria);
		profesores.getItems().addAll(listaProfesores,editarProfesores);
		semestres.getItems().addAll(nuevoSemestre,editarSemestre,eliminarSemestre,CambiarSemestre);
		procesos.getItems().addAll(perfil,asignatura,notas,horario,profesores,semestres);
		ayuda.getItems().add(acerca);

		barraMenu.getMenus().addAll(archivo,procesos,ayuda);

		nombre.setTop(barra);
	}
	
	class Handler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			Object control= e.getSource();
			if (control.equals(editarPerfil)) {
				
				nombre.setCenter(editp.getPanel());
				
			}
			else if (control.equals(mostrarPerfil)) {
				nombre.setCenter(mostrarp.getPanel());
			}
			else if (control.equals(asignatura)) {
				nombre.setCenter(asig.getPanel());
			}
			else if (control.equals(editarProfesores)) {
				 
				ScrollPane s=new ScrollPane(listaP.getPanel());
				s.setPadding(new Insets(10));
				nombre.setCenter(s);
				
			}
			
		}
		
	}

}