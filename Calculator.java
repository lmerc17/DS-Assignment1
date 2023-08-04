import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

public interface Calculator extends Remote {
   
    //defining a Stack object for use as the stack stored on the server
    Stack<Integer> stack = new Stack<Integer>();

    //defining the remote operations implemented by the remote service
    void pushValue(int val) throws RemoteException;
    void pushOperation(String operator) throws RemoteException;
    int pop() throws RemoteException;
    boolean isEmpty() throws RemoteException;
    int delayPop(int millis) throws RemoteException;
    
    //defining operator functions
    int min() throws RemoteException;
    int max() throws RemoteException;
    int two_number_gcd(int a, int b) throws RemoteException;
    int gcd() throws RemoteException;
    int two_number_lcm(int a, int b) throws RemoteException;
    int lcm() throws RemoteException;
    
}
