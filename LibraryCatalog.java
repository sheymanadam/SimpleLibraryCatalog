interface LibraryCatalog{

    //Returns true for success, false for failure
    public abstract boolean deleteBook();

    //Returns true for success, false for failure
    public abstract boolean addBook();

    //Return a book object.
    public abstract Book searchBook(String title);


}