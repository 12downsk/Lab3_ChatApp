package client;

import server.*;
import java.rmi.*;
import java.util.Calendar;
import java.util.LinkedList;

public class Client {

    StockServerInterface server;
    String username;
    ConnectFrame connectframe;
    ClientFrame clientframe;
    int recent_message;
    
    public void init(){
        connectframe=new ConnectFrame(this);
        connectframe.setVisible(true);
    }

    public void connect(String username, String ip_address, Calendar date) {
        try {
            server = (StockServerInterface) Naming.lookup("rmi://" + ip_address + "/StockService");
            this.username = username;
            this.connectframe.setVisible(false);
            clientframe=new ClientFrame(this);
            this.clientframe.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public double[] get_new_messages() {
         try {
            return server.get_new_message(recent_message);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }       
    }
    
    
}
