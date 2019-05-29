package main;

import java.io.IOException;

import contract.IBoulderDashController;
import contract.IBoulderDashModel;
import controller.BoulderDashController;
import model.BoulderDashModel;
import view.BoulderDashView;


public abstract class BoulderDash {

    private static final int startX = 3;

    private static final int startY = 3;

    public static void main(final String[] args) throws IOException, InterruptedException {
        final IBoulderDashModel model = new BoulderDashModel("C:\\Users\\vince\\Desktop\\Projet-Java-6b643cfee387314fc553cb87801d3b2d6a0a8ea4\\JPU-BlankProject\\JPU-BlankProject\\Map.txt", startX, startY);
        final BoulderDashView view = new BoulderDashView(model.getMap(), model.getMyHero());
        final IBoulderDashController controller = new BoulderDashController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}
