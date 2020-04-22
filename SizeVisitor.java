public class SizeVisitor implements Visitor { 
   
    public void visit(Directory directory) { 
        directory.printSize();
    }

    public void visit(Directory directory, FileSystem fs) {
    	throw new UnsupportedOperationException();
    }

    public void visit(File file) { 
        file.printSize();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
   
} 