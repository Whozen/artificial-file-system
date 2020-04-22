public interface Visitor {
    void visit(Directory directory);
    void visit(Directory directory, FileSystem fs);
    void visit(File file);
    void visit(File file, int newSize);
} 