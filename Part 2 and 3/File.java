public class File extends FileSystem { 
    
    private String fileName;
    private int fileSize;
    private int delStatus = 0;
   
    //Constructor
    public File(String newFileName, int newFileSize){
        fileName = newFileName;
        fileSize = newFileSize;
    }

    //Accept a Visitor as parameter
    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    } 

    //Accept a Visitor and Integer as a paramter
    public void accept(Visitor visitor, int newSize) { 
        visitor.visit(this, newSize); 
    } 
    
    //Get File Name
    public String getName() { 
        return fileName;
    }

    //Get File Delete Status
    public int getDelStatus() { 
        return delStatus;
    }

    //Set File Delete Status
    public void setDelStatus(int newDelStatus) { 
        delStatus = newDelStatus;
    }

    //Get File Size
    public int getSize() {
        return fileSize;
    }

    //Resize File
    public void reSize(int newSize) {
        fileSize = newSize;
    }

    //Display File Size
    public void printSize() {
        System.out.println(getName() + " of size " + getSize() + "\n");
    }
    
    //Display the FileInfo
    public void displayFileInfo(){
        System.out.println(getName() + " of size " + getSize() + "\n");
    }
   
} 