public class FileJockey{
	
	FileSystem fileList;
	
	// newFileList contains every Song, SongGroup,
	// and any Songs saved in SongGroups
	
	public FileJockey(FileSystem newFileList){
		
		fileList = newFileList;
		
	}
	
	// Calls the displaySongInfo() on every Song
	// or SongGroup stored in fileList
	
	public void getFileList(){
		
		fileList.displayFileInfo();
		
	}
	
}