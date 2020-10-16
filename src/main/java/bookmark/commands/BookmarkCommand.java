package bookmark.commands;

import bookmark.BookmarkCategory;
import bookmark.BookmarkUi;
import exceptions.InvalidBookmarkLinkException;
import exceptions.InvalidEmptyLinkException;

import java.util.ArrayList;

public abstract class BookmarkCommand {
    public abstract void executeCommand(BookmarkUi ui, ArrayList<BookmarkCategory> categories);
}
