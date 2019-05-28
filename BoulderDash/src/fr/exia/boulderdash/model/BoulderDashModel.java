package fr.exia.boulderdash.model;

import java.io.IOException;

import fr.exia.boulderdash.model.element.mobile.IMobile;
import fr.exia.boulderdash.model.element.mobile.MyHero;

public class BoulderDashModel implements IBoulderDashModel {

    private IMap   map;

    private IMobile myHero;
 

    public BoulderDashModel(final String fileName, final int myHeroStartX, final int myHeroStartY)
            throws IOException {
        this.setMap(new Map(fileName));
        this.setMyHero(new MyHero(myHeroStartX, myHeroStartY, this.getMap()));
    }

    @Override
    public final IMap getMap() {
        return this.map;
    }

    private void setMap(final IMap map) {
        this.map = map;
    }

    @Override
    public final IMobile getMyHero() {
        return this.myHero;
    }

    private void setMyHero(final IMobile myHero) {
        this.myHero = myHero;
    }

}
