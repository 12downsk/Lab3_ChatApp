
package server;
import java.rmi.*;
import java.util.Calendar;
import java.util.LinkedList;


public interface ChatServerInterface extends Remote{

    //public void incoming_message() throws RemoteException;
    
    public int get_num_messages() throws RemoteException;
    
    public Message get_new_message(int MessageNum) throws RemoteException;
    
    public void incoming_message(Message incoming) throws RemoteException;
    
    public Message get_message(int num) throws RemoteException;
}