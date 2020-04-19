import java.util.Scanner; 

public class FileListGenerator {

	// public boolean isFile( String file ) {
	// 	if( file.contains(".txt") ) {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }
	
	public static void main(String[] args){
		int x = 0;

		// Top level component that holds everything
		FileSystem mainDir = new Directories("Main");
		FileSystem subDir;
		FileSystem subFile;
		FileSystem rootDir = mainDir;
		FileJockey showAll = new FileJockey(mainDir);
		FileJockey tempShowAll;

		FileSystem[] path = new FileSystem[10];
		path[0] = mainDir;
		int pathPointer = 0;
		//String parentName;

		while( x == 0 ) {
			Scanner sc = new Scanner(System.in);    //System.in is a standard input stream  
			System.out.print("Enter Command: ");  
			String ip = sc.nextLine();
			System.out.print("\n \n");  
			String[] cmd_arr = ip.split(" ");

			switch (cmd_arr[0]) {
				case "mkdir":
				    mainDir.add(new Directories(cmd_arr[1]));
				  	System.out.println( cmd_arr[1] + " Directory created\n" );
				    break;

				case "create":
					mainDir.add(new File(cmd_arr[1], Integer.parseInt(cmd_arr[2]) ) );
					break;

				case "cd":
					if( cmd_arr[1].equals("..") ) {
						path[pathPointer] = null;
						mainDir = path[--pathPointer];
						showAll = new FileJockey(mainDir);
						System.out.println("Directory Changed to " + mainDir.getName() + "\n");
					} else {
						subDir = mainDir.getFileSystem(cmd_arr[1]);
						mainDir = subDir;
						showAll = new FileJockey(mainDir);
						path[++pathPointer] = mainDir;
						System.out.println("Directory Changed to " + cmd_arr[1] + '\n');
					}

				    break;

				case "rmdir":
					subDir = mainDir.getFileSystem(cmd_arr[1]);
					mainDir.remove(subDir);

				    System.out.println( cmd_arr[1] + " Directory removed\n" );
				    break;

				case "del":
					if( cmd_arr[1].contains(".txt") ) {
						subFile = mainDir.getFileSystem(cmd_arr[1]);
						mainDir.remove(subFile);
					} else {
						subDir = rootDir.getFileSystem(cmd_arr[1]);
						subDir.removeAll();
					}
					break;

				case "size":
					if( cmd_arr[1].contains(".txt") ) {
						subFile = mainDir.getFileSystem(cmd_arr[1]);
						System.out.println( subFile.getSize() );
					} else {
						subDir = rootDir.getFileSystem(cmd_arr[1]);
						subDir.printSize();
					}
					break;

				case "ls":
					if( (cmd_arr.length == 2) && (cmd_arr[1].contains(".txt")) ) {
						subFile = mainDir.getFileSystem(cmd_arr[1]);
						System.out.println( subFile.getName() );
						System.out.println( subFile.getSize() );
					} else if( cmd_arr.length == 2 ) {
						subDir = rootDir.getFileSystem(cmd_arr[1]);
						tempShowAll = new FileJockey(subDir);
						tempShowAll.getFileList();
					} else {
						showAll.getFileList();
					}
					break;

			    case "exit":
			    	x++;
			    	break;
			    	
			    default:
			    	System.out.println("Incorrect Command\n");
			    	break;
			}	
		}
		

		// FileSystem appDoc = new Directories("App");
		
		// FileSystem courseDoc = new Directories("Course");
		
		// FileSystem codeDoc = new Directories("Code");

		// FileSystem cs41Doc = new Directories("CSci41");

		// FileSystem cs250Doc = new Directories("CSci250");
		
		// // Composite that holds individual groups of songs
		// // This holds Songs plus a Directories with Songs
		
		// mainDir.add(appDoc);
		// mainDir.add(courseDoc);
		// mainDir.add(codeDoc);

		// courseDoc.add(cs41Doc);
		// courseDoc.add(cs250Doc);

		// cs41Doc.add(new File("roster.txt", 30));
		// cs41Doc.add(new File("grade.txt", 40));
		// cs41Doc.add(new File("exam.txt", 50));

		// cs250Doc.add(new File("project1.txt", 20));
		// cs250Doc.add(new File("project2.txt", 40));
		// cs250Doc.add(new File("quiz1.txt", 30));
		
	}
	
}