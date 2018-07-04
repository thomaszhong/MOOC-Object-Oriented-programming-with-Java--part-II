/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Thomas Zhong
 */
public class CompoundFigure extends Figure {

    private ArrayList<Figure> figureList;

    public CompoundFigure(int x, int y) {
        super(0, 0);
        this.figureList = new ArrayList<Figure>();
    }

    public CompoundFigure() {
        super(0, 0);
        this.figureList = new ArrayList<Figure>();
    }

    @Override
    public void draw(Graphics graphics) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Figure figure : this.figureList) {
            figure.draw(graphics);
        }
    }

    public void add(Figure f) {
        this.figureList.add(f);
    }

    @Override
    public void move(int dx, int dy) {
        for (Figure figure : this.figureList) {
            figure.move(dx, dy);
        }
    }
}
