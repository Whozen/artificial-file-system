public class ResizeVisitor implements Visitor { 
    
    public void visit(Directory directory) { 
        throw new UnsupportedOperationException();
    }

    public void visit(Directory directory, FileSystem fs) {
    	throw new UnsupportedOperationException();
    }
    
    public void visit(Directory directory, FileSystem fs, int real) { 
        throw new UnsupportedOperationException();
    }


    public void visit(File file) { 
        throw new UnsupportedOperationException();
    } 
   	
    //Call the function reSize with argument newSize from the FileSystem file passed in the parameter
   	public void visit(File file, int newSize) { 
        file.reSize(newSize);
    }
} 