public class FooterTreeDecorator extends TreeDecorator {
	//Constructor
	public FooterTreeDecorator(DirectoryTreeDisplay dirTree){
		super(dirTree);   	
	}

	public void display() {
		super.display();
		this.printFooter();
	}

	public void printFooter() {
		System.out.println("This is the footer\n");
	}
}