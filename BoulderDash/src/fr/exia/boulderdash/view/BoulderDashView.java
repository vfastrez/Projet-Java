package fr.exia.boulderdash.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.exia.boulderdash.controller.IOrderPerformer;
import fr.exia.boulderdash.controller.UserOrder;
import fr.exia.boulderdash.model.IMap;
import fr.exia.boulderdash.model.element.mobile.IMobile;
import fr.exia.showboard.BoardFrame;

public class BoulderDashView implements Runnable, KeyListener, IBoulderDashView {

    private static final int roadView   = 20;

    private static final int squareSize = 50;

    private Rectangle        closeView;

    private IMap            map;

    private IMobile          myHero;

    private int              view;

    private IOrderPerformer  orderPerformer;

    public BoulderDashView(final IMap map, final IMobile myHero) throws IOException {
        this.setView(roadView);
        this.setMap(map);
        this.setMyHero(myHero);
        this.getMyHero().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getMyHero().getY(), this.getMap().getWidth(), roadView));
        SwingUtilities.invokeLater(this);
    }

    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyHero());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        this.followMyHero();

        boardFrame.setVisible(true);
    }

    public final void show(final int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getMyHero().getX()) && (y == yStart)) {
                    System.out.print(this.getMyHero().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getMap().getHeight();
           System.out.print("\n");
        }
    }

    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
                userOrder = UserOrder.UP;
                break;
            case KeyEvent.VK_DOWN:
                userOrder = UserOrder.DOWN;
                break;
                
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }

    @Override
    public void keyTyped(final KeyEvent keyEvent) {
    }

    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void keyReleased(final KeyEvent keyEvent) {
    }

    @Override
    public final void followMyHero() {
        this.getCloseView().y = this.getMyHero().getY() - 3;
    }

    private IMap getMap() {
        return this.map;
    }

    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            }
        }
    }

    private IMobile getMyHero() {
        return this.myHero;
    }

    private void setMyHero(final IMobile myHero) {
        this.myHero = myHero;
    }

    private int getView() {
        return this.view;
    }

    private void setView(final int view) {
        this.view = view;
    }

    private Rectangle getCloseView() {
        return this.closeView;
    }

    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}
