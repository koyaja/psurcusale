/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucursale;

/**
 *
 * @author KOYAJA21
 */
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class projettut {

    SerialPort serialPort;
    OutputStream out;
    char entre = 13;
    char controle = 26;
    char comila = 34;
    int len;
    String text;
    byte[] buffer = new byte[1024];

    public projettut() {
        super();
    }
//connexion au port:

    void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
//générer une liste des ports disponibles. Elle choisit ensuite un port dans la liste et appelle
// CommPortIdentifier.open pour créer un objet CommPort qui est casté ensuite en SerialPort.

        if (portIdentifier.isCurrentlyOwned()) // si le port est deja connecté
        {
            System.out.println("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

            if (commPort instanceof SerialPort) {
//si le port est présent mais pas connecté
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                in = serialPort.getInputStream();
                out = serialPort.getOutputStream();
                out.write(("AT+CBC" + entre).getBytes());
                // out.write("AT+CPIN=\"0000\"".getBytes());

                lecture();
                System.out.println("code " + text);
                // (new Thread(new SerialReader(in))).start();
                // (new Thread(new SerialWriter(out))).start();
                out.write("AT+CMGF=1\r".getBytes());
                lecture();
                System.out.println("Ative message " + text + "");
                out.write("AT+CMGL=\"ALL\"\r".getBytes());
                lecture();
                System.out.println("Affiche tous les message " + text.toString());
                serialPort.addEventListener((SerialPortEvent spe) -> {
                    SerialPort port = (SerialPort) spe.getSource();
                });
                serialPort.close();
            } else // si le port n'est pas présent
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
    }
    InputStream in;

    /**
     *
     */
    void lecture() {

        try {
            in = serialPort.getInputStream();
            len = in.read(buffer);
            text = new String(buffer, 0, len);
            System.out.println("rst " + text + " fnr");
        } catch (IOException ex) {
            Logger.getLogger(projettut.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static class SerialReader implements Runnable {

        InputStream in;

        public SerialReader(InputStream in) {
            this.in = in;
        }

        public void run() {
            byte[] buffer = new byte[1024];
            int len = -1;
            try {
                while ((len = this.in.read(buffer)) > -1) {
                    System.out.print(new String(buffer, 0, len));//tampon
                    //https://en.wikibooks.org/wiki/Serial_Programming/Serial_Java
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    public static class SerialWriter implements Runnable {

        OutputStream out;

        public SerialWriter(OutputStream out) {
            this.out = out;
        }

        public void run() {
            try {
                int c = 0;
                while ((c = System.in.read()) > -1) {
                    this.out.write(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            (new projettut()).connect("COM8");
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

/**
 * Listen to port events
 */
