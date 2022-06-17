package com.apartmentregistry;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    private FileChooser fc = new FileChooser();

    public File loadFile() {
        fc.setTitle("Load");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files \".txt\"", "*.txt"));
        return fc.showOpenDialog(null);
    }

    /*
    public void newFile() throws IOException {
        fc.setTitle("New File");
        fc.setInitialFileName("apt");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files \".txt\"", "*.txt"));
        File newFile = fc.showOpenDialog(null);
        newFile.createNewFile();
    }
     */

}
