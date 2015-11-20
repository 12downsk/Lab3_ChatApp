package server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;



public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {
    
    Vector<String> log;
    int numMessages = 0;

    ChatServer() throws RemoteException {
        super();
        
    }
    
    @Override
    public int get_num_messages()
    {
        return numMessages;
    }
    
    @Override
    public void incoming_message(String incoming) {
        log.add(incoming);
        numMessages++;
    }

    @Override
    public String get_new_message(int MessageNum) {
        return log.elementAt(MessageNum);
    }
    
}
