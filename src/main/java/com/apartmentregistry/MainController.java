package com.apartmentregistry;

import com.apartmentregistry.classes.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public MenuItem openFileButton;
    public ChoiceBox<String> monthBar;
    public ListView<String> listView;
    public Button submitButton;
    public TextField roomIdField;
    public TextField tenantField;

    private HashMap<String, ArrayList<Room>> monthDirectory = new HashMap<>();
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private File currentFile;
    FileHandler fh = new FileHandler();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (String month : months)
            monthDirectory.put(month, new ArrayList<>());
        monthBar.getItems().addAll(months);
        monthBar.setOnAction(this::monthMenuClick);
    }

    public void openFilePressed(ActionEvent actionEvent) throws IOException {
        currentFile = fh.loadFile();

        if (currentFile.length() == 0) {
            FileWriter fileWriter = new FileWriter(currentFile);
            fileWriter.write("January\n\n" +
                    "February\n\n" +
                    "March\n\n" +
                    "April\n\n" +
                    "May\n\n" +
                    "June\n\n" +
                    "July\n\n" +
                    "August\n\n" +
                    "September\n\n" +
                    "October\n\n" +
                    "November\n\n" +
                    "December");
            fileWriter.close();


        }
    }

    public void monthMenuClick(ActionEvent event) {
        refreshList();
    }

    public void refreshList() {
        listView.getItems().clear();
        ArrayList<Room> rooms = monthDirectory.get(monthBar.getValue());
        for (Room room : rooms) {
            listView.getItems().add(room.getRoomId() + " : " + room.getAttendant());
        }
    }

    public void submitPressed(ActionEvent actionEvent) {
        if (!roomIdField.getText().isEmpty() && !tenantField.getText().isEmpty()) {
            monthDirectory.get(monthBar.getValue()).add(new Room(Integer.parseInt(roomIdField.getText()), tenantField.getText()));
        }
        refreshList();
    }
}