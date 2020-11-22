
class SimpleLibraryCatalog{

    public static void main(String args[]){

        MarcImport mi = new MarcImport();
        int recCount = mi.read("2213.mrc");
        System.out.println("Obtained " + Integer.toString(recCount) + " records.");
    }

}