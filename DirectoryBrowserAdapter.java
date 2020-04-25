public class DirectoryBrowserAdapter implements DirectoryTreeDisplay {
	private FileBuilderFactory fileBuilder;

	//Constructor
	public DirectoryBrowserAdapter(FileBuilderFactory fb){
		this.fileBuilder = fb;   	
	}

	public void display() {
		this.fileBuilder.ls(null);
		//System.out.println("Hi");
	}
}