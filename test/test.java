import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input;
        String[] parsedInput;
       
        while(true){
            input = bf.readLine();
            parsedInput = input.split(" ");

            int num;

            if(parsedInput.length==2 && parsedInput[0].equals("push")){
                num = Integer.parseInt(parsedInput[1]);
                System.out.println("push " + num);
            }
            else if(parsedInput[0].equals("min") || parsedInput[0].equals("max") || parsedInput[0].equals("lcm") || parsedInput[0].equals("gcd")){
                System.out.println("push " + parsedInput[0]);
            }
            else if(parsedInput[0].equals("pop")){
                System.out.println("pop");
            }
            else if (parsedInput[0].equals("isEmpty")){
                System.out.println("isEmpty");
            }
            else if (parsedInput.length==2 && parsedInput[0].equals("delayPop")){
                num = Integer.parseInt(parsedInput[1]);
                System.out.println("delayPop " + num);
            }
            else{
                System.out.println("Please enter a valid function");
            }

        }


    }

}
