
package server;
import java.rmi.*;
import java.util.Calendar;
import java.util.LinkedList;


public interface ChatServerInterface extends Remote{

    //public void incoming_message() throws RemoteException;
    
    public int get_num_messages() throws RemoteException;
    
    public String get_new_message(int MessageNum) throws RemoteException;
    
    public void incoming_message(String incoming) throws RemoteException;
    
    
}