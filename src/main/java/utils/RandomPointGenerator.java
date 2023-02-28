package utils;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    Random random = new Random();

    @Override
    public boolean isPoint(boolean point) {
        return random.nextBoolean();
    }
}
//함수형 인터페이스 어노테이션
