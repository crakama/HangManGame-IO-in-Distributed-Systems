package com.crakama.Client.view;

public interface OutputHandler {
    void handleServerResponse(String msg);

    void handleErrorResponse(Throwable connectionFailure);


    void informUser();
}
