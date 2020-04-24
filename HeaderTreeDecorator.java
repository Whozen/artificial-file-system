public class HeaderTreeDecorator extends TreeDecorator {
	//Constructor
	public HeaderTreeDecorator(DirectoryTreeDisplay dirTree){
		super(dirTree);   	
	}

	public void display() {
		this.printHeader();
		super.display();
	}

	public void printHeader() {
		System.out.println("This is the header\n");
	}
}