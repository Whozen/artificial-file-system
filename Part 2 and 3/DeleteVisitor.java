public class DeleteVisitor implements Visitor { 
   	
   	public void visit(Directory directory) { 
        throw new UnsupportedOperationException();
    } 

    public void visit(Directory directory, FileSystem fs) { 
        throw new UnsupportedOperationException();
    }

    //Call the function remove with arguements as FileSystem fs and integer real from the 
    //FileSystem directory passed in the parameter
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