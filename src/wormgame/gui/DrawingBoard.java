
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {
    
    private WormGame wormGame;
    private int pieceLength;
    
    public DrawingBoard(WormGame game, int pieceLength){
        this.wormGame = game;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); 
        
        for (Piece x : this.wormGame.getWorm().getPieces()){
            grphcs.setColor(Color.BLACK);
            grphcs.fill3DRect(this.pieceLength*x.getX(), this.pieceLength*x.getY(), this.pieceLength, this.pieceLength, true);
        }
        
        grphcs.setColor(Color.RED);
        grphcs.fillOval(pieceLength*wormGame.getApple().getX(), pieceLength*wormGame.getApple().getY(), pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
    
    
}
