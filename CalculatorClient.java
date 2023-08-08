import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculatorClient {

    private CalculatorClient() {}

    public static void main(String[] args) {

	String host = (args.length < 1) ? null : args[0];
		try {
			Registry registry = LocateRegistry.getRegistry(host);
			Calculator stub = (Calculator) registry.lookup("Calculator");
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String input;
			String[] parsedInput;
			int num;

			//while loop to constantly take in input from the client
			while(true){
				input = bf.readLine();
				parsedInput = input.split(" ");

				if(parsedInput.length==2 && parsedInput[0].equals("push")){
					num = Integer.parseInt(parsedInput[1]);
					stub.pushValue(num);
				}
				else if(parsedInput[0].equals("min") || parsedInput[0].equals("max") || parsedInput[0].equals("lcm") || parsedInput[0].equals("gcd")){
					stub.pushOperation(parsedInput[0]);
				}
				else if(parsedInput[0].equals("pop")){
					System.out.println(stub.pop());
				}
				else if (parsedInput[0].equals("isEmpty")){
					stub.isEmpty();
				}
				else if (parsedInput.length==2 && parsedInput[0].equals("delayPop")){
					num = Integer.parseInt(parsedInput[1]);
					System.out.println(stub.delayPop(num));
				}
				else{
					System.out.println("Please enter a valid function");
				}

			}

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
    }
}
