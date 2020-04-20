public class File extends FileSystem {
	
	String fileName;
	int fileSize;
	
	//Constructor
	public File(String newFileName, int newFileSize){
		fileName = newFileName;
		fileSize = newFileSize;
	}
	
	//Get File Name
	public String getName() { 
		return fileName;
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