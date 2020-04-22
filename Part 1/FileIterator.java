public class FileIterator{
	
	FileSystem fileList;
	
	public FileIterator(FileSystem newFileList){
		fileList = newFileList;
	}
	
	//Display all the files in the fileList
	public void getFileList(){	
		fileList.displayFileInfo();
	}
	
}