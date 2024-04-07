package esercitazione2_cs_tcp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author user
 */
public class MainClient {

    
    public static void main(String[] args) {
        
        Client client = new Client();
 
        client.connetti();
        client.comunica();
        
    }
    
}

