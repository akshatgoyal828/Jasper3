package sample;


import javafx.fxml.FXMLLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

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
        String sourceFileName = "C:\\Users\\hp\\IdeaProjects\\Jasper3\\src\\sample\\employee3.jrxml";
        System.out.println("Compiling Report Design ...");
        try {
            //Compiling the jrxml
             jasperReport =  JasperCompileManager.compileReportToFile(sourceFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }
        System.out.println("Compilation Done!!! ...");
        //JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(),ConnectionUtil.con();
        JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(),ConnectionUtil.conDB());
        String query = "select * from employee";
        
        JasperViewer.viewReport(print, false);
        try {
            OutputStream os = new FileOutputStream( new File( "\\reports"));
            JasperExportManager.exportReportToPdfStream(print, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}