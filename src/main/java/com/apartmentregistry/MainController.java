package com.apartmentregistry;

import com.apartmentregistry.classes.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MainController {
    @FXML
    public MenuItem openFileButton;

    private HashMap<String, Room> monthData;
    private File currentFile;
    FileHandler fh = new FileHandler();

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
}