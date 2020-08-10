import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


public class FinalCalc extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 360, 500);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ArrayList<Double> termGrades = new ArrayList<>();
        ArrayList<String> terms = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ComboBox<String> numberOfTerms = new ComboBox<>();
        numberOfTerms.setPrefWidth(150);
        numberOfTerms.getItems().addAll(terms);
        numberOfTerms.getSelectionModel().selectFirst();
        gridPane.add(numberOfTerms, 5, 2, 1, 1);

        Button clear = new Button();
        clear.setAlignment(Pos.BASELINE_CENTER);
        clear.setText("Clear");
        clear.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
        gridPane.add(clear, 1, 12, 3, 1);

        Button calculate = new Button();
        calculate.setAlignment(Pos.BASELINE_CENTER);
        calculate.setText("Calculate");
        calculate.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
        gridPane.add(calculate, 5, 12, 1, 1);

        Label total_term_weight = new Label();
        total_term_weight.setAlignment(Pos.TOP_LEFT);
        total_term_weight.setText("  Total Term Weight");
        total_term_weight.setStyle("-fx-padding: 5px;");
        gridPane.add(total_term_weight, 0, 0, 1, 1);

        Label final_weight = new Label();
        final_weight.setAlignment(Pos.TOP_LEFT);
        final_weight.setText("  Final Weight");
        final_weight.setStyle(" -fx-padding: 5px;");
        gridPane.add(final_weight, 0, 1, 1, 1);

        Label number_of_terms = new Label();
        number_of_terms.setAlignment(Pos.TOP_LEFT);
        number_of_terms.setText("  Number Of Terms");
        number_of_terms.setStyle(" -fx-padding: 5px;");
        gridPane.add(number_of_terms, 0, 2, 1, 1);

        Label grade_wanted = new Label();
        grade_wanted.setAlignment(Pos.TOP_LEFT);
        grade_wanted.setText("  Grade Wanted");
        grade_wanted.setStyle(" -fx-padding: 5px;");
        gridPane.add(grade_wanted, 0, 3, 1, 1);

        TextField termWeight = new TextField();
        termWeight.setText("85");
        gridPane.add(termWeight, 5, 0, 1, 1);

        TextField finalWeight = new TextField();
        finalWeight.setText("15");
        gridPane.add(finalWeight, 5, 1, 1, 1);

        TextField gradeWanted = new TextField();
        gradeWanted.setText("90");
        gridPane.add(gradeWanted, 5, 3, 1, 1);

        TextField termOne = new TextField();
        termOne.setStyle("-fx-opacity: 1.0;");
        termOne.setDisable(false);
        gridPane.add(termOne, 5, 6, 1, 1);

        TextField termTwo = new TextField();
        termTwo.setStyle("-fx-opacity: 0.5;");
        termTwo.setDisable(true);
        gridPane.add(termTwo, 5, 7, 1, 1);

        TextField termThree = new TextField();
        termThree.setStyle("-fx-opacity: 0.5;");
        termThree.setDisable(true);
        gridPane.add(termThree, 5, 8, 1, 1);

        TextField termFour = new TextField();
        termFour.setStyle("-fx-opacity: 0.5;");
        termFour.setDisable(true);
        gridPane.add(termFour, 5, 9, 1, 1);

        TextField termFive = new TextField();
        termFive.setStyle("-fx-opacity: 0.5;");
        termFive.setDisable(true);
        gridPane.add(termFive, 5, 10, 1, 1);

        Label term_one = new Label();
        term_one.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
        term_one.setDisable(false);
        term_one.setText("  Term One");
        gridPane.add(term_one, 0, 6);

        Label term_two = new Label();
        term_two.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
        term_two.setDisable(false);
        term_two.setText("  Term Two");
        gridPane.add(term_two, 0, 7);

        Label term_three = new Label();
        term_three.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
        term_three.setDisable(false);
        term_three.setText("  Term Three");
        gridPane.add(term_three, 0, 8);

        Label term_four = new Label();
        term_four.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
        term_four.setDisable(false);
        term_four.setText("  Term Four");
        gridPane.add(term_four, 0, 9);

        Label term_five = new Label();
        term_five.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
        term_five.setDisable(false);
        term_five.setText("  Term Five");
        gridPane.add(term_five, 0, 10);

        Label final_grade_needed = new Label();
        final_grade_needed.setStyle(" -fx-padding: 5px -fx-text-box-border: transparent;");
        final_grade_needed.setText("    Grade Needed:");
        final_grade_needed.setPrefWidth(360);
        gridPane.add(final_grade_needed, 0, 15, 5, 1);


        EventHandler handler = event -> {
            Button button = (Button) event.getSource();
            if (finalWeight.getText().isEmpty() || termWeight.getText().isEmpty() || gradeWanted.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Missing Data Fields").showAndWait();
            } else {
                double x = Double.parseDouble(termWeight.getText());
                double y = Double.parseDouble(finalWeight.getText());
                if (button.getText().equals("Calculate") && x + y == 100.0) {
                    if (numberOfTerms.getSelectionModel().getSelectedItem().equals("1") && termOne.getText().isEmpty()) {
                        new Alert(Alert.AlertType.ERROR, "Missing Data Fields").showAndWait();
                    } else if (numberOfTerms.getSelectionModel().getSelectedItem().equals("2") && (termOne.getText().isEmpty() || termTwo.getText().isEmpty())) {
                        new Alert(Alert.AlertType.ERROR, "Missing Data Fields").showAndWait();
                    } else if (numberOfTerms.getSelectionModel().getSelectedItem().equals("3") && (termOne.getText().isEmpty() || termTwo.getText().isEmpty() || termThree.getText().isEmpty())) {
                        new Alert(Alert.AlertType.ERROR, "Missing Data Fields").showAndWait();
                    } else if (numberOfTerms.getSelectionModel().getSelectedItem().equals("4") && (termOne.getText().isEmpty() || termTwo.getText().isEmpty() || termFour.getText().isEmpty() || termThree.getText().isEmpty())) {
                        new Alert(Alert.AlertType.ERROR, "Missing Data Fields").showAndWait();
                    } else if (numberOfTerms.getSelectionModel().getSelectedItem().equals("5") && (termOne.getText().isEmpty() || termTwo.getText().isEmpty() || termThree.getText().isEmpty() || termFour.getText().isEmpty() || termFive.getText().isEmpty())) {
                        new Alert(Alert.AlertType.ERROR, "Missing Data Fields").showAndWait();
                    } else {
                        double weightTerm = Double.parseDouble(termWeight.getText());
                        double weightFinal = Double.parseDouble(finalWeight.getText());
                        double gradeWant = Double.parseDouble(gradeWanted.getText());
                        if (!termFive.getText().isEmpty()) {
                            termGrades.add(Double.parseDouble(termFive.getText()));
                        }
                        if (!termFour.getText().isEmpty()) {
                            termGrades.add(Double.parseDouble(termFour.getText()));
                        }
                        if (!termThree.getText().isEmpty()) {
                            termGrades.add(Double.parseDouble(termThree.getText()));
                        }
                        if (!termTwo.getText().isEmpty()) {
                            termGrades.add(Double.parseDouble(termTwo.getText()));
                        }
                        if (!termOne.getText().isEmpty()) {
                            termGrades.add(Double.parseDouble(termOne.getText()));
                        }

                        if (Integer.parseInt(numberOfTerms.getValue()) == termGrades.size()) {
                            double semesterGrade = semAverage(termGrades);
                            String gradeYouNeed = gradeNeeded(weightFinal, semesterGrade, gradeWant, weightTerm);
                            final_grade_needed.setText("    Grade Needed: " + gradeYouNeed);
                        }
                        termGrades.clear();
                    }


                } else if (button.getText().equals("Clear")) {
                    termGrades.clear();
                    termFive.clear();
                    termFour.clear();
                    termThree.clear();
                    termTwo.clear();
                    termOne.clear();
                    x = 0.0;
                    y = 0.0;
                } else if (x + y != 100.0) {
                    new Alert(Alert.AlertType.ERROR, "Final weight and term weight do not equal 100").showAndWait();
                }
            }


        };

        termWeight.setOnAction(handler);
        finalWeight.setOnAction(handler);
        gradeWanted.setOnAction(handler);
        calculate.setOnAction(handler);
        clear.setOnAction(handler);

        numberOfTerms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {

            if (newValue.equals("1")) {
                termOne.setDisable(false);
                termOne.setStyle("-fx-opacity: 1.0;");
                term_one.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termTwo.setDisable(true);
                termTwo.setStyle("-fx-opacity: 0.5;");
                termTwo.setText("");
                term_two.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termThree.setDisable(true);
                termThree.setStyle("-fx-opacity: 0.5;");
                termThree.setText("");
                term_three.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFour.setDisable(true);
                termFour.setStyle("-fx-opacity: 0.5;");
                term_four.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFour.setText("");
                termFive.setDisable(true);
                termFive.setStyle("-fx-opacity: 0.5;");
                term_five.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFive.setText("");
                ;
            } else if (newValue.equals("2")) {
                termOne.setDisable(false);
                termOne.setStyle("-fx-opacity: 1.0;");
                term_one.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termTwo.setDisable(false);
                termTwo.setStyle("-fx-opacity: 1.0;");
                term_two.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termThree.setDisable(true);
                termThree.setStyle("-fx-opacity: 0.5;");
                term_three.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termThree.setText("");
                termFour.setDisable(true);
                termFour.setStyle("-fx-opacity: 0.5;");
                term_four.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFour.setText("");
                termFive.setDisable(true);
                termFive.setStyle("-fx-opacity: 0.5;");
                term_five.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFive.setText("");
                ;
            } else if (newValue.equals("3")) {
                termOne.setDisable(false);
                termOne.setStyle("-fx-opacity: 1.0;");
                term_one.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termTwo.setDisable(false);
                termTwo.setStyle("-fx-opacity: 1.0;");
                term_two.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termThree.setDisable(false);
                termThree.setStyle("-fx-opacity: 1.0;");
                term_three.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termFour.setDisable(true);
                termFour.setStyle("-fx-opacity: 0.5;");
                termFour.setText("");
                term_four.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFive.setDisable(true);
                termFive.setStyle("-fx-opacity: 0.5;");
                term_five.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
                termFive.setText("");
                ;
            } else if (newValue.equals("4")) {
                termOne.setDisable(false);
                term_one.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termOne.setStyle("-fx-opacity: 1.0;");
                termTwo.setDisable(false);
                termTwo.setStyle("-fx-opacity: 1.0;");
                term_two.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termThree.setDisable(false);
                termThree.setStyle("-fx-opacity: 1.0;");
                term_three.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termFour.setDisable(false);
                termFour.setStyle("-fx-opacity: 1.0;");
                term_four.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termFive.setDisable(true);
                termFive.setStyle("-fx-opacity: 0.5;");
                termFive.setText("");
                term_five.setStyle("; -fx-padding: 5px;-fx-opacity: 0.5;");
            } else if (newValue.equals("5")) {
                termOne.setDisable(false);
                termOne.setStyle("-fx-opacity: 1.0;");
                term_one.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termTwo.setDisable(false);
                termTwo.setStyle("-fx-opacity: 1.0;");
                term_two.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termThree.setDisable(false);
                termThree.setStyle("-fx-opacity: 1.0;");
                term_three.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termFour.setDisable(false);
                termFour.setStyle("-fx-opacity: 1.0;");
                term_four.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
                termFive.setDisable(false);
                termFive.setStyle("-fx-opacity: 1.0;");
                term_five.setStyle("; -fx-padding: 5px;-fx-opacity: 1.0;");
            }
        });

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Adeeb Ismail");

    }

    public String gradeNeeded(double finalWeight, double semesterGrade, double gradeWanted, double termWeight) {

        double grade = ((gradeWanted - (semesterGrade * (termWeight / 100))) / (finalWeight / 100));
        return Double.toString(grade);
    }

    public double semAverage(ArrayList termScores) {
        double termGrade = 0.0;
        for (int i = 0; i < termScores.size(); i++) {
            termGrade += (double) termScores.get(i);
        }
        termGrade = termGrade / termScores.size();
        return termGrade;
    }


}

