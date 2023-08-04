public class CalculatorImplementation implements Calculator{

    //function to find and return the minimum number in a stack
    public int min() {
        int min = stack.pop(); //set the minimum value to the value at the top of the stack
        while(!stack.empty()){ //while the stack has values in it
            if(stack.peek() < min){ //peek at the top value, if it is less than the min
                min = stack.pop(); //set the top stack value as min
            }
            else{
                stack.pop(); //otherwise remove it from the stack
            }
        }
        return min;
    }

    //function to find and return the maximum number in a stack
    public int max() {
        int max = stack.pop(); //set the maximum value to the value at the top of the stack
        while(!stack.empty()){ //while the stack has values in it
            if(stack.peek() > max){ //peek at the top value, if it is more than the max
                max = stack.pop(); //set the top stack value as max
            }
            else{
                stack.pop(); //otherwise remove it from the stack
            }
        }
        return max;
    }

    //function to find the gcd of integers a and b, it's purpose is to help the gcd function calculate gcd for more than two numbers
    public int two_number_gcd(int a, int b){

        int gcd = 0;
        
        //short hand if else statement, if a < b gcd is a otherwise it is b
        gcd = (a < b) ? a : b;
    
        //while loop to find the gcd from the two numbers
        while(gcd > 0){
            if(a % gcd == 0 && b % gcd == 0){
                break;
            }
            gcd--;
        }

        return gcd;

    }

    //function to find and return the greatest common divisor in a stack
    public int gcd() {
        //get the first two number from the stack
        int num1 = stack.pop();
        int num2 = stack.pop();

        //find the gcd for those first two numbers
        int gcd = two_number_gcd(num1, num2);

        //while the stack is not empty, run the gcd function again with the previous gcd result and the next number in the stack
        while(!stack.empty()){
            int nextNum = stack.pop();
            gcd = two_number_gcd(nextNum, gcd);
        }

        return gcd;
    }

    //function to find the lcm of integers a and b, it's purpose is to help the lcm function calculate lcm for more than two numbers
    public int two_number_lcm(int a, int b){

        //take the product and the gcd of the two numbers
        int product = a*b;
        int denominator = two_number_gcd(a, b);

        //return the product over the gcd of the two numbers
        return product/denominator;

    }

    //function to find and return the lowest common multiple in a stack
    public int lcm() {

        //grab the first two numbers off of the stack
        int num1 = stack.pop();
        int num2 = stack.pop();

        //find the lcm of these two numbers
        int lcm = two_number_lcm(num1, num2);

        //if the stack isn't empty
        while(!stack.empty()){
            int nextNum = stack.pop(); //get the next number from the stack
            lcm = two_number_lcm(nextNum, lcm); //find the lcm of these two numbers
        }

        return lcm;

    }

    //this method takes val and pushes it to the top of the stack
    //the pre-implmeneted push function from java's Stack object has been used
    public void pushValue(int val) {
        stack.push(val);
    }

    //this method pushes a String containing an operator to the stack
    //it will cause the server to pop all the values on the stack and do a certain task depending on the operator
    public void pushOperation(String operator){

        int new_stack_value = 0;

        //if min is entered, call function to find minimum of stack
        if(operator.equals("min")){
            new_stack_value = min(); //set new_stack_value to the minimum found
        }

        //else if max is entered, call function to find maximum of stack
        else if(operator.equals("max")){
            new_stack_value = max(); //set new_stack_value to the maximum found
        }

        //else if gcd is entered, call function to find greatest common divisor of stack
        else if(operator.equals("gcd")){
            new_stack_value = gcd();
        }

        //else if lcm is entered, call function to find the lowest common multiple of stack
        else if(operator.equals("lcm")){
            new_stack_value = lcm();
        }

        //empty stack
        while(!stack.empty()){
            stack.pop();
        }

        //push the new value onto the stack
        stack.push(new_stack_value);

    }
    
    //this method pops the top of the stack and returns it to the client
    //the pre-implmeneted pop function from java's Stack object has been used
    public int pop() {
        return stack.pop();
    }

    //this method will return true if the stack is empty and false otherwise
    //the pre-implmeneted isEmpty function from java's Stack object has been used
    public boolean isEmpty() {
        return stack.empty();
    }

    //this method will wait millis milliseconds before carrying out the pop operation as above
    //the pre-implmeneted pop function from java's Stack object has been used once again
    public int delayPop(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stack.pop();
    }
}