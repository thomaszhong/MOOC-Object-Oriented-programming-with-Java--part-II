/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author Thomas Zhong
 */
public class Worm {

    private int originalX;
    private int originalY;
    private Direction originalDirection;
    private List<Piece> worm;
    private boolean ifGrow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(this.originalX, this.originalY));
        this.ifGrow = false;
    }

    public Direction getDirection() {
        return this.originalDirection;
    }

    public void setDirection(Direction dir) {
        this.originalDirection = dir;
    }

    public int getLength() {
        return this.worm.size();
    }

    public List<Piece> getPieces() {
        return this.worm;
    }

    public void move() {
        int newX = this.worm.get(getLength() - 1).getX();
        int newY = this.worm.get(getLength() - 1).getY();

        switch (this.originalDirection) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            default:
                newX++;
                break;
        }
        
        this.worm.add(new Piece(newX, newY));
        if (!this.ifGrow && getLength() > 3) {
            this.worm.remove(0);
        } 
        this.ifGrow = false;
    }

    public void grow() {
        this.ifGrow = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece temp : this.worm) {
            if (temp.getX() == piece.getX() && temp.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        int wormHeadX = wormHead().getX();
        int wormHeadY = wormHead().getY();
        
        for (int i = 0; i < getLength() - 1; i++) {
            if (wormHeadX == this.worm.get(i).getX() 
                    && wormHeadY == this.worm.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
    
    public Piece wormHead() {
        return this.worm.get(getLength() -1);
    }

}
