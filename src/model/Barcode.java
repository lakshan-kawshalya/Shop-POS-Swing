/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Vector;
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
class Barcode {

    public static void main(String[] args) {

        try {
            JasperReport jr = JasperCompileManager.compileReport("src/reports/barcode.jrxml");

            HashMap parameters = new HashMap();

            Vector v = new Vector();
            v.add(new X("254368"));
//            v.add(new X("154267"));
//            v.add(new X("428617"));
//            v.add(new X("932571"));
//            v.add(new X("528239"));

            JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(v);

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, datasource);

            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
