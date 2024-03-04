package com.example.calendariotest;
import atlantafx.base.controls.Calendar;
import atlantafx.base.theme.Styles;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.*;


public class HelloController{
    @FXML
    private Label welcomeText;

    @FXML
    private Calendar calendar;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void test(MouseEvent event){
        Set<LocalDate> projectDueDates = new HashSet<>();
        projectDueDates.add(LocalDate.now().plusDays(1)); // Ejemplo: entrega mañana



        System.out.println(calendar.getValue());
        // Personaliza las celdas del calendario

    }
    public void cargarData(){

        String cssFile = getClass().getResource("/styles.css").toExternalForm();
        calendar.getStylesheets().add(cssFile);
        calendar.setDayCellFactory(new Callback<Calendar, DateCell>() {
            @Override
            public DateCell call(Calendar param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        // Marca la fecha de mañana de rojo
                        if (item.equals(LocalDate.now().plusDays(60))) {
                            System.out.println("adios");
                            this.setStyle("-fx-background-color: #C1402E;"); // Tomate Rojo
                        }
                    }
                };
            }
        });
        /*
        String cssPart1 = ".calendar-grid {\n" +
                "    -fx-background-color: #1F1F1F;\n" +
                "    -fx-padding: 10;\n" +
                "    -fx-hgap: 5;\n" +
                "    -fx-vgap: 5;\n" +
                "    -fx-background-radius: 5;\n" +
                "}\n";
        String dataUri = Styles.toDataURI(cssPart1);
        calendar.getStylesheets().add(dataUri);

        String cssPart2 = ".calendar-grid > .date-cell {\n" +
                "    -fx-background-color: transparent;\n" +
                "    -fx-padding: 0;\n" +
                "    -fx-alignment: BASELINE_CENTER;\n" +
                "    -fx-opacity: 1.0;\n" +
                "    -fx-text-fill: #000000;\n" +
                "    -fx-cell-size: 40;\n" +
                "    -fx-font-size: 12;\n" +
                "}\n";

        String dataUri1 = Styles.toDataURI(cssPart2);
        calendar.getStylesheets().add(dataUri1);

        String cssPart3 = ".calendar-grid > .week-number-cell {\n" +
                "    -fx-padding: 2 5 2 5;\n" +
                "    -fx-background-color: #dddddd;\n" +
                "    -fx-text-fill: #333333;\n" +
                "    -fx-font-size: 12;\n" +
                "}\n";

        String dataUri2= Styles.toDataURI(cssPart3);
        calendar.getStylesheets().add(dataUri2);

        // fondo de cada celda
        String cssPart4 = ".calendar-grid > .day-cell {\n" +
                "    -fx-padding: 2 5 2 5;\n" +
                "    -fx-background-color: #1F1F1F;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-border-width: 0;\n" +
                "    -fx-border-color: transparent;\n" +
                "    -fx-border-radius: white;\n" +
                "}\n";

        String dataUri3 = Styles.toDataURI(cssPart4);
        calendar.getStylesheets().add(dataUri3);



        String cssPart6 = ".calendar-grid > .hijrah-day-cell {\n" +
                "    -fx-alignment: TOP_LEFT;\n" +
                "    -fx-padding: 2;\n" +
                "    -fx-cell-size: 30;\n" +
                "}\n";

        String dataUri5 = Styles.toDataURI(cssPart6);
        calendar.getStylesheets().add(dataUri5);

        String cssPart7 = ".calendar-grid > .today {\n" +
                "    -fx-background-color: gray;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-weight: bold;\n" +
                "}\n";

        String dataUri6 = Styles.toDataURI(cssPart7);
        calendar.getStylesheets().add(dataUri6);

        String cssPart8 = ".date-picker-popup>.calendar-grid>.day-cell:hover {\n" +
                "  -fx-background-color: blue;\n" +
                "  -fx-text-fill: white;\n" +
                "}";

        String dataUri7 = Styles.toDataURI(cssPart8);
        calendar.getStylesheets().add(dataUri7);

        String cssPart9 = ".date-picker-popup>.calendar-grid>.selected,\n" +
                ".date-picker-popup>.calendar-grid>.selected>.secondary-text,\n" +
                ".date-picker-popup>.calendar-grid>.previous-month.selected,\n" +
                ".date-picker-popup>.calendar-grid>.previous-month.today.selected,\n" +
                ".date-picker-popup>.calendar-grid>.next-month.today.selected,\n" +
                ".date-picker-popup>.calendar-grid>.next-month.selected {\n" +
                "  -fx-background-color: #3CA57C;\n" +
                "  -fx-text-fill: white;\n" +
                "  -fx-fill: -color-date-day-fg-selected;\n" +
                "  -fx-font-weight: normal;\n" +
                "}";

        String dataUri8 = Styles.toDataURI(cssPart9);
        calendar.getStylesheets().add(dataUri8);

        String datePickerPopupCss = ".date-picker-popup {\n" +
                "    -fx-background-color: #1F1F1F;\n" + // Color blanco de fondo asumiendo que es lo que significa -color-date-border
                "    -fx-background-insets: 0, 1;\n" +
                "    -fx-background-radius: 5, 4;\n" + // Asumiendo que cfg.$border-radius es 5 y cfg.$inner-border-radius es 4
                "    -fx-alignment: CENTER;\n" +
                "    -fx-spacing: 0;\n" +
                "    -fx-padding: 1;\n" + // Asumiendo que cfg.$border-width es 1
                "}";

        String a = Styles.toDataURI(datePickerPopupCss);
        calendar.getStylesheets().add(a);

        String monthYearPaneCss = ".date-picker-popup > .month-year-pane {\n" +
                "    -fx-padding: 10 5 10 5;\n" + // Asumiendo valores de ejemplo para $content-padding-y y $content-padding-x
                "    -fx-background-color: #1F1F1F;\n" + // Un color gris claro para el fondo del área del mes y año
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-background-radius: 5 5 0 0;\n" + // Asumiendo que cfg.$border-radius es 5
                "}";

        String b = Styles.toDataURI(monthYearPaneCss);
        calendar.getStylesheets().add(b);



        String spinnerCss = ".date-picker-popup > .month-year-pane > .spinner {\n" +
                "    -fx-spacing: 4;\n" +
                "    -fx-alignment: CENTER;\n" +
                "    -fx-fill-height: false;\n" +
                "    -fx-background-color: transparent;\n" +
                "    -fx-border-color: transparent;\n" +
                "    -fx-font-size: 12;\n" + // Asumiendo un tamaño de fuente de 12px para $month-year-font-size
                "}";

        String buttonCss = ".date-picker-popup > .month-year-pane > .spinner > .button {\n" +
                "    -fx-background-color: transparent;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-background-radius: 0;\n" +
                "    -fx-cursor: hand;\n" +
                "}";

        String arrowButtonCss = ".date-picker-popup > .month-year-pane > .spinner > .button > .left-arrow, " +
                ".date-picker-popup > .month-year-pane > .spinner > .button > .right-arrow {\n" +
                "    -fx-background-color: #333333;\n" + // Asumiendo un color gris oscuro para las flechas
                "}";

        String labelCss = ".label {\n" +
                "        -fx-alignment: CENTER;\n" +
                "        -fx-text-fill: white;\n" +
                "        -fx-padding: 5;\n" +
                "      }";
        String c = Styles.toDataURI(labelCss);
        calendar.getStylesheets().add(c);

        String secondaryLabelCss = ".date-picker-popup > .month-year-pane > .secondary-label {\n" +
                "    -fx-alignment: BASELINE_CENTER;\n" +
                "    -fx-padding: 5 0 0 0;\n" + // Asumiendo un valor de 5px para el margen superior ($chrono-label-margin)
                "    -fx-text-fill: #333333;\n" + // Asumiendo un color gris oscuro para el texto
                "}";

         */
    }
}