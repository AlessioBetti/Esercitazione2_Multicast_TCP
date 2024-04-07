/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercitazione2_cs_tcp;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;


/**
 *
 * @author user
 */
public class Server {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    int nVocali = 0;
    BufferedReader stringaClient;
    DataOutputStream dos;
    
    private static ArrayList<GestoreClient> clients = new ArrayList<>();
    
    private static ExecutorService pool = Executors.newFixedThreadPool(5);
    
    public Socket attendi(){
         
        try {
            while(true){
            System.out.println("Server in esecuzione e in ascolto\n");
            System.out.println(" ___________________________________________\n");
            
            stringaClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            dos = new DataOutputStream(client.getOutputStream());
            
            server = new ServerSocket(1789);
            client = server.accept();
            dos.writeBytes("[SERVER] - digita una stringa ed io la convertirò in maiuscolo\n");
            
            GestoreClient gestoreThread = new GestoreClient(client);
            clients.add(gestoreThread);
            
            pool.execute(gestoreThread);
            }
            
          
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
        
        return client; 
    }
    
    
    public static int contaVocali(String str){
        int count = 0;
        String strMinuscola = str.toLowerCase();
        for (int i = 0; i < str.length(); i++)
        {
            if (strMinuscola.charAt(i) == 'a' || strMinuscola.charAt(i) == 'e' || strMinuscola.charAt(i) == 'i'
                    || strMinuscola.charAt(i) == 'o' || strMinuscola.charAt(i) == 'u')
            {
                count++;
            }
        }
        return count;
    }

}
