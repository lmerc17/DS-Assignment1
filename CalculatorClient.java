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
					try{ //try and catch to ensure that a valid integer is being given to parseInt
						num = Integer.parseInt(parsedInput[1]); //convert the second string to an integer
						stub.pushValue(num); //call pushValue with that number
					} catch (NumberFormatException e){
						System.out.println("Please enter a valid number");
					}
				}
				else if(parsedInput.length==1 && (parsedInput[0].equals("min") || parsedInput[0].equals("max") || parsedInput[0].equals("lcm") || parsedInput[0].equals("gcd"))){
					//else if an operation has been entered
					stub.pushOperation(parsedInput[0]); //call pushOperation with the operation given
				}
				else if(parsedInput.length==1 && parsedInput[0].equals("pop")){ //else if pop has been entered
					if(!stub.isEmpty()){ //if stack is not empty
						System.out.println(stub.pop()); //perform pop operation
					}
					else{
						System.out.println("Stack is empty, no value to pop"); //print out error message
					}
				}
				else if (parsedInput.length==1 && parsedInput[0].equals("isEmpty")){ //else if isEmpty function is called
					isEmpty = stub.isEmpty();
					if(isEmpty == true){ //if stack is empty
						System.out.println("true"); //print true
					}
					else{
						System.out.println("false"); //otherwise print false
					}
				}
				else if (parsedInput.length==2 && parsedInput[0].equals("delayPop")){ //if delayPop is called
					if(!stub.isEmpty()){ //if the stack isn't empty, perform operation
						try{ //try and catch to ensure that a valid integer is being given to parseInt
							num = Integer.parseInt(parsedInput[1]); //convert second string to intger
							System.out.println(stub.delayPop(num)); //call delayPop with that int
						}
						catch (NumberFormatException e){
							System.out.println("please enter a valid number");
						}
					}
					else{ //if stack is empty, give message
						System.out.println("Stack is empty, no value to pop");
					}
					
				}
				else if (parsedInput.length==1 && parsedInput[0].equals("exit")){ //if user writes exit, exit the code
					break;
				}
				else{ //if no valid function is entered, an error message is given
					System.out.println("Please enter a valid function");
				}

			}

		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
    }
}
