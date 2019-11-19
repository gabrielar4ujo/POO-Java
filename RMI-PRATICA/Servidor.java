import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Database_IF {

    public Servidor(){}

    @Override
    public boolean adiciona(String s) throws RemoteException {
        System.out.println("adicionado");
        return false;
    }

    @Override
    public boolean remove(String s) throws RemoteException {
        return false;
    }

    @Override
    public boolean busca(String s) throws RemoteException {
        return false;
    }

    @Override
    public void lista() throws RemoteException {

    }

    public static void main(String[] args) {

        try {
            Servidor servidor = new Servidor();
            Database_IF stub = (Database_IF) UnicastRemoteObject.exportObject(servidor,0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("operação",stub);

            System.err.println("Servidor exception...");
        } catch (Exception e) {
            System.err.println("Servidor exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
