import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalculatorClient {

	//default constructor
    private CalculatorClient() {}

    public static void main(String[] args) {

	//definition of host depending on if arguments are given into main function
	String host = (args.length < 1) ? null : args[0];

		try {
			//code to get the registry and create a stub for the client
			Registry registry = LocateRegistry.getRegistry(host);
			Calculator stub = (Calculator) registry.lookup("Calculator");
			
			//initialisation of bufferedReader for taking in input
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String input; //input is stored in this string
			String[] parsedInput; //input is parsed in this
			int num; //numbers from the input is stored in this
			boolean isEmpty; //boolean to store whether the stack is empty or not

			//while loop to constantly take in input from the client
			while(true){
				//readLine from client and store it into input
				input = bf.readLine();
				parsedInput = input.split(" "); //split the input into the parsedInput array

				//if two inputs have been given and the first one is push
				if(parsedInput.length==2 && parsedInput[0].equals("push")){
					try{
						num = Integer.parseInt(parsedInput[1]); //convert the second string to an integer
						stub.pushValue(num); //call pushValue with that number
					} catch (NumberFormatException e){
						System.out.println("Please enter a valid number");
					}
				}
				else if(parsedInput.length==1 && (parsedInput[0].equals("min") || parsedInput[0].equals("max") || parsedInput[0].equals("lcm") || parsedInput[0].equals("gcd"))){
					stub.pushOperation(parsedInput[0]);
				}
				else if(parsedInput.length==1 && parsedInput[0].equals("pop")){
					if(!stub.isEmpty()){
						System.out.println(stub.pop());
					}
					else{
						System.out.println("Stack is empty, no value to pop");
					}
				}
				else if (parsedInput.length==1 && parsedInput[0].equals("isEmpty")){
					isEmpty = stub.isEmpty();
					if(isEmpty == true){
						System.out.println("true");
					}
					else{
						System.out.println("false");
					}
				}
				else if (parsedInput.length==2 && parsedInput[0].equals("delayPop")){
					if(!stub.isEmpty()){
						num = Integer.parseInt(parsedInput[1]);
						System.out.println(stub.delayPop(num));
					}
					else{
						System.out.println("Stack is empty, no value to pop");
					}
					
				}
				else if (parsedInput.length==1 && parsedInput[0].equals("exit")){
					break;
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
