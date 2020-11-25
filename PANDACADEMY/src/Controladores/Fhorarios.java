package Controladores;

import java.util.ArrayList;
import java.util.Optional;

import gestorAplicacion.Horario;
import gestorAplicacion.Academico.Asignatura;
import gestorAplicacion.Academico.Semestre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import paneles.FieldPanel;
import vista.principal;

public class Fhorarios {
    public static boolean checkHorario(String dia, String h1, String h2, Semestre s) {
        ArrayList<Horario> horarios = s.getHorarios();
        boolean check = true;
        for (Horario horario : horarios) {
            if (horario.getDia().equalsIgnoreCase(dia)) {
                if (!horario.getInicio().equals(h1)) {
                    if (horario.getInicio().compareTo(h1) < 0) {
                        if (h1.compareTo(horario.getFinal()) >= 0) {
                            check = true;
                        } else {
                            return false;
                        }
                    } else {
                        if (h2.compareTo(horario.getInicio()) <= 0) {
                            check = true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            } else {
                check = true;
            }
        }
        return check;
    }

    public static void addHorario() {
        Button guardar = new Button("GUARDAR");
        Button cancelar = new Button("CANCELAR");
        HBox butons = new HBox(guardar, cancelar);
        butons.setSpacing(5);
        butons.setAlignment(Pos.CENTER);

        Label tit = new Label("NUEVO HORARIO");
        tit.setStyle("-fx-border-color: BLUE;");
        Label desc = new Label("AQUI PODRAS INGRESAR EL HORARIO DE CLASE DE LA ASIGNATURA (FORMATO 24 HORAS)");
        desc.setStyle("-fx-border-color: BLUE;");

        String[] criterios = new String[] { "ASIGNATURA", "DIA", "HORA INICIO", "HORA FINAL" };
        String[] valores = new String[] { "Asignatura", "Dia", "Hora Inicio", "Hora Final" };
        boolean[] habilitados = new boolean[] { true, true, true, true };
        FieldPanel datosbasicos = new FieldPanel("DATOS", criterios, "", valores, habilitados);
        datosbasicos.getP().setVgap(10);
        datosbasicos.getP().setHgap(10);
        datosbasicos.getP().setAlignment(Pos.CENTER);
        VBox total = new VBox(tit, desc, datosbasicos.getP(), butons);
        total.setAlignment(Pos.CENTER);
        total.setSpacing(10);

        total.setPadding(new Insets(10));
        Scene edit = new Scene(total);

        Stage edit1 = new Stage();
        edit1.setScene(edit);
        edit1.setResizable(false);
        edit1.show();

        guardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert aviso = new Alert(AlertType.CONFIRMATION);
                aviso.setHeaderText(null);
                Asignatura asg = principal.sa.getAsignatura(datosbasicos.getValue("ASIGNATURA"));
                if (asg != null) {
                    String dia, h1, h2;
                    dia = datosbasicos.getValue("DIA");
                    h1 = datosbasicos.getValue("HORA INICIO");
                    h2 = datosbasicos.getValue("HORA FINAL");
                    if (checkHorario(dia, h1, h2, principal.sa)) {
                        principal.sa.addHorario(new Horario(dia, h1, h2, asg));
                        aviso.setContentText("Nueva Horario creado");
                        aviso.showAndWait();
                        edit1.close();
                    } else {
                        aviso.setAlertType(AlertType.ERROR);
                        aviso.setContentText("Horario invalido");
                        aviso.showAndWait();
                        datosbasicos.clean();
                    }
                } else {
                    aviso.setAlertType(AlertType.ERROR);
                    aviso.setContentText("Asignatura no encontrada");
                    aviso.showAndWait();
                    datosbasicos.clean();
                }
            }

        });

        cancelar.setOnAction(evento -> edit1.close());
    }

    public static void EditHorario(Horario h, Button b, GridPane panel) {
        Button guardar = new Button("GUARDAR");
        Button borrar = new Button("BORRAR");
        HBox butons = new HBox(guardar, borrar);
        butons.setSpacing(5);
        butons.setAlignment(Pos.CENTER);

        Label tit = new Label("EDITAR HORARIO");
        tit.setStyle("-fx-border-color: BLUE;");
        Label desc = new Label("AQUI PODRAS EDITAR EL HORARIO DE CLASE DE LA ASIGNATURA (FORMATO 24 HORAS)");
        desc.setStyle("-fx-border-color: BLUE;");

        String[] criterios = new String[] { "ASIGNATURA", "DIA", "HORA INICIO", "HORA FINAL" };
        String[] valores = new String[] { h.getAsignatString(), h.getDia(), h.getInicio(), h.getFinal() };
        boolean[] habilitados = new boolean[] { false, true, true, true };
        FieldPanel datosbasicos = new FieldPanel("DATOS", criterios, "", valores, habilitados);
        datosbasicos.getP().setVgap(10);
        datosbasicos.getP().setHgap(10);
        datosbasicos.getP().setAlignment(Pos.CENTER);
        VBox total = new VBox(tit, desc, datosbasicos.getP(), butons);
        total.setAlignment(Pos.CENTER);
        total.setSpacing(10);

        total.setPadding(new Insets(10));
        Scene edit = new Scene(total);

        Stage edit1 = new Stage();
        edit1.setScene(edit);
        edit1.setResizable(false);
        edit1.show();

        borrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                principal.sa.getHorarios().remove(h);
                panel.getChildren().remove(b);
                edit1.close();
            }
        });

        guardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert aviso = new Alert(AlertType.CONFIRMATION);
                aviso.setHeaderText(null);
                String dia, h1, h2;
                dia = datosbasicos.getValue("DIA");
                h1 = datosbasicos.getValue("HORA INICIO");
                h2 = datosbasicos.getValue("HORA FINAL");
                if (checkHorario(dia, h1, h2, principal.sa)) {
                    aviso.setContentText("Quiere guardar los cambios?");
                    Optional<ButtonType> result = aviso.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        h.setDia(dia);
                        h.setInicio(h1);
                        h.setFinal(h2);
                        aviso.setContentText("Nueva Horario creado");
                        aviso.showAndWait();
                        edit1.close();
                    }
                } else {
                    aviso.setAlertType(AlertType.ERROR);
                    aviso.setContentText("Horario invalido");
                    aviso.showAndWait();
                    datosbasicos.clean();
                }
            }
        });
    }
}
