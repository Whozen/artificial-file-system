public class FileIterator{
	
	FileSystem fileList;
	
	//Constructor
	public FileIterator(FileSystem newFileList){
		fileList = newFileList;
	}
	
	//Display all the files in the fileList
	public void getFileList(){	
		fileList.displayFileInfo();
	}
	
}