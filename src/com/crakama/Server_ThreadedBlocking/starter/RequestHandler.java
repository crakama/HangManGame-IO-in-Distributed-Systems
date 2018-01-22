package com.crakama.Server_ThreadedBlocking.starter;

import com.crakama.Server_ThreadedBlocking.net.ClientCommHandler;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler implements Runnable{
    private Socket clientSocket;
    private ClientCommHandler clientCommHandler;

    public RequestHandler(ClientCommHandler threadedBlockingServer, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.clientCommHandler = threadedBlockingServer;
    }
    @Override
    public void run() {
        while (clientSocket.isConnected()){
            try{
                switch (clientCommHandler.readRequest().getMsgType()){
                    case START:
                        String response = processData();
                        clientCommHandler.sendResponse(response);
                        break;
                    case GUESS:
                        processGuess();
                        break;
                    case STOP:
                        processData();
                }
            }catch (ClassNotFoundException|IOException e){

            }finally {
                //clientSocket.close();
            }
        }

    }

    private static String processData(){
        return "Welcome, Game started";
    }
    private static String processGuess(){
        return "Guess received";
    }
}
