package nvd.hasan.dxball;

public class Bar {
    private int barTopX;
    private int barTopY;
    private int barHeight;
    private int barWidth;

    public Bar(int barTopX, int barTopY, int barHeight, int barWidth) {
        this.barTopX = barTopX;
        this.barTopY = barTopY;
        this.barHeight = barHeight;
        this.barWidth = barWidth;
    }

    public int getBarTopX() {
        return barTopX;
    }

    public void setBarTopX(int barTopX) {
        this.barTopX = barTopX;
    }

    public int getBarTopY() {
        return barTopY;
    }

    public void setBarTopY(int barTopY) {
        this.barTopY = barTopY;
    }

    public int getBarHeight() {
        return barHeight;
    }

    public void setBarHeight(int barHeight) {
        this.barHeight = barHeight;
    }

    public int getBarWidth() {
        return barWidth;
    }

    public void setBarWidth(int barWidth) {
        this.barWidth = barWidth;
    }

    public void barPositionUpdate(int topX, int topY){
        setBarTopX(topX);
        setBarTopY(topY);
    }
}
