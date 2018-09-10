package nvd.hasan.dxball;

public class Brick {
    private int brickTopX;
    private int brickTopY;
    private int brickHeight;
    private int brickWidth;

    public Brick(int brickTopX, int brickTopY, int brickHeight, int brickWidth) {
        this.brickTopX = brickTopX;
        this.brickTopY = brickTopY;
        this.brickHeight = brickHeight;
        this.brickWidth = brickWidth;
    }

    public int getBrickTopX() {
        return brickTopX;
    }

    public void setBrickTopX(int brickTopX) {
        this.brickTopX = brickTopX;
    }

    public int getBrickTopY() {
        return brickTopY;
    }

    public void setBrickTopY(int brickTopY) {
        this.brickTopY = brickTopY;
    }

    public int getBrickHeight() {
        return brickHeight;
    }

    public void setBrickHeight(int brickHeight) {
        this.brickHeight = brickHeight;
    }

    public int getBrickWidth() {
        return brickWidth;
    }

    public void setBrickWidth(int brickWidth) {
        this.brickWidth = brickWidth;
    }
}
