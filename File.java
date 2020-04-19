public class File extends FileSystem {
	
	String fileName;
	int fileSize;
	
	public File(String newFileName, int newFileSize){
		
		fileName = newFileName;
		fileSize = newFileSize;
		
	}
	
	public String getName() { return fileName; }
	public int getSize() { return fileSize; }
	
	public void displayFileInfo(){
		
		System.out.println(getName() + "  of size " +
				getSize() + '\n');
		
	}
	
}