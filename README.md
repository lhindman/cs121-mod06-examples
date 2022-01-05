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

## Class Basics Experimentation
1. Open *Account.java* and *Transactions.java*, read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Visibility modifiers support the principle of encapsulation by restricting access to instance variables. Chance the visibility of the balance instance variable in the Account class from private to public. Then update Transactions.java with the code below to modify the account balance, bypassing the deposit() method entirely. Would this update to the account balance have been possible using the deposit() accessor method?  Record your observations.
    ```
      double balance = acct2.deposit(75.25);
      System.out.println("Mary's balance after deposit: " + balance);
      System.out.println("Mary's balance after withdrawal: " + acct2.withdraw(480, 1.50));
      
      acct2.balance = -1000000;
      System.out.println("Mary's balance after account hack: " acct2.getBalance());
      
    ```
 
    - With the above modifications still in place, change the visibility of the balance instance variable back to private and run the program again.  What is the result and why?

## Interface Experimentation (GameOfDice)
In the deeper look videos, we discussed that when a class *implements* an interface they are guaranteeing that objects created from that class provide certain methods. Java check for this at compile time, but also provides the ***instanceof*** operator so that we can also check at runtime. Let's have some fun. :)
1. Open *Die.java* and *GameOfDice.java*, read the code and run it to ensure it functions properly. Also study the contents of the interface defined in Rollable.java. Then work through each of the experiments below and record your observations.
    - Modify the main() method in GameOfDice.java to confirm at runtime that the Die object is Rollable as shown below. Are die1 and die2 in fact instances of the Rollable interface?
    ```
	Die die1 = new Die();
	if ( (die1 instanceof Rollable) == false) {
	    System.out.println("Error: Object is not Rollable");
	    System.exit(1);
	}

	Die die2 = new Die(64);
	if ( (die2 instanceof Rollable) == false) {
	    System.out.println("Error: Object is not Rollable");
	    System.exit(1);
	}
    ```
    
    - In addition to the Rollable interface, the Die class also implements the Comparable interface. Add the following code to the main() method of GameOfDice.java to check if the Die object is Comparable.
    ```
	if ( (die1 instanceof Comparable) == false) {
	    System.out.println("Error: Object is not Comparable");
	    System.exit(1);
	}

	if ( (die2 instanceof Comparable) == false) {
	    System.out.println("Error: Object is not Comparable");
	    System.exit(1);
	}
    ```
 
    - Modify the Die class as shown below so that it no longer implements the Rollable interface and run the program. What is the result? The Die class still has a roll() method. Is that sufficient for it to be an instance of the Rollable or must it explicitly state that it implements the Rollable interface?
    ```
	public class Die implements Comparable<Die>{
    ```
      
## Static Instance Variable Experimentation (CupOfDice)
1. Open *Die.java*, *CupOfDice.java* and *CupOfDiceDriver.java* read the code and run it to ensure it functions properly.  Then work through each of the experiments below and record your observations.
    - Modify the faceValue instance variable in the Die class as shown below, making it static. Run the CupOfDiceDriver again and record the results.
    ```
    private static int faceValue;
    ```
    - When an instance variable has the static modifier specified as we did above, the variable becomes a class variable instead of an instance variable. An instance variable has memory allocated with each object (instance of the class) to hold the data.  However, a class variable has memory allocated within the class itself and this memory shared, in essence becoming a single variable that is shared between all instances of the class. Think about how changing the faceValue to static changed its behavior and record whether this makes sense given your understanding of instance variables vs class variables.

    - After changing faceValue from an instance variable to a class variable, you likely noticed a number of warning messages similar to the following:
    ```
    The static field Die.faceValue should be accessed in a static way
    ```
    This is a result of using the *this* operator to access faceValue.  The *this* operator means, THIS instance and since it is no longer an instance variable, it is no longer appropriate to access faceValue using the *this* operator.  Instead, replace all occurrances of **this.faceValue** with **Die.faceValue** and run the program again. Did this resolve the compilation warnings?


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
