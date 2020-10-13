import flashcard.Flashcard;
import flashcard.FlashcardRun;

public class StudyIt {
    private static Mode currentMode = Mode.MENU;

    public static void changeMode(Mode destinationMode) {
        currentMode = destinationMode;
    }

    public static Mode getCurrentMode() {
        return currentMode;
    }

    public static FlashcardRun flashcardRun = new FlashcardRun();

    public static void main(String[] args) {
        MainMenu.printWelcome();
        run();
    }

    public static void run() {
        CommandType commandType;
        // Repeatedly receive & process user command until "exit" is given
        do {
            // Collect user's command & identify the type
            String command = Ui.inputCommand();
            commandType = CommandParser.getCommandType(command);

            Command.executeCommand(command, commandType, flashcardRun);
        } while (commandType != CommandType.EXIT_PROGRAM);
    }
}