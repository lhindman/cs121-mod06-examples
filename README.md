# CS121 - Module 6 - Writing Classes Guided Experimentation
The purpose of this guided experimentation is to provide students with an opportunity to experiment with the code examples presented in the lecture. It is important to keep detailed observation notes as you work through the experiments below. These observations will be useful to you as you complete the labs and you will be allowed to reference them on open book / open note quizzes. You will not be required to turn in your observations.
## Getting Started
To get started on this activity, please clone this repository into your development environment  

Steps to Clone Examples
1. Copy the URL for this repo by clicking the green "Code" button above, select HTTPS then click the copy icon.
2. Open VSCode, click the Source Control icon then click Clone Repository.
3. Pasted the repo URL into the "Provide repository URL" field and press Enter
4. Browse to the location in your development environment where you want to store the repostory and click Select Repository Location.
5. When prompted, Open the repository then Open the workspace

## Static Method Experimentation
1. Open *StaticFun.java* and *Utility.java*, read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Add the following two static methods to Utility.java.  Study both methods carefully to understand what they are doing.
    ```
    public static void numDoubler1(int x) {
        x = x * 2;
    }

    public static int numDoubler2(int x) {
        x = x * 2;
        return x;
    }
    ```
 
    - Add the following code to the end of the main method in StaticFun.java. What effect do the calls to numDoubler1() and numDoubler2() have on the value of myNum?, why?  
    ```
    int myNum = 2;

    Utility.numDoubler1(myNum);
    System.out.println("Value of myNum after calling numDoubler1: " + myNum);

    myNum = Utility.numDoubler2(myNum);
    System.out.println("Value of myNum after calling numDoubler2: " + myNum);
    ```
    
1. Open *StaticFun.java* and *Utility.java*, read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Add the following static method to Utility.java.  To build successfully, don't forget to import the **java.awt.point** class. Study the method carefully to understand what it is doing.
    ```
    public static void pointDoubler(Point p) {
        p.x = p.x * 2;
        p.y = p.y * 2;
    }
    ```
 
    - Add the following code to the end of the main method in StaticFun.java. Were the values of x and y inside the Point object modified by the pointDoubler() method even though it doesn't have a return value? What is the difference between passing in an object as a argument to a method vs passing in a primitive data type such as an int?  
    ```
    Point myPoint = new Point(2,3);

    System.out.println("Value of point before doubling: " + myPoint);
    Utility.pointDoubler(myPoint);
    System.out.println("Value of point after doubling: " + myPoint);
    ```
      
## ArrayList Experimentation
1. Open *MyRainbow.java*, read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Add three additional color objects to the rainbow immediately after ORANGE, YELLOW and PINK are added. Run the program and record how how affect the result of the list size as well as where in the list your colors were added.  To make this easier to record, you may temporarily *comment out* the code in the *working with loops* section.
    ```
    rainbow.add(Color.GREEN);
    rainbow.add(Color.BLUE);
    rainbow.add(Color.BLACK);
    ```
    - Notice in the constructor for the Arraylist, we *tagged* our rainbow ArrayList with the **Color** class. Let's see what happens when we an object that is not of type Color. Use the code below to add a String to our rainbow and make of note of the line number where you add the String. To make this easier to record, you may temporarily *comment out* the code in the *working with loops* section. Attempt to run the program and student the java output (stack trace) carefully.  Notice that it not only tells you exactly what is wrong, but also the line where the issue is detected.  Record your observations.
    ```
    rainbow.add("Purple");
    ```

    - Revert the code changes made in the previous steps.  Click the *Source Control* icon then select *MyRainbow.java* from the list of changes. Hover over the icons beside the filenames to find the icon labelled **Discard Changes**, then click it. This will revert all the code changes to MyRainbow.java back to the last commit.  Please be careful if you choose to use this functionality when working in your lab activities.


    - Modify the *rainbow.remove(0)* line as follows to intentionally remove a item that does not exist in the ArrayList, and make a note of the line number. Study the Java output (stacktrace) carefully noting the type of exception, the index value that cause the exception and the line number in MyRainbow where the exception was detected. Record your observations.
    ```
    rainbow.remove(199);
    ```

## File Parsing Experimentation
1. Open *FileEcho.java*, read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Reading a file line-by-line is a common way to process text data.  To help reinforce this idea, use the following code to modify the existing display loop so that it prepends line numbers to each line of text before displaying it in the console. Experiment by using it to read a number of files, including FileEcho.java. Compare the line numbers in VSCode against those reported by FileEcho.  Record your observations.
    ```
    int lineNumber = 1;
    while (fileScan.hasNextLine()) {
        String line = fileScan.nextLine();

        System.out.printf("%5d | %s\n",lineNumber,line);

        lineNumber++;
    }
    ```
           
1. Open *CSVParser.java*, read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Students often struggle with the CSVParser example because it uses two different types of Scanner objects, one to scan the File line-by-line and other other to process each individual line to extract the data fields. To help reienforce this idea of processing the CSV file line, use the following code to modify the existing loop to output line numbers preceeding the unprocessed CSV data before displaying it in the console.
    ```
        /* 3. Create a loop to read each line from the Scanner */
        int lineNumber = 1;
        while(bobsScanner.hasNextLine()) {
            String line = bobsScanner.nextLine();

            /* 4. Print each line */
            System.out.printf("Processing Line %3d: %s\n",lineNumber,line);
            lineNumber++;

            ...
    ```
    - When working with CSV data files, each line of the file contains *data fields* that are separate by commas. Modify the print statements as shown below, replacing the data labels with their cooresponding field number. Record your observations.
    ```
	/* 7. Print each song */
    System.out.println("**************************");
    System.out.println("CSV Field 1:" + artist);
    System.out.println("CSV Field 2:" + album);
    System.out.println("CSV Field 3: " + title);
    System.out.println("CSV Field 4: " + duration);
    System.out.println("**************************");
    ```

    - Revert the code changes made in the previous steps.  Click the *Source Control* icon then select *CSVParser.java* from the list of changes. Hover over the icons beside the filenames to find the icon labelled **Discard Changes**, then click it. This will revert all the code changes to CSVParser.java back to the last commit.  Please be careful if you choose to use this functionality when working in your lab activities.
    - The order that we read the fields using the scanner matters.  We know that the artist is the first field, so we assign the string value of the first call to *next()* to a variable called **artist**.  We know that the title is the third field so we assign the value returned by the third call to *next()* to **title**.  Modify the field extraction code as shown below, swapping the artist and title lines, then run the program.  What has changed in the output?  Why?
    ```
    /* 6. Extract the individual fields from each line */
    String title = bobsLineScanner.next();
    String album = bobsLineScanner.next();
    String artist = bobsLineScanner.next();
    int duration = bobsLineScanner.nextInt();
    ```
    - Often times there are more fields than we need in the CSV data and we only want to work with a single field.  To do this, we can use a while loop to step through each field in the line and a filter value to allow us to work with specific fields. Modify the while loops as shown in the code below to enable filtering the output to a specified field. Experiment with setting the field filter to values of 1 through 5 record the values that are output for each (artist, album, title, duration).
    ```
	/* 3. Create a loop to read each line from the Scanner */
	int fieldFilter = 3;
	while(bobsScanner.hasNextLine()) {
		String line = bobsScanner.nextLine();

		Scanner lineScanner = new Scanner (line);
		lineScanner.useDelimiter(",");

		int fieldCounter = 1;
		while (lineScanner.hasNext()) {
			String field = lineScanner.next();
			if(fieldCounter == fieldFilter) {
				System.out.println("CSV Field " + fieldCounter + ": " + field);
			}
			fieldCounter++;
		}
		lineScanner.close();
	}
   ```
