import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {

    private CalculatorClient() {}

    public static void main(String[] args) {

	String host = (args.length < 1) ? null : args[0];
	try {
	    Registry registry = LocateRegistry.getRegistry(host);
	    Calculator stub = (Calculator) registry.lookup("Calculator");
        //functions can go here
        //output can go here
	} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}
