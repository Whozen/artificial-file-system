public class ProxyDelete implements Visitor{

    private DeleteVisitor delVisitor;

    public void visit(Directory directory) { 
        throw new UnsupportedOperationException();
    }

    //This is a proxy of delete visitor. It initializes Delete Visitor and calls the delete function
    //with current Directory, File System to be deleted and integer 0, which indicates pretend to
    //delete as the parameter
    public void visit(Directory directory, FileSystem fs) { 
        if(delVisitor == null) {
            delVisitor = new DeleteVisitor();
        }

        delVisitor.visit(directory, fs, 0);
    } 

    public void visit(Directory directory, FileSystem fs, int real) { 
        throw new UnsupportedOperationException();
    } 


    public void visit(File file) { 
        throw new UnsupportedOperationException();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
}