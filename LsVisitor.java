public class LsVisitor implements Visitor { 
   
    public void visit(Directory directory) { 
        directory.displayFileInfo();
    }

    public void visit(Directory directory, FileSystem fs, int real) { 
        throw new UnsupportedOperationException();
    }

    public void visit(Directory directory, FileSystem fs) {
    	throw new UnsupportedOperationException();
    }

    public void visit(File file) { 
        file.displayFileInfo();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
   
} 