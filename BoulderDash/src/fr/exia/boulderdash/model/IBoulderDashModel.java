package fr.exia.boulderdash.model;

import fr.exia.boulderdash.model.element.mobile.IMobile;

public interface IBoulderDashModel {

    IMap getMap();

    IMobile getMyHero();
}
