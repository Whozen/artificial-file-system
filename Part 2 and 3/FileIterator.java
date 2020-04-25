public class FileIterator{
	
	FileSystem fileList;
	
	//Initialize the object with FileSystem passed as parameter
	public FileIterator(FileSystem newFileList){
		fileList = newFileList;
	}
	
	//Display all the files in the fileList
	public void getFileList(){	
		fileList.displayFileInfo();
	}
	
}