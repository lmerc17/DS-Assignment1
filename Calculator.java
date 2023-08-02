import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    //defining the remote operations implemented by the remote service
    void pushValue(int val) throws RemoteException;
    void pushOperation(String operator) throws RemoteException;
    int pop() throws RemoteException;
    boolean isEmpty() throws RemoteException;
    int delayPop(int millis) throws RemoteException;
    
}
