package server;

import java.rmi.*;
import java.rmi.registry.*;

public class StockServerApplication {

    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            Registry registry=LocateRegistry.getRegistry();
            StockServer server=new StockServer();
            StockServerInterface stockService = server;
            registry.rebind("StockService", stockService);
            System.out.println("Server is listening!");
            StockFrame frame=new StockFrame(server);
            frame.setVisible(true);
            Thread.sleep(10*60 *  1000);
            System.out.println("Server stops");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
