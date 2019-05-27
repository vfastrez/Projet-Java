package fr.exia.boulderdash;

import java.io.IOException;

import fr.exia.boulderdash.controller.IBoulderDashController;
import fr.exia.boulderdash.controller.BoulderDashController;
import fr.exia.boulderdash.model.IBoulderDashModel;
import fr.exia.boulderdash.model.BoulderDashModel;
import fr.exia.boulderdash.view.BoulderDashView;

public abstract class BoulderDash {

    private static final int startX = 3;

    private static final int startY = 3;

    public static void main(final String[] args) throws IOException, InterruptedException {
        final IBoulderDashModel model = new BoulderDashModel("Map1.txt", startX, startY);
        final BoulderDashView view = new BoulderDashView(model.getMap(), model.getMyHero());
        final IBoulderDashController controller = new BoulderDashController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}
