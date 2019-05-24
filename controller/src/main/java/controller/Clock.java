package controller;

import java.util.Observable;

public class Clock extends Observable implements Runnable {

    /** The number of ticks since the beginning of the game */
    private int tickNumber;
    /** The interval between two ticks */
    private int tickInterval;
    /** The default interval between two ticks (in millisecond) */
    public static int DEFAULT_TICK_INTERVAL = 500;

    /**
     * Instantiates a clock
     */
    public Clock() {
        this.tickNumber = 0;
        this.setTickInterval(DEFAULT_TICK_INTERVAL);
    }

    /**
     * Instantiates a new clock with an interval
     *
     * @param tickInterval
     * the interval between two ticks
     */
    public Clock(int tickInterval) {
        this.tickNumber = 0;
        this.setTickInterval(tickInterval);
    }

    /**
     * The method executed in the new thread
     */
    public void run() {

    }

    // GETTERS & SETTERS //

    /**
     * Get the number of tick since the beginning
     * @return
     * The number of ticks since the beginning
     */
    public int getTickNumber() {
        return tickNumber;
    }

    /**
     * Get the interval between two ticks
     * @return
     * The interval in milliseconds
     */
    public int getTickInterval() {
        return tickInterval;
    }

    /**
     * Set the interval between two ticks
     * @param tickInterval
     * The new interval in milliseconds
     */
    public synchronized void setTickInterval(int tickInterval) {
        this.tickInterval = tickInterval;
    }
}