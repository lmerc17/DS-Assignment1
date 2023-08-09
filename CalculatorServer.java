import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
	
public class CalculatorServer {
	
    public static void main(String args[]) {
	
	try {
	    CalculatorImplementation obj = new CalculatorImplementation(); //create a new CalculatorImplementation object
	    Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0); //create a stub from Calculator

	    // Bind the remote object's stub in the registry
	    Registry registry = LocateRegistry.getRegistry();
	    registry.bind("Calculator", stub);

	    System.err.println("Server ready"); //print server ready message

	} catch (Exception e) {
	    System.err.println("Server exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}
