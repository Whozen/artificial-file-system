public class HeaderTreeDecorator extends TreeDecorator {
	//Constructor
	public HeaderTreeDecorator(DirectoryTreeDisplay dirTree){
		super(dirTree);   	
	}

	//Integrate the header design to the File Structure Heirarchy. It first calls its own 
	//printHeader function and then calls the base classes display function
	public void display() {
		this.printHeader();
		super.display();
	}

	//Displays header design
	public void printHeader() {
		System.out.println("--------File Structure Heirarchy--------\n-----------------Header-----------------\n");
	}
}