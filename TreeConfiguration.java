public class TreeConfiguration {

	public static DirectoryTreeDisplay getDecoratedTree(FileBuilderFactory fb) {
		return
			new HeaderTreeDecorator(
			new FooterTreeDecorator(
			new DirectoryBrowserAdapter(fb) ));
	}
}