package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    public static final String HEIGHT_NOT_NUMBER = "[ERROR] 높이는 숫자로 입력해주세요.";

    static Scanner sc = new Scanner(System.in);

    public List<String> inputUserName() {
        System.out.println(INPUT_USER_NAME);
        return splitNameInput(sc.next());
    }

    private List<String> splitNameInput(String nameInput) {
        return List.of(nameInput.split(","));
    }

    public int inputLadderHeight() {
        try {
            System.out.println(INPUT_LADDER_HEIGHT);
            return sc.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            sc.nextLine();
            throw new IllegalArgumentException(HEIGHT_NOT_NUMBER);
        }
    }
}
