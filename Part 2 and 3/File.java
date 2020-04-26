public class File extends FileSystem { 
    
    private String fileName;
    private int fileSize;

    //This indicates the deletion status of the File. 
    //If it is set to zero, then the File has not been set to be deleted.
    //IF it is set to one, then it has been defered to be deleted.
    private int delStatus = 0;
   
    //Constructor
    //Set name and size passed on as the arguments
    public File(String newFileName, int newFileSize){
        fileName = newFileName;
        fileSize = newFileSize;
    }

    //Accept a Visitor as parameter and call the Visitors visit function. Pass self instance 
    //as the parameter
    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    } 

    //Accept a Visitor and Integer as a paramter. Pass self instance and the Integer which defines
    //the new file size as the parameter
    public void accept(Visitor visitor, int newSize) { 
        visitor.visit(this, newSize); 
    } 
    
    //Return the name of the File
    public String getName() { 
        return fileName;
    }

    //Return the Delete Status of the File
    public int getDelStatus() { 
        return delStatus;
    }

    //Set the File Delete Status
    public void setDelStatus(int newDelStatus) { 
        delStatus = newDelStatus;
    }

    //Return the size of the File
    public int getSize() {
        return fileSize;
    }

    //Set a new size to the current File
    public void reSize(int newSize) {
        fileSize = newSize;
    }

    //Display File Name and Size
    public void printSize() {
        System.out.println(getName() + " of size " + getSize() + "\n");
    }
    
    //Display the File Name and Size
    public void displayFileInfo(){
        System.out.println(getName() + " of size " + getSize() + "\n");
    }
   
} 