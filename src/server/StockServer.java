package server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;



public class StockServer extends UnicastRemoteObject implements StockServerInterface {
    
    Vector<Message> log;
    int numMessages = 0;

    StockServer() throws RemoteException {
        super();
        
    }

    
    public void incoming_message(Message incoming) {
        log.add(incoming);
        numMessages++;
    }

    @Override
    public Message get_new_message(int MessageNum) {
    
        return log.elementAt(MessageNum);
    }
}
