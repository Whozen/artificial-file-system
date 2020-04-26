public class SizeVisitor implements Visitor { 
    
    //Call the function printSize from the Directory passed in the parameter
    public void visit(Directory directory) { 
        directory.printSize();
    }

    public void visit(Directory directory, FileSystem fs, int real) { 
        throw new UnsupportedOperationException();
    }

    public void visit(Directory directory, FileSystem fs) {
    	throw new UnsupportedOperationException();
    }

    //Call the function printSize from the File passed in the parameter
    public void visit(File file) { 
        file.printSize();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
   
} 