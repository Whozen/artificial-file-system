public class FileIterator{
	
	FileSystem fileList;
	
	public FileIterator(FileSystem newFileList){
		fileList = newFileList;
	}
	
	public void getFileList(){	
		fileList.displayFileInfo();
	}
	
}