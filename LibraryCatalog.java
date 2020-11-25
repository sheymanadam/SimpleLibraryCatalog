abstract class LibraryCatalog{

    //Returns true for success, false for failure
    public abstract boolean deleteBook();

    //Returns true for success, false for failure
    public abstract boolean addBook();

    //Return the id of the book as a string.
    //I'm open to returning a book object too.
    public abstract String searchBook();
}