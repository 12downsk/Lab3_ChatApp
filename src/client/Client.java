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
            server = (ChatServerInterface) Naming.lookup("rmi://" + ip_address + "/chatService");
            lastMsgRecived = server.get_num_messages(); //Marker for when user entered conversation
                                                        //User will not recive messages prior to when they joined
            this.username = username;
            this.connectframe.setVisible(false);
            clientframe=new ClientFrame(this);
            this.clientframe.setVisible(true);
            server.newConnection(username);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void sendMessage(String message) throws RemoteException
    {
        java.util.Date date = new java.util.Date();
        String outgoing;
        
        outgoing = date.toString() + " ["+username+"]: " + message;
        
        server.incoming_message(outgoing);
    }

    public int getNumMessages() throws RemoteException{
        return server.get_num_messages();
    } 
    
    public String getNewMessage(int messageNum) throws RemoteException
    {
        return server.get_new_message(messageNum);
    }
    
    public static void main(String args[]) {
        try {
            Client client=new Client();
            client.init();  
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
