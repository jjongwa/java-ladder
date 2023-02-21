package view;

import domain.Results;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.PointStatus;
import domain.user.User;
import domain.user.Users;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_EXECUTE_MESSAGE = "\n사다리 결과\n";
    private static final String OUTPUT_RESULT_MESSAGE = "\n실행 결과";
    private static final String LINE_DELIMITER = "|";
    private static final String NAME_DELIMITER = " ";

    public void printResultByUser(int index, Results results, List<String> resultUsers) {
        System.out.println(OUTPUT_RESULT_MESSAGE);
        if (index == -1) {
            printAllUserResult(resultUsers, results);
            return;
        }
        System.out.println(results.getResults().get(index));
    }

    private void printAllUserResult(List<String> resultUsers, Results results) {
        for (int index = 0; index < results.getResults().size(); index++) {
            System.out.println(resultUsers.get(index) + " : " + results.getResults().get(index));
        }
    }

    public void printUserNames(Users users) {
        System.out.println(OUTPUT_EXECUTE_MESSAGE);
        System.out.println(" " + users.getUserNames()
                .stream()
                .map(this::convertName)
                .collect(Collectors.joining(NAME_DELIMITER)));
    }

    public void printResults(Results results) {
        System.out.println(" " + results.getResults()
                .stream()
                .map(this::convertName)
                .collect(Collectors.joining(NAME_DELIMITER)));
    }

    public String convertName(String name) {
        if (name.length() == User.MAX_NAME_LENGTH) {
            return name;
        }
        return insertBlank(name);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < User.MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        return nameBuilder.toString();
    }


    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(Line line) {
        for (boolean point : line.getPoints()) {
            printLineByPoint(point);
        }
    }

    private void printLineByPoint(boolean point) {
        System.out.print(PointStatus.printStatus(point, User.MAX_NAME_LENGTH));
        System.out.print(LINE_DELIMITER);
    }
}
