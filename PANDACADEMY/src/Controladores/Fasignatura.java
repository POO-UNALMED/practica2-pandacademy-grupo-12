package Controladores;

import java.util.ArrayList;
import java.util.Optional;

import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Nota;
import gestorAplicacion.Academico.Semestre;
import gestorAplicacion.Persona.Estudiante;
import gestorAplicacion.Persona.Profesor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import paneles.FieldPanel;
import vista.principal;

public class Fasignatura {

    public static boolean checkAsignatura(Estudiante est, String nombre) {
        Estudiante e = est;
        boolean aux = true;
        for (int i = 0; i < e.getSemestres().size(); i++) {
            Semestre s = e.getSemestres().get(i);
            for (int j = 0; j < s.getAsignaturas().size(); j++) {
                if (s.getAsignatura(j).getNombre().equalsIgnoreCase(nombre)
                        && s.getAsignatura(j).estadoAsignatura().indexOf("Aprobada") >= 0) {
                    aux = false;
                    break;
                }
            }
        }
        if (aux) {
            for (int i = 0; i < principal.sa.getAsignaturas().size(); i++) {
                if (principal.sa.getAsignatura(i).getNombre().equalsIgnoreCase(nombre)) {
                    aux = false;
                    break;
                }
            }

        }
        return aux;
    }

    public static void addAsignatura() {
        Button guardar = new Button("GUARDAR");
        Button cancelar = new Button("CANCELAR");
        guardar.setAlignment(Pos.CENTER_RIGHT);
        Button agregarnotas = new Button("AGREGAR NOTAS");

        Label Tit = new Label("Nueva Asignatura");
        Label desc = new Label(
                "EN ESTA VENTANA PODRAS CREAR Y AGRAGAR TU NUEVA ASIGNATURA\nLOS CAMPOS MARCADOS CON * SON OBLIGATORIOS");
        desc.setStyle("-fx-border-color: BLUE;");
        Tit.setStyle("-fx-border-color: BLUE;");

        String[] criterios = new String[] { "CREDITOS*", "NOMBRE*", "PROFESOR", "DETALLES" };
        String[] valores = new String[] { "Creditos", "Nombre de la Asignatura", "Nombre del Profesor", "Detalles" };
        boolean[] habilitados = new boolean[] { true, true, true, true };
        FieldPanel datosbasicos = new FieldPanel("DATOS BASICOS", criterios, "", valores, habilitados);
        datosbasicos.getP().setVgap(10);

        GridPane notas = new GridPane();

        notas.setVgap(10);
        notas.setHgap(10);
        notas.addColumn(1, agregarnotas);
        notas.addColumn(0, new Label(""));
        notas.addColumn(2, new Label(""));
        notas.addColumn(0, new Label("Periodos"));
        notas.addColumn(1, new Label("Notas"));
        notas.addColumn(2, new Label("Porcentaje"));

        AddNote nota = new AddNote(notas);
        agregarnotas.setOnAction(nota);

        HBox botonesprin = new HBox(guardar, cancelar);
        botonesprin.setAlignment(Pos.CENTER);
        botonesprin.setSpacing(10);
        GridPane root = new GridPane();
        root.setVgap(30);
        root.addColumn(0, Tit, desc, datosbasicos.getP(), notas, botonesprin);
        ScrollPane scroll = new ScrollPane(root);
        scroll.setPadding(new Insets(10));
        Stage v = new Stage();
        Scene s = new Scene(scroll, 450, 500);

        v.setResizable(false);
        v.setScene(s);
        v.show();

        guardar.setOnAction(new EventHandler<ActionEvent>() {

            Asignatura asg = new Asignatura();

            private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
                for (Node node : gridPane.getChildren()) {
                    if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                        return node;
                    }
                }
                return null;
            }

            @Override
            public void handle(ActionEvent event) {
                try {
                    asg.setCreditos(Integer.valueOf(datosbasicos.getValue("CREDITOS*")));
                    asg.setNombre(datosbasicos.getValue("NOMBRE*"));
                    if (!datosbasicos.getValue("PROFESOR").equals("Nombre del Profesor")) {
                        asg.setProfesor(new Profesor(datosbasicos.getValue("PROFESOR"), "Correo", "Detalles", asg,
                                principal.sa));
                    }
                    asg.setDetalles(datosbasicos.getValue("DETALLES"));
                    int aux = notas.getRowIndex(notas.getChildren().get(notas.getChildren().size() - 1)) + 1;
                    for (int i = 2; i < aux; i++) {
                        TextField nota = (TextField) getNodeFromGridPane(notas, 1, i);
                        TextField porcentaje = (TextField) getNodeFromGridPane(notas, 2, i);
                        asg.agregarNota(new Nota(Float.valueOf(porcentaje.getText())/100, Float.valueOf(nota.getText())));
                    }
                    if (checkAsignatura(principal.estudiante, asg.getNombre())) {
                        principal.sa.addAsignatura(asg);
                        v.close();

                        Alert aviso = new Alert(AlertType.CONFIRMATION);
                        aviso.setHeaderText(null);
                        aviso.setContentText("Nueva Asignatura creada");
                        aviso.show();
                    } else {
                        Alert alerta = new Alert(AlertType.WARNING);
                        alerta.setContentText("¡ESTA ASIGNATURA YA ESTA CREADA!");
                        alerta.initStyle(StageStyle.UTILITY);
                        alerta.showAndWait();
                    }
                } catch (Exception e) {
                    Alert aviso = new Alert(AlertType.ERROR);
                    aviso.setHeaderText(null);
                    aviso.setContentText("TIPO DE DATO NO VALIDO");
                    aviso.showAndWait();
                    datosbasicos.clean();

                    notas.getChildren().clear();
                    notas.setVgap(10);
                    notas.setHgap(10);
                    notas.addColumn(1, agregarnotas);
                    notas.addColumn(0, new Label(""));
                    notas.addColumn(2, new Label(""));
                    notas.addColumn(0, new Label("Periodos"));
                    notas.addColumn(1, new Label("Notas"));
                    notas.addColumn(2, new Label("Porcentaje (%)"));
                }
            }
        });

        cancelar.setOnAction(e -> {
            v.close();
        });
    }

    public static void PanelEdit(Asignatura asg) {
        Button guardar = new Button("GUARDAR");
        Button cancelar = new Button("BORRAR");
        guardar.setAlignment(Pos.CENTER_RIGHT);
        Button agregarnotas = new Button("AGREGAR NOTAS");

        Label Tit = new Label(asg.getNombre().toUpperCase());
        Label desc = new Label("EN ESTA VENTANA PODRAS EDITAR LOS DATOS DE TU ASIGNATURA");
        desc.setStyle("-fx-border-color: BLUE;");
        Tit.setStyle("-fx-border-color: BLUE;");

        String profesor = "Nombre del Profesor";
        if (asg.getProfesor() != null) {
            profesor = asg.getProfesor().getNombre();
        }

        String[] criterios = new String[] { "CREDITOS", "NOMBRE", "PROFESOR", "DETALLES" };
        String[] valores = new String[] { String.valueOf(asg.getCreditos()), asg.getNombre(), profesor,
                asg.getDetalles() };
        boolean[] habilitados = new boolean[] { true, true, true, true };
        FieldPanel datosbasicos = new FieldPanel("DATOS BASICOS", criterios, "", valores, habilitados);
        datosbasicos.getP().setVgap(10);

        GridPane notas = new GridPane();

        notas.setVgap(10);
        notas.setHgap(10);
        notas.addColumn(1, agregarnotas);
        notas.addColumn(0, new Label(""));
        notas.addColumn(2, new Label(""));
        notas.addColumn(0, new Label("Periodos"));
        notas.addColumn(1, new Label("Notas"));
        notas.addColumn(2, new Label("Porcentaje"));

        for (int i = 0; i < asg.getNotas().size(); i++) {

            notas.addColumn(0, new Label(" PERIODO " + i));
            TextField n = new TextField(String.valueOf(asg.getNotas().get(i).getNota()));
            notas.addColumn(1, n);
            TextField p = new TextField(String.valueOf(asg.getNotas().get(i).getPorcentaje()*100));
            notas.addColumn(2, p);
        }

        AddNote nota = new AddNote(notas);
        agregarnotas.setOnAction(nota);

        HBox botonesprin = new HBox(guardar, cancelar);
        botonesprin.setAlignment(Pos.CENTER);
        botonesprin.setSpacing(10);
        GridPane root = new GridPane();
        root.setVgap(30);
        root.addColumn(0, Tit, desc, datosbasicos.getP(), notas, botonesprin);
        ScrollPane scroll = new ScrollPane(root);
        scroll.setPadding(new Insets(10));
        Stage v = new Stage();
        Scene s = new Scene(scroll, 450, 500);

        v.setResizable(false);
        v.setScene(s);
        v.show();

        cancelar.setOnAction(e -> {
            principal.sa.removeProfesor(asg.getProfesor());
            principal.sa.removeAsignatura(asg);
            v.close();
        });

        guardar.setOnAction(new EventHandler<ActionEvent>() {
            
            private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
                for (Node node : gridPane.getChildren()) {
                    if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                        return node;
                    }
                }
                return null;
            }

            @Override
            public void handle(ActionEvent event) {
                try {
                    Alert aviso = new Alert(AlertType.CONFIRMATION);
                    aviso.setHeaderText(null);
                    aviso.setContentText("Quiere guardar los cambios?");
                    Optional<ButtonType> result = aviso.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        asg.setCreditos(Integer.valueOf(datosbasicos.getValue("CREDITOS")));
                        asg.setNombre(datosbasicos.getValue("NOMBRE"));
                        if (!datosbasicos.getValue("PROFESOR").equals("Nombre del Profesor")) {
                            asg.setProfesor(new Profesor(datosbasicos.getValue("PROFESOR"), "Correo", "Detalles", asg,
                                    principal.sa));
                        }
                        asg.setDetalles(datosbasicos.getValue("DETALLES"));
                        int aux = notas.getRowIndex(notas.getChildren().get(notas.getChildren().size() - 1)) + 1;
                        asg.setNotas(new ArrayList<Nota>());
                        for (int i = 2; i < aux; i++) {
                            TextField nota = (TextField) getNodeFromGridPane(notas, 1, i);
                            TextField porcentaje = (TextField) getNodeFromGridPane(notas, 2, i);
                            asg.agregarNota(
                                    new Nota(Float.valueOf(porcentaje.getText())/100, Float.valueOf(nota.getText())));
                        }
                        v.close();
                    } else {
                        datosbasicos.clean();
                        notas.getChildren().clear();
                        for (int i = 0; i < asg.getNotas().size(); i++) {

                            notas.addColumn(0, new Label(" PERIODO " + i));
                            TextField n = new TextField(String.valueOf(asg.getNotas().get(i).getNota()));
                            notas.addColumn(1, n);
                            TextField p = new TextField(String.valueOf(asg.getNotas().get(i).getPorcentaje()));
                            notas.addColumn(2, p);
                        }
                    }
                } catch (Exception e) {
                    Alert aviso = new Alert(AlertType.ERROR);
                    aviso.setHeaderText(null);
                    aviso.setContentText("TIPO DE DATO NO VALIDO");
                    aviso.showAndWait();
                    datosbasicos.clean();

                    notas.getChildren().clear();
                    notas.getChildren().clear();
                    notas.setVgap(10);
                    notas.setHgap(10);
                    notas.addColumn(1, agregarnotas);
                    notas.addColumn(0, new Label(""));
                    notas.addColumn(2, new Label(""));
                    notas.addColumn(0, new Label("Periodos"));
                    notas.addColumn(1, new Label("Notas"));
                    notas.addColumn(2, new Label("Porcentaje (%)"));
                    for (int i = 0; i < asg.getNotas().size(); i++) {

                        notas.addColumn(0, new Label(" PERIODO " + i));
                        TextField n = new TextField(String.valueOf(asg.getNotas().get(i).getNota()));
                        notas.addColumn(1, n);
                        TextField p = new TextField(String.valueOf(asg.getNotas().get(i).getPorcentaje()));
                        notas.addColumn(2, p);
                    }
                }
            }

        });
    }

    static class AddNote implements EventHandler<ActionEvent> {
        GridPane notas;

        public AddNote(GridPane notas) {
            this.notas = notas;
        }

        @Override
        public void handle(ActionEvent event) {
            notas.addColumn(0, new Label(" PERIODO " + notas.getRowConstraints().size() + 1));
            TextField n = new TextField("0.0");
            notas.addColumn(1, n);
            TextField p = new TextField("0");
            notas.addColumn(2, p);
            // TODO Auto-generated method stub
        }
    }
}
