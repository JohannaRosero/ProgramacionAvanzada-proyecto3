/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala.de.cine;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestRemote extends Remote {
    void sayHello(int fila,int columna ) throws RemoteException;
}
