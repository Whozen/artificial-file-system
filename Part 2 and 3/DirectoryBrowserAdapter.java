public class DirectoryBrowserAdapter implements DirectoryTreeDisplay {
	private FileBuilderFactory fileBuilder;

	//Constructor
	//Initializes the fileBuilder object with the currently running FileBuilder instance
	public DirectoryBrowserAdapter(FileBuilderFactory fb){
		this.fileBuilder = fb;   	
	}

	//Calls the displayFileHeirarchy function from the current FileBuilder object
	public void display() {
		this.fileBuilder.displayFileHeirarchy();
	}
}