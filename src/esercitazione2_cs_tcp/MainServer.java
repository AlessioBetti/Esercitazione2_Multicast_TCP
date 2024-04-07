/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esercitazione2_cs_tcp;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author user
 */
public class MainServer {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader stringaClient;
    DataOutputStream dos;
    
    
    public Socket attendi(){
         
        try {
            System.out.println("Server in esecuzione e in ascolto\n");
            System.out.println(" ___________________________________________\n");
            System.out.println("      Server in esecuzione e in ascolto\n");
            System.out.println(" ___________________________________________\n");
            
            server = new ServerSocket(1789);
            client = server.accept();
            server.close();
            
            stringaClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            dos = new DataOutputStream(client.getOutputStream());
          
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
        
        return client; 
    }
    
    
    public void comunica(){
        
        try {
            while(true){
                stringaRicevuta = stringaClient.readLine();

                System.out.println("Frase ricevuta!\n");
                System.out.println("Frase: " + stringaRicevuta + "\n");

                stringaModificata = stringaRicevuta.toUpperCase();
                dos.writeBytes(stringaModificata + "\n");
            }
          
            
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
        
        System.out.println("Fase di elaborazione terminata, controllare il risultato\n");
        try {
            client.close();
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }


    public static void main(String[] args) {
        MainServer server = new MainServer();
        server.attendi();
        server.comunica();
    }
    
}
