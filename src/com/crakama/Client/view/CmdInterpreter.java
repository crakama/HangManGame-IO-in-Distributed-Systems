package com.crakama.Client.view;

import com.crakama.Client.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdInterpreter implements Runnable{
    private boolean receivingCmds = false;
    private boolean isConnected = false;
    Controller controller;
    private BufferedReader bufferedReader;
   private OutputHandler outputHandler;

    public void start(){
        receivingCmds = true;
        controller = new Controller();
        new Thread(this).start();
    }
    @Override
    public void run() {
        OutputHandler outputHandler = new ServerResponse();
        while (receivingCmds){
            try {
                CmdHandler cmdHandler = new CmdHandler(requestHandler());
                switch (cmdHandler.getCmd()){

                    case CONNECT:
                        controller.connect(cmdHandler.getParameters(1),
                                Integer.parseInt(cmdHandler.getParameters(2)), new ServerResponse());
                        Thread.sleep(1000);
                        outputHandler.informUser();
                        this.isConnected = true;

                        break;
                    case START:
                        if(this.isConnected = true){
                            controller.startGame();
                        }
                    case QUIT:
                        break;
                    default:
                        controller.sendGuess(cmdHandler.getParameters(0));
                }

            }catch (Exception e){
            }
        }
    }
    /**
     * Handles user input from commandline
     */
    private String requestHandler() throws IOException {
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String readBuffer = bufferedReader.readLine();
            return readBuffer;
        }


    private class ServerResponse implements OutputHandler {
        @Override
        public void handleServerResponse(String receivedMessage) {
            System.out.println("//***-------------------------------------------------------------------------***\n\n"+receivedMessage+
                    "\n\n***-------------------------------------------------------------------------***\n");
        }

        @Override
        public void handleErrorResponse(Throwable connectionFailure) {
            System.out.println("//***-------------------------------------------------------------------------***\n\n"+connectionFailure+
                    "\n\n***-------------------------------------------------------------------------***\n");
        }

        @Override
        public void informUser() {
            System.out.println(" Enter a command to proceed");
        }
    }
}
//TO DO single output mechanism for both server and client
