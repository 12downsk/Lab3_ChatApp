package client;

import server.*;
import java.rmi.*;
import java.util.Calendar;


public class Client {

    ChatServerInterface server;
    String username;
    ConnectFrame connectframe;
    ClientFrame clientframe;
    int lastMsgRecived;

    public void init(){
        connectframe=new ConnectFrame(this);
        connectframe.setVisible(true);
        
    }

    public void connect(String username, String ip_address, Calendar date) {
        try {
            server = (ChatServerInterface) Naming.lookup("rmi://" + ip_address + "/ChatService");
            lastMsgRecived = server.get_num_messages(); //Marker for when user entered conversation
                                                        //User will not recive messages prior to when they joined
            this.username = username;
            this.connectframe.setVisible(false);
            clientframe=new ClientFrame(this);
            this.clientframe.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void sendMessage(String message)
    {
        java.util.Date date = new java.util.Date();
        Message outgoing = new Message();
        
        outgoing.sender = username;
        outgoing.date = date.getTime();
        outgoing.message = message;
        
        server.incoming_message(outgoing);
    }


    public void get_new_messages() throws RemoteException {
        int numMsgToRecive = server.get_num_messages() - lastMsgRecived;
            
        if(numMsgToRecive != 0)
        {
            for(int i = lastMsgRecived; i<server.get_num_messages(); i++)
                displayMsg(server.get_new_message(i));
        }  
    }
    
    public void displayMsg(Message incoming)
    {
        
    }
    
    
}
