public class DeleteVisitor implements Visitor { 
   	
   	public void visit(Directory directory) { 
        throw new UnsupportedOperationException();
    } 

    public void visit(Directory directory, FileSystem fs) { 
        throw new UnsupportedOperationException();
    }

    //Call the function remove with arguements as FileSystem fs and integer real from the 
    //FileSystem directory passed in the parameter. The integer real determines if it is real delete 
    //which is 1, or pretending to delete which is 0
    public void visit(Directory directory, FileSystem fs, int real) { 
        directory.remove(fs, real);
    } 

    public void visit(File file) { 
        throw new UnsupportedOperationException();
    }

    public void visit(File file, int newSize) { 
        throw new UnsupportedOperationException();
    }
   
} 