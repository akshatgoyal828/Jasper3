package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Main  {

    private FXMLLoader loader;
    private String query;
    static String jasperReport;
    private Connection connect;
    private static Map<String, Object> map;
    private boolean EDIT = false;
    private boolean ADD = true;
    private int ID;



    public static void main(String[] args) throws JRException {
        /*database = new DBConnection();
        connect = database.getConnection();*/
        map = new HashMap();
        String sourceFileName = "C:\\Users\\hp\\IdeaProjects\\Jasper3\\src\\sample\\employee.jrxml";
        System.out.println("Compiling Report Design ...");
        try {
            //Compiling the jrxml
             jasperReport =  JasperCompileManager.compileReportToFile(sourceFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }
        System.out.println("Compilation Done!!! ...");


    }
}