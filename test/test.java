package test;
import java.util.Scanner;
import java.util.Stack;

public class test {

    public static int two_number_gcd(int a, int b){

        int gcd = 0;

        if(a < b){
            gcd = a;
        }
        else{
            gcd = b;
        }

        while(gcd > 0){
            if(a % gcd == 0 && b % gcd == 0){
                break;
            }
            gcd--;
        }

        return gcd;

    }

    //function to find and return the greatest common divisor in a stack
    public static int gcd(Stack<Integer> stack) {
        int num1 = stack.pop();
        int num2 = stack.pop();

        int gcd = two_number_gcd(num1, num2);

        while(!stack.empty()){
            int nextNum = stack.pop();
            gcd = two_number_gcd(nextNum, gcd);
        }

        return gcd;
    }

    public static int two_number_lcm(int a, int b){

        int product = a*b;
        int denominator = two_number_gcd(a, b);

        return product/denominator;

    }

    //function to find and return the lowest common multiple in a stack
    public static int lcm(Stack<Integer> stack) {

        int num1 = stack.pop();
        int num2 = stack.pop();

        int lcm = two_number_lcm(num1, num2);

        while(!stack.empty()){
            int nextNum = stack.pop();
            lcm = two_number_lcm(nextNum, lcm);
        }

        return lcm;

    }

    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<Integer>();

        Scanner sc = new Scanner(System.in);

        stack.push(sc.nextInt());
        stack.push(sc.nextInt());
        stack.push(sc.nextInt());
        stack.push(sc.nextInt());
        stack.push(sc.nextInt());
        stack.push(sc.nextInt());
        stack.push(sc.nextInt());
        
        sc.close();
        
        System.out.println(lcm(stack));



    }

}
