public class File extends FileSystem { 
    private String fileName;
    private int fileSize;
   
    //Constructor
    public File(String newFileName, int newFileSize){
        fileName = newFileName;
        fileSize = newFileSize;
    }

    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    } 

    public void accept(Visitor visitor, int newSize) { 
        visitor.visit(this, newSize); 
    } 
    
    //Get File Name
    public String getName() { 
        return fileName;
    }

    //Resize
    public void reSize(int newSize) {
        fileSize = newSize;
    }

    //Get File Size
    public int getSize() {
        return fileSize;
    }

    //Get File Size
    public void printSize() {
        System.out.println(getName() + " of size " + getSize() + "\n");
    }
    
    //Display the FileInfo
    public void displayFileInfo(){
        System.out.println(getName() + " of size " + getSize() + "\n");
    }
   
} 