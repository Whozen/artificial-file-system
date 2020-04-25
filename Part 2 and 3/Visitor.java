public interface Visitor {
    
    public void visit(Directory directory);
    
    public void visit(Directory directory, FileSystem fs);
    
    public void visit(Directory directory, FileSystem fs, int real);
    
    public void visit(File file);
    
    public void visit(File file, int newSize);
} 