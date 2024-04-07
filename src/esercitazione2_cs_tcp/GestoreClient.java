/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercitazione2_cs_tcp;
import static esercitazione2_cs_tcp.Server.contaVocali;
import java.net.*;
import java.io.*;

/**
 *
 * @author user
 */
public class GestoreClient implements Runnable{
    
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    
    public GestoreClient(Socket client) throws IOException {
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream());
    }
    
    @Override
    public void run(){
        comunica();
    }
    
    public void comunica(){
        
        try {
            while(true){
                String stringaRicevuta = in.readLine();

                System.out.println("Frase ricevuta!\n");
                System.out.println("Frase: " + stringaRicevuta + "\n");

                int nVocali = Server.contaVocali(stringaRicevuta);
                out.write(nVocali + "\n");
            }
          
            
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
        
        System.out.println("[SERVER] - Fase di elaborazione terminata, controllare il risultato\n");
        try {
            client.close();
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }
}
