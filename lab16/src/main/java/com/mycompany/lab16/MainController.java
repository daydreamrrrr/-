package com.mycompany.lab16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author hp
 */
public class MainController {

    private static final Pattern amountpattern1 = Pattern.compile("\\d+\\.\\d{2}");
    private static final Pattern amountpattern2 = Pattern.compile("[1-9]\\d*");
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private MenuItem saveButton;
    private String output;

    @FXML
    private void calculate() throws IOException {
        try {
            double x = readAmount(txt1);
            double y = Double.parseDouble(txt2.getText());
            double z = Double.parseDouble(txt3.getText());
            double profit = 0;
            for (int i = 0; i < z; i++) {
                double k = (x / 100) * y;
                profit += k;
                x = x + k;
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            output = decimalFormat.format(profit);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Результат");
            alert.setHeaderText(null);
            alert.setContentText("Дохід складатиме " + output + " гривень.");
            alert.showAndWait();
            saveButton.setDisable(false);
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Неправильний ввід");
            alert.showAndWait();
            saveButton.setDisable(true);
        }
    }

    private double readAmount(TextField field) throws Exception {
        String input = field.getText();
        if (amountpattern1.matcher(input).matches() || amountpattern2.matcher(input).matches()) {
            return Double.parseDouble(input);
        } else {
            throw new Exception();
        }
    }

    @FXML
    private void saveFile() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("saved file");
        try {
            File file = fc.showSaveDialog(null);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Cума (грн): " + txt1.getText());
            bw.newLine();
            bw.write("Річна ставка: " + txt2.getText() + "%");
            bw.newLine();
            bw.write("Строк (в місяцях): " + txt3.getText());
            bw.newLine();
            bw.write("Дохід (грн): " + output);
            bw.close();
            //file.createNewFile();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Помилка запису файлу");
            alert.showAndWait();
            saveButton.setDisable(true);
        }
    }

    @FXML
    private void showInfo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Довідка");
        alert.setHeaderText(null);
        alert.setContentText("Для обчислення суми доходу введіть необхідні дані.\n"
                + "Дробові числа слід вводити через крапку, наприклад: 12.5.");
        alert.showAndWait();
    }

    @FXML
    private void quit() {
        System.exit(0);
    }

}
