package main.java.actions;

import javafx.event.Event;
import javafx.event.EventHandler;
import main.java.controller.Controllers;
import main.java.model.Document;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Launches a file import dialog.
 * Can be called from multiple sources, in contrast to anon inner classes which need to be rewritten for each usage.
 *
 * Gets a file from a file chooser and sends the file to the document handler to import.
 */
public class ExportFileDialogAction implements EventHandler {

    Document docToExport;
    File toWrite;

    public ExportFileDialogAction(Document docToExport) {
        this.docToExport = docToExport;
    }

    @Override
    public void handle(Event event) {
        JFileChooser fileToExportDialog = new JFileChooser();


        int openedFile = fileToExportDialog.showSaveDialog(null);
        if(openedFile == JFileChooser.APPROVE_OPTION) {
            toWrite = fileToExportDialog.getSelectedFile();
        }
        try {
			Controllers.documentHandler.exportDocument(docToExport, toWrite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
