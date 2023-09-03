package rmijdbc;
//import com.mysql.jdbc.Connection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

import java.sql.*;
//import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class Server extends UnicastRemoteObject implements InterJDBC {

    public Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        Server s = new Server();
        reg.rebind("db", s);
        System.out.println("server is running now---");

    }

    @Override
    public String Delete(int id) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");      
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmitest", "root", "");
            Statement st =  con.createStatement();
            
            String sql = "delete from info where id='"+ id+ "'";
            st.executeUpdate(sql);
            
            return "deleted successfully";
            
        } catch (Exception ex) {
            return (ex.toString());
        }

    }

    @Override
    public String Insert(int id, String name, String dept, String gender, int age, String year) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmitest", "root", "");
            Statement st =  con.createStatement();
            String sql = "insert into info values ('" + id + "','" + name + "','" + dept + "','" + gender + "','" + age + "','" + year + "')";
            st.executeUpdate(sql);
            return "insert successfully";
        } catch (Exception ex) {
            return (ex.toString());
        }

    }

    @Override
    public String Ubdate(int id, String name, String dept, String gender, int age, String year) throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmitest", "root", "");
            Statement st =  con.createStatement();
            
            String sql = "Update info set name='" + name + "',dept='" + dept + "',gender='" + gender + "',age='" + age + "',year='" + year + "' where id='" + id + "'";
            st.executeUpdate(sql);
            
            return "update successfully";
        } catch (Exception ex) {
            return (ex.toString());
        }

    }

}
