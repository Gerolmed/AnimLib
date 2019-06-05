package de.gerolmed.animlib.api.interfaces;

public interface ITickable {
    /**
     * Notifies the tickable that a tick has passed.
     */
    void tick();

    /**
     * Stops the ticking
     */
    void stop();

    /**
     * Starts/Resumes the ticking
     */
    void start();
}
