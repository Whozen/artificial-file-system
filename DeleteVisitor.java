public class DeleteVisitor implements Visitor { 
   	
   	public void visit(Directory directory) { 
        throw new UnsupportedOperationException();
    } 

    public void visit(Directory directory, FileSystem fs) { 
        directory.remove(fs);
    } 

    public void visit(File file) { 
        throw new UnsupportedOperationException();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
   
} 