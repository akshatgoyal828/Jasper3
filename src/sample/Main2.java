package sample;


import javafx.fxml.FXMLLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.*;
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


    public static void mainTemp(String[] args) throws JRException {

        ;
        String sourceFileName = "C:\\Users\\hp\\IdeaProjects\\Jasper3\\src\\sample\\employee.jrxml";
        System.out.println("Compiling Report Design ...");
        try {
            //Compiling the jrxml
            jasperReport = JasperCompileManager.compileReportToFile(sourceFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }
        System.out.println("Compilation Done!!! ...");

        try {
            InputStream in = new FileInputStream(new File("C:\\Users\\hp\\IdeaProjects\\Jasper3\\src\\sample\\employee.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = " select * from employee";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            HashMap para = new HashMap();
            JasperPrint j = JasperFillManager.fillReport(jr, para, ConnectionUtil.conDB());
            JasperViewer.viewReport(j, false);
            OutputStream os = new FileOutputStream(new File("C:\\Users\\hp\\IdeaProjects\\Jasper3\\src\\sample\\abc.pdf"));
            JasperExportManager.exportReportToPdfStream(j, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws JRException{
        //Report2.printEmployee();
        //Report2.printparking();
        //Report2.printVisitor();
        Report2.printInvoice();
    }
}