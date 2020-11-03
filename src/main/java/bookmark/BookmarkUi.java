package bookmark;

import java.util.ArrayList;

public class BookmarkUi {

    public BookmarkUi() {

    }

    public static void printWelcomeBookmarkMessage() {
        System.out.println("Welcome to bookmark mode!");
        System.out.println("You can use this mode to bookmark your links for easier access!");
        System.out.println("\nChoose your category by typing \"bm <category index>!\"");
        System.out.println("Otherwise, insert \"help\" to find the list of commands available");
    }

    public void showBookmarkCategoryList(ArrayList<BookmarkCategory> bookmarkCategories) {
        System.out.println("Here are the categories available:");
        int i = 1;
        for (BookmarkCategory category: bookmarkCategories) {
            System.out.println(i + "." + category.getName());
            i++;
        }
    }

    public void showBookmarkLinkList(ArrayList<BookmarkList> links) {
        System.out.println("Bookmarks:");
        if (links.size() == 0) {
            System.out.println("<empty>");
        } else {
            int i = 1;
            for (BookmarkList link: links) {
                System.out.println("\t" + i + "." + link);
                i++;
            }
        }
    }

    public void printGoodbyeMessage() {
        System.out.println("Use \"exit\" to exit the mode or enter another category\n"
                + "using \"bm <category index>\"");
    }

    public void showBookmarkList(ArrayList<BookmarkCategory> categories) {
        showStarBookmarks(categories);
        System.out.println("Here is the list");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". Category: " + categories.get(i).getName());
            showBookmarkLinkList(categories.get(i).getLinks());
        }
    }

    public void showInvalidBookmarkCommand() {
        System.out.println("Invalid Bookmark commands");
    }

    public void printChooseCategoryMessage() {
        System.out.println("Please choose a category.");
    }

    public void showEmptyError(String item) {
        System.out.println("Empty " + item + " :(");
    }

    public void showInvalidError(String item) {
        System.out.println("Not a valid " + item + ", please enter a valid link.");
    }

    public void showInvalidNumberError() {
        System.out.println("Enter a number");
    }

    public void showModeChangeMessage(ArrayList<BookmarkCategory> categories, int categoryNumberInList) {
        System.out.println("You are now in " + categories.get(categoryNumberInList).getName() + " category");
        System.out.println("The following are your current bookmarks in this category");
        showBookmarkLinkList(categories.get(categoryNumberInList).getLinks());
        System.out.println("Add new bookmarks by using \"add <link>\"");
    }

    public void showAlreadyInModeMessage() {
        System.out.println("Already in chosen Category");
    }

    public void showStarBookmarks(ArrayList<BookmarkCategory> categories) {
        int i = 0;
        System.out.println("Starred bookmarks: ");
        for (BookmarkCategory category : categories) {
            for (BookmarkList link : category.getLinks()) {
                if (link.getStar()) {
                    i++;
                    System.out.println(i + "." + link);
                }
            }
        }
        if (i == 0){
            System.out.println("\t<empty>");
        }

    }

    public void showExistingBookmarkError(){
        System.out.println("Sorry your link already exist in your list!");
    }
}
