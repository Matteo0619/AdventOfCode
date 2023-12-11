package adventofcode.y2023.day11;

public class Galaxy {

    private int cordR;

    private int cordC;

    public Galaxy(int cordR, int cordC) {
        this.cordR = cordR;
        this.cordC = cordC;
    }

    public int getCordR() {
        return cordR;
    }

    public void setCordR(int cordR) {
        this.cordR = cordR;
    }

    public int getCordC() {
        return cordC;
    }

    public void setCordC(int cordC) {
        this.cordC = cordC;
    }
}
