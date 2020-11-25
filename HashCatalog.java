
class HashCatalog implements LibraryCatalog{

    @Override
    public boolean deleteBook(String loc){
        System.out.println("Delete book with loc of "+loc);
        return true;
    }

    @Override
    public Book searchBook(String title){
        Book book = new Book();
        System.out.println("Got "+title);
        return book;
    }

    @Override
    public boolean addBook() {
        System.out.println("HELLO WORLD");
        return false;
    }
}