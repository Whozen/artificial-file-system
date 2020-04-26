public class File extends FileSystem {
	
	String fileName;
	int fileSize;
	
	//Constructor
	//Set name and size passed on as the arguments
	public File(String newFileName, int newFileSize){
		fileName = newFileName;
		fileSize = newFileSize;
	}
	
	//Return the name of the file
	public String getName() { 
		return fileName;
	}

	//Return the size of the File
	public int getSize() {
		return fileSize;
	}

	//Display File Name and Size
	public void printSize() {
		System.out.println(getName() + " of size " + getSize() + "\n");
	}
	
	//Display File Name and Size
	public void displayFileInfo(){
		System.out.println(getName() + " of size " + getSize() + "\n");
	}
	
}