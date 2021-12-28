package edu.sdccd.cisc191.template;

public class ConsoleDisplay implements Runnable {
    // Instantiate a new thread
    Thread consoleThread;
    // To call the console display something
    private String name;

    // Constructor
    ConsoleDisplay(String name) {
        this.name = name;
    }

    @Override
    /**
     * Display output on the ConsoleDisplay
     */
    public void run() {
        System.out.println(this.name);
        ImprovedMediaCollection mediaCollection = new ImprovedMediaCollection();
    }

    /**
     * INitialize the thread and ConsoleDisplay
     */
    public void start() {
        System.out.println("Thread started");
        if (consoleThread == null) {
            consoleThread = new Thread(this, this.name);
            consoleThread.start();
        }
    }
}