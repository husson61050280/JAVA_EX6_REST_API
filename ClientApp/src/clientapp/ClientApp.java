/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;

import java.io.StringReader;
import java.util.Scanner;
import javax.xml.bind.JAXB;
import util.ServiceJerseyClient;

/**
 *
 * @author Rungroj
 */
public class ClientApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.print("Enter raduis to find Area and Circumference = ");
       Scanner scan = new Scanner(System.in);
       String raduis = scan.next();
       ServiceJerseyClient obj = new ServiceJerseyClient();
       String xml_Area = obj.getXml_AreaCircle(raduis);
       String xml_Circumference = obj.getXml_Circumference_Circle(raduis);
       String Area_String = (String) JAXB.unmarshal(new StringReader(xml_Area), String.class);
       String Circumference_String = (String) JAXB.unmarshal(new StringReader(xml_Circumference), String.class);
       System.out.println("Area = " + Area_String);
       System.out.println("Circumference = " + Circumference_String);
    }
    
}
