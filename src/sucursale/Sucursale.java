/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursale;

import art.creativity.entities.identities.Abonne;
import art.creativity.process.Background;
import art.creativity.process.Config;
import art.creativity.process.HttpRequest;
import javax.swing.JFrame;
//import com.sun.comm.Win32Driver;
//import gnu.io.CommPortIdentifier;
//import java.util.Enumeration;
import swing.Information;
import swing.Login;

/**
 *
 * @author Geraud
 */
public class Sucursale implements Background.Backend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Background background = new Background(new Background.Backend() {
//
//            @Override
//            public void secourAbonne(Abonne abonne) {
//                System.out.println("Abonne");
//                Information indo = new Information(abonne);
//                JFrame frame = new JFrame("Aide");
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frame.getContentPane().add(indo);
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//                System.out.println("show");
//            }
//        });
//        background.start();
        /*Config config = Config.getConfig("sossou", "citech_sossou", "http://enovatechnologie.com/Sucursale/abonneMC?mc=65139699");
        HttpRequest httpRequest = new HttpRequest(config);
        httpRequest.send("GET", "", "");
        System.out.println(""+httpRequest.send("GET", "", ""));*/

////initialisation du driver
//Win32Driver w32Driver= new Win32Driver();
//w32Driver.initialize();
////récupération de l'énumération
//Enumeration portList=CommPortIdentifier.getPortIdentifiers();
////affichage des noms des ports
//CommPortIdentifier portId;
//while (portList.hasMoreElements()){
//	portId=(CommPortIdentifier)portList.nextElement();
//	System.out.println(portId.getName());
//}
          /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    @Override
    public void secourAbonne(Abonne abonne) {
        Information indo = new Information(abonne);
        JFrame frame = new JFrame("Aide");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(indo);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("show");
    }

}
