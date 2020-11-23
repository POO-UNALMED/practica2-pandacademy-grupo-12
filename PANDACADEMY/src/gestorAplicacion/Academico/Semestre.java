package gestorAplicacion.Academico;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.Horario;
import gestorAplicacion.Persona.Profesor;

// Clase que representa el semestre, guarda e implementa sus metodos correspondientes como el promedio academico

public class Semestre implements Serializable, Comparable<Semestre> {

	private String nombre;
	public ArrayList<Profesor> profesores = new ArrayList<>();  // lista que guarda los profesores 	de cada semestre
	private ArrayList<Asignatura> asignaturas = new ArrayList<>(); // lista que guarda las asignaturas de cada semestre
	private ArrayList<Horario> horarios = new ArrayList<>(); // lista que guarda todos los horarios de cada semestre;

	public Semestre(String nombre) {
		this.nombre = nombre;
	}

	public Semestre() {
	}

	public void setprofesores(ArrayList<Profesor> p) {
		profesores = p;
	}

	public ArrayList<Profesor> getProfesorList() {
		return this.profesores;
	}

	public Profesor getProfesor(String nombre) {
		for (Profesor profesor : profesores) {
			if(profesor.getNombre().equals(nombre)){
				return profesor;
			}
		}
		return null;
	}

	public void addProfesor(Profesor profesor){
		profesores.add(profesor);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Horario> getHorarios(Asignatura asg) {
		ArrayList<Horario> horarios = new ArrayList<>();
		for (Horario horario : this.horarios) {
			if (horario.getAsignatura() == asg) {
				horarios.add(horario);
			}
		}
		return horarios;
	}

	public float promedioSemetre() {
		float p = 0;
		int c = 0;
		for (Asignatura asg : asignaturas) {
			p += asg.promedio()*asg.getCreditos();
			c += asg.getCreditos();
		}
		if (c > 0) {
			return p;
		}
		return 0;
	}
	/**
	 * Devuelve la cantidad de créditos aprobados en el semestre.
	 * @return Créditos aprobados (int)
	 */
	public int creditosAprobados() {
		int total = 0;
		for (Asignatura asignatura : asignaturas) {
			if (asignatura.promedio() >= 3) {
				total += asignatura.getCreditos();
			}
		}
		return total;

	}
	/**
	 * Devuelve el total de créditos cursados en el semestre.
	 * @return Total de créditos del semestre (int)
	 */
	public int totalCreditos() {
		int total = 0;
		for (int i = 0; i < asignaturas.size(); i++) {
			total = total + asignaturas.get(i).getCreditos();
		}
		return total;
	}

	public void addAsignatura(Asignatura asignatura) {
		this.asignaturas.add(asignatura);
	}

	public void removeAsignatura(Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
	}

	public Asignatura getAsignatura(int index) {
		return asignaturas.get(index);
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	/**
	 * Busca una asignatura en el semestre por medio del nombre.
	 * @param nombre Nombre de la asignatura
	 * @return Objeto Asignatura
	 */
	public Asignatura getAsignatura(String nombre) {
		for (int i = 0; i < asignaturas.size(); i++) {
			Asignatura m = asignaturas.get(i);
			if (m.getNombre().equalsIgnoreCase(nombre)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public int compareTo(Semestre s) {
		String a = new String(String.valueOf(this.getNombre()));
		String b = new String(String.valueOf(s.getNombre()));
		return a.compareTo(b);
	}

	public void setHorario(ArrayList<Horario> h) {
		this.horarios = h;
	}

	public void addHorario(Horario h) {
		horarios.add(h);
	}

	public ArrayList<Horario> getHorarios() {
		return this.horarios;
	}

	public Horario getHorario(int i) {
		return this.horarios.get(i);
	}
}
