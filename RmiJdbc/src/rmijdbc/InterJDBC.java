package rmijdbc;

import java.rmi.*;

public interface InterJDBC extends Remote {

    public String Delete(int id) throws RemoteException;

    public String Insert(int id,String name,String dept,String gender,int age,String year) throws RemoteException;

    public String Ubdate(int id,String name,String dept,String gender,int age,String year) throws RemoteException;

}
