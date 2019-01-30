package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import wormgame.Direction;

public class Worm {

    private int originalX;
    private int originalY;
    private Direction originalDirection;
    private List<Piece> worm;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(this.originalX, this.originalY));
        this.grow = false;
    }

    public Direction getDirection() {
        return originalDirection;
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
        int newX = this.worm.get(this.worm.size() - 1).getX();
        int newY = this.worm.get(this.worm.size() - 1).getY();

        if (this.originalDirection == Direction.RIGHT) {
            newX++;
        } else if (this.originalDirection == Direction.LEFT) {
            newX--;
        } else if (this.originalDirection == Direction.DOWN) {
            newY++;
        } else if (this.originalDirection == Direction.UP) {
            newY--;
        }

        if (getLength() > 2 && !grow){
            this.worm.remove(0);
        }
        
        if (grow = true){
            grow = false;
        }
        
        this.worm.add(new Piece(newX, newY));
    }

    public void grow() {
        this.grow = true;
    }

    public boolean runsInto(Piece piece) {
        for (int i = 0; i < getLength(); i++){
            if (this.worm.get(i).getX() == piece.getX() && this.worm.get(i).getY() == piece.getY()){
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < getLength() - 1; i++){
            if (this.worm.get(i).getX() == wormTip().getX() && this.worm.get(i).getY() == wormTip().getY()){
                return true;
            }
        }
        return false;
    }
    
    public Piece wormTip(){
        return this.worm.get(getLength() - 1);
    }
}
