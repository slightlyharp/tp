
import bookmark.InvalidBookmarkCommandException;

import bookmark.commands.AddLinkCommand;
import bookmark.commands.BackCommand;
import bookmark.commands.ChangeModeCommand;
import bookmark.commands.ListCommand;
import bookmark.commands.RemoveLinkCommand;
import bookmark.commands.BookmarkCommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BookmarkParserTest {

    @Test
    void evaluateInput_listCommand_parsedCorrectly() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = "list";
        final BookmarkCommand result = parser.evaluateInput(input);
        assertTrue(result.getClass().isAssignableFrom(ListCommand.class));
    }

    @Test
    void evaluateInput_changeModeCommand_parsedCorrectly() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = "bm 2";
        final BookmarkCommand result = parser.evaluateInput(input);
        assertTrue(result.getClass().isAssignableFrom(ChangeModeCommand.class));
    }

    @Test
    void evaluateInput_addCommand_parsedCorrectly() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = "add http://facebook.com";
        final BookmarkCommand result = parser.evaluateInput(input);
        assertTrue(result.getClass().isAssignableFrom(AddLinkCommand.class));
    }

    @Test
    void evaluateInput_removeCommand_parsedCorrectly() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = "rm 2";
        final BookmarkCommand result = parser.evaluateInput(input);
        assertTrue(result.getClass().isAssignableFrom(RemoveLinkCommand.class));
    }

    @Test
    void evaluateInput_backCommand_parsedCorrectly() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = "back";
        final BookmarkCommand result = parser.evaluateInput(input);
        assertTrue(result.getClass().isAssignableFrom(BackCommand.class));
    }

    @Test
    void evaluateInput_invalidBookmarkCommand_expectExceptions() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = "huhuhuh";
        assertThrows(InvalidBookmarkCommandException.class, () -> {
            parser.evaluateInput(input);
        });
    }

    @Test
    void evaluateInput_nullCommand_expectExceptions() throws InvalidBookmarkCommandException {
        BookmarkParser parser = new BookmarkParser();
        String input = null;
        assertThrows(InvalidBookmarkCommandException.class, () -> {
            parser.evaluateInput(input);
        });
    }
}