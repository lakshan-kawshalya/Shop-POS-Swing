/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LAKSHAN KAWSHALYA
 */
public class A {

    public static void main(String[] args) {

        try {
            String filepath = "src//reports//test1.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(filepath);

            HashMap parameters = new HashMap();
            
            Connection datasource = MySQL.getConnection();
            
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);

            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
