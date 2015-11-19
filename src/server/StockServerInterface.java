
package server;
import java.rmi.*;
import java.util.Calendar;
import java.util.LinkedList;


public interface StockServerInterface extends Remote{

    //public void incoming_message() throws RemoteException;
    
    public Message get_new_message() throws RemoteException;
}
