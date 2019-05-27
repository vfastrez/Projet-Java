package fr.exia.boulderdash.controller;

public interface IBoulderDashController {

    void play() throws InterruptedException;

    IOrderPerformer getOrderPeformer();
}
