package nvd.hasan.dxball;

public class Ball {
    private int ballCenterX;
    private int ballCenterY;
    private int ballRadius;

    public Ball(int ballCenterX, int ballCenterY, int ballRadius) {
        this.ballCenterX = ballCenterX;
        this.ballCenterY = ballCenterY;
        this.ballRadius = ballRadius;
    }

    public int getBallCenterX() {
        return ballCenterX;
    }

    public void setBallCenterX(int ballCenterX) {
        this.ballCenterX = ballCenterX;
    }

    public int getBallCenterY() {
        return ballCenterY;
    }

    public void setBallCenterY(int ballCenterY) {
        this.ballCenterY = ballCenterY;
    }

    public int getBallRadius() {
        return ballRadius;
    }

    public void setBallRadius(int ballRadius) {
        this.ballRadius = ballRadius;
    }

    public void ballPositionUpdate(int x, int y){
        setBallCenterX(x);
        setBallCenterY(y);
    }
}
