package com.crakama.Client.controller;

import com.crakama.Client.view.OutputHandler;
import com.crakama.Client.net.ServerCommHandler;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.concurrent.CompletableFuture;

public class Controller {
    private ServerCommHandler serverCommHandler;

    public void connect(String host, int port, OutputHandler outputHandler) {
        CompletableFuture.runAsync(()-> {
            try {
               this.serverCommHandler = new ServerCommHandler();
               serverCommHandler.connect(host, port,outputHandler);
            }catch (IOException e){
                throw new UncheckedIOException(e);
            }

        });
    }

    public void startGame(){
        CompletableFuture.runAsync(()->{
            try {
                this.serverCommHandler.startGame();
            }catch (IOException e){
                throw new UncheckedIOException(e);
            }
        });
    }

    public void sendGuess(String guess){
        CompletableFuture.runAsync(()->{
            try {
                this.serverCommHandler.sendGuess(guess);
            }catch (IOException e){
                throw new UncheckedIOException(e);
            }
        });
    }
}
