package art.creativity.process;

import art.creativity.entities.identities.Abonne;
import art.creativity.interfaces.ISerialGSM;
import art.creativity.interfaces.SerialGSM;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Background extends Thread implements ISerialGSM {

    private SerialGSM gsm;
    private String port = "COM23";
    private boolean wait = false;
    private boolean run = true;
    private Config config;
    private HttpRequest httpRequest;
    private Backend backend;
    private List<String> messages = new ArrayList<>();
    private boolean nouveau = true;
    private boolean att = false;

    public Background(Backend backend) {
        gsm = new SerialGSM(this, port);
        config = Config.getConfig("sossou", "citech_sossou", "http://enovatechnologie.com/Sucursale/abonneMC?mc=95391814");
        httpRequest = new HttpRequest(config);
        this.backend = backend;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        gsm.initialize();
//        try {
//            //att=true;
//            gsm.write(("AT"+"\r\n").getBytes());
//            
//            Thread.sleep(100);
//            //while(att){}
//            //att=true;
//            gsm.write(("AT+CMGF=1" + "\r\n").getBytes());
//            Thread.sleep(100);
//            //while(att){}
//        } catch (IOException ex) {
//            Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
//        }
        while (run) {
            /*if (!wait) {
                try {
                    gsm.write("AT+CMGL=\"ALL\"");
                    wait = true;
                    Thread.sleep(500);
                } catch (IOException ex) {
                } catch (InterruptedException ex) {
                }
            }*/
        }
    }
    
    private int id = -1;

    @Override
    public void reciever(String read) {
        
        System.out.println("read = "+read);
        if(read.contains("CMTI")){
            System.out.println("id containts ");
            String r = read;
            r = r.substring(read.indexOf(",")+1).trim();
            System.out.println("r="+r);
            id = Integer.parseInt(r.trim());
            System.out.println("id = "+id);
            try {
                Thread.sleep(500);
                gsm.write("AT+cmgr=" +id+"\r\n");
                //gsm.write("AT+CMGL=\"ALL\""+"\r\n");
            } catch (Exception ex) {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*if (read.contains("+229")) {
            System.out.println(read);
            if (!messages.contains(read)) {
                messages.add(read);
                read = read.substring(read.indexOf("+229"));
                String num = read.substring(0, read.indexOf("\""));
                System.out.println("new num = " + num);
                //Abonne a = formatgson(num);
                //backend.secourAbonne(a);
                if(nouveau){
                    System.out.println("nouveau");
                    Abonne a = new Abonne();
                    a.setNom("ZANNOU");
                    a.setPrenom("Géraud");
                    a.setNumeroAB(22995391814L);
                    a.setAdres("Calavi Zopah");
                    a.setTel("66647946");
                    backend.secourAbonne(a);
                    nouveau=false;
                }
            }

        }*/
        
        
        
        if(id!=-1){
            if (read.contains("+CMGR: \"REC UNREAD\"")) {
                System.out.println(read);
                if (!messages.contains(read)) {
                    messages.add(read);
                    read = read.substring(read.indexOf("+229")+4);
                    String num = read.substring(0, read.indexOf("\""));
                    System.out.println("new num = " + num);
                    Abonne a = formatgson(num);
                    backend.secourAbonne(a);
                    /*if(nouveau){
                        System.out.println("nouveau");
                        Abonne a = new Abonne();
                        a.setNom("ZANNOU");
                        a.setPrenom("Géraud");
                        a.setNumeroAB(22995391814L);
                        a.setAdres("Calavi Zopah");
                        a.setTel("66647946");
                        backend.secourAbonne(a);
                        nouveau=false;
                    }*/
                }
                
                id = -1;

            }
        }
        
        if(wait){
            if(read=="OK"){
                wait = false;
                System.out.println("wait = false");
            }
        }

    }

    @Override
    public void error(String read) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Abonne formatgson(String numero) {
        GsonBuilder buld = new GsonBuilder();
        Gson gson = buld.create();
        httpRequest.setUrl("http://enovatechnologie.com/Sucursale/abonneMC?mc="+numero);
        String recp = httpRequest.send("GET", "", "");
        System.out.println(recp);
        List<Abonne> abonnes = gson.fromJson(recp, new TypeToken<List<Abonne>>(){}.getType());
        return abonnes.get(0);

    }

    public interface Backend {

        void secourAbonne(Abonne abonne);
    }
}
