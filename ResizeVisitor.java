public class ResizeVisitor implements Visitor { 
   
   	public void visit(File file, int newSize) { 
        file.reSize(newSize);
    } 
    
    public void visit(Directory directory) { 
        throw new UnsupportedOperationException();
    }

    public void visit(Directory directory, FileSystem fs) {
    	throw new UnsupportedOperationException();
    }

    public void visit(File file) { 
        throw new UnsupportedOperationException();
    } 
   	
} 