interface LibraryCatalog{

    //Returns true for success, false for failure
    public abstract boolean deleteBook(String loc);

    //Returns true for success, false for failure
    public abstract boolean addBook(Book book);

    //Return a book object.
    public abstract String searchBook(String title);


}