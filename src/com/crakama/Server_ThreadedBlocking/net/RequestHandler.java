package com.crakama.Server_ThreadedBlocking.net;

import com.crakama.Server_ThreadedBlocking.ServeInterface;
import com.crakama.Server_ThreadedBlocking.ServerInterfaceImpl;
import com.crakama.Server_ThreadedBlocking.net.ClientCommHandler;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler implements Runnable{
    private Socket clientSocket;
    private ClientCommHandler clientCommHandler;
    private ServeInterface serveInterface;

    public RequestHandler(ClientCommHandler threadedBlockingServer, Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.clientCommHandler = threadedBlockingServer;
        this.serveInterface = new ServerInterfaceImpl();
    }
    @Override
    public void run() {
        while (clientSocket.isConnected()){
            try{
                switch (clientCommHandler.readRequest().getMsgType()){
                    case START:
                        serveInterface.initialiseGame(clientCommHandler,clientSocket);
                        break;
                    case PLAY:
                        serveInterface.playGame(clientCommHandler);
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
