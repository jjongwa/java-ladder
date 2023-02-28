package utils;

public class FixedPointGenerator implements PointGenerator {
    private final int inputNum;

    public FixedPointGenerator(int inputNum) {
        this.inputNum = inputNum;
    }

    @Override
    public boolean isPoint(boolean point) {
        return inputNum == 1;
    }
}
