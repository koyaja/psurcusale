/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.creativity.interfaces;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import swing.Hide;

/**
 *
 * @author Geraud
 */
public class SerialGSM implements SerialPortEventListener {

    SerialPort serialPort;
    private ISerialGSM reader;
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM16", // Windows
        "COM15", // Windows
    };
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private static DataOutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 19200;
    private String port = "COM15";

    static String messageString1 = "AT";
    static String messageString3 = "AT+CMGF=1";

    public static char enter = 13;

    static char CTRLZ = 26;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public SerialGSM(ISerialGSM reader, String port) {
        super();
        this.port = port;
        this.reader = reader;
        // TODO Auto-generated constructor stub
        /*try {
            //System.loadLibrary("rxtxSerial");
            //System.load(getClass().getResource("/rxtxSerial64.dll").getPath().substring(1));
            String path = getClass().getResource("/dll/rxtxSerial.dll").getPath();
            path = java.net.URLDecoder.decode(path);
            System.out.println(path);
            System.load(path);

        } catch (UnsatisfiedLinkError ex) {
//	         System.err.println("Native code library failed to load.\n" + ex);
            throw new UnsatisfiedLinkError(ex.toString());
        }*/
    }

    public void initialize() {
        //System.setProperty("gnu.io.rxtx.SerialPorts", port);

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            System.err.println("ffff" + currPortId.getName());
            Hide.connect+=currPortId.getName();
            if (currPortId.getName().equals(port)) {
                portId = currPortId;
                break;
            }
            /*for (String portName : PORT_NAMES) {
             //System.out.println("port : "+currPortId.getName());
             if (currPortId.getName().equals(portName)) {
             portId = currPortId;
             break;
             }
             }*/
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //serialPort.setBaudBase(9600);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = new DataOutputStream(serialPort.getOutputStream());

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            output.write((messageString1 + enter).getBytes());

            Thread.sleep(100);

            output.write((messageString3 + enter).getBytes());

            Thread.sleep(100);

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public void write(String message) throws IOException {
        System.out.println("message send = "+message);
        if (output == null) {
            return;
        }
        try {        
            output.write("AT".getBytes());
            output.write('\r');
            Thread.sleep(1000);
            
            output.write((message).getBytes());
            output.write('\r');
            //output.flush();
            Thread.sleep(1000);
        } catch (Exception ex) {
            Logger.getLogger(SerialGSM.class.getName()).log(Level.SEVERE, null, ex);
        }
        //output.flush();
        System.err.println("send");
    }

    //+CMTI:

    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        System.out.println(oEvent.getEventType());
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                if (reader != null) {
                    reader.reciever(inputLine);
                }
                System.out.println(inputLine);
            } catch (Exception e) {
                reader.error(e.getMessage());
            }
        }
    }

}
