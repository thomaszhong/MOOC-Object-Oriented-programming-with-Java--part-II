/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Xuwei Zhong
 */
public class Player {

    private int x;
    private int y;
    private int length;
    private int height;

    public Player(int length, int height) {
        this.x = 0;
        this.y = 0;
        this.length = length;
        this.height = height;
    }
    
    public void move(char command) {
        int tempx = this.x;
        int tempy = this.y;
        switch (command) {
            case 'w':
                this.y--;
                break;
            case 'a':
                this.x--;
                break;
            case 's':
                this.y++;
                break;
            case 'd':
                this.x++;
                break;
            default:
                break;
        }
        if (this.x >= this.length || this.x < 0 || this.y >= this.height || 
                this.y < 0) {
            this.x = tempx;
            this.y = tempy;
        }
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return "@ " + this.x + " " + this.y;
    }

}
