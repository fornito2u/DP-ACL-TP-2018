import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import javax.naming.*;

public class WarehouseServer {
	
	public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException
	{
		System.out.println("Constructing	server	implementation...");
		WarehouseImpl centralWarehouse = new WarehouseImpl();
		System.out.println("Binding	server	implementation	to	registry...");
		Registry registry = LocateRegistry.getRegistry();
		registry.bind("central_warehouse", (Remote) centralWarehouse);
		System.out.println("Waiting	for	invocations	from clients...");
	}

}
