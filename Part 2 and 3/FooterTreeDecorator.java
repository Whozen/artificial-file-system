public class FooterTreeDecorator extends TreeDecorator {
	//Constructor
	public FooterTreeDecorator(DirectoryTreeDisplay dirTree){
		super(dirTree);   	
	}

	//Integrate the footer design to the File Structure Heirarchy
	public void display() {
		super.display();
		this.printFooter();
	}

	//Design for the footer
	public void printFooter() {
		System.out.println("-----------------Footer-----------------\n--------File Structure Heirarchy--------\n");
	}
}