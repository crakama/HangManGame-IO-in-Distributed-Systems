### Threaded-Client-with-Blocking-Server-Observer Pattern

A simple java system that uses TCP sockets for communication. Its consists of several parts:

* Multithreaded commandline client app
  - Parallel and Asynchronous Programming with Streams and CompletableFuture
  - Interactive commandline interface
  - Customized Communication protocol(Enums and Serializable classes for messages and commands)
  - Layered architecture(Clear separation of concerns between classes) with **_Observer pattern_**

* Customized application specific communication protocol  
* Threaded Blocking Server
  - More than one client can connect to it at a time,clients can send requests concurrently
  - Have a new thread that handles server operations.
  
  ![Threaded Blocking Server](https://github.com/crakama/HangManGame-IO-in-Distributed-Systems/blob/master/src/com/crakama/images/Initiate.PNG)
  ![Threaded Blocking Server](https://github.com/crakama/HangManGame-IO-in-Distributed-Systems/blob/master/src/com/crakama/images/multithreading.PNG)
   ![Threaded Blocking Server](https://github.com/crakama/HangManGame-IO-in-Distributed-Systems/blob/master/src/com/crakama/images/Game%20plays.png)
    ![Threaded Blocking Server](https://github.com/crakama/HangManGame-IO-in-Distributed-Systems/blob/master/src/com/crakama/images/Multiple%20Clients.PNG)




