public class LsVisitor implements Visitor { 
    
    //Call the function displayFileInfo from the FileSystem directory passed in the parameter
    public void visit(Directory directory) { 
        directory.displayFileInfo();
    }

    public void visit(Directory directory, FileSystem fs) {
    	throw new UnsupportedOperationException();
    }

    public void visit(Directory directory, FileSystem fs, int real) { 
        throw new UnsupportedOperationException();
    }

    //Call the function displayFileInfo from the FileSystem file passed in the parameter
    public void visit(File file) { 
        file.displayFileInfo();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
   
} 