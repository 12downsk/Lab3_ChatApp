package server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;



public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
    
    ArrayList<String> log = new ArrayList<>();
    int numMessages = 0;

    ChatServer() throws RemoteException {
        super();
        
    }
    
    
    @Override
    public void newConnection(String User){
        System.out.println(User + " has connected.");
    }
    
    @Override
    public int get_num_messages()
    {
        return numMessages;
    }
    
    @Override
    public void incoming_message(String incoming) {
        
        System.out.println(incoming);
        
        try{
        log.add(incoming);
        numMessages++;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        System.out.println("num messages " +numMessages);
    }

    @Override
    public String get_new_message(int MessageNum) {
        System.out.println("Message Num: " + MessageNum);
        try{
          System.out.println("Message: " + log.get(MessageNum - 1));
            return log.get(MessageNum -1 );  
        }
        catch(Exception e)
        {
            System.out.println(e);
            return "failed to get message\n";
        }
        
    }
    
}
