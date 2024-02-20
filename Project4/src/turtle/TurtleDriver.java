/**
* Author: Angela Burns
* Project 4
* November 5, 2018
*/
package turtle;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TurtleDriver {
	
	public static final int CANVAS_SIZE = 400;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
			
		Turtle turtle = new Turtle();
		double angle = 0;
		int step = 0;
		String color = "null";
	
	//Array for the colors available 
		String [] StdDrawColors = new String [] {"black", "blue", 
				"green", "orange", "red", "yellow"};
		List<String> colorList = Arrays.asList(StdDrawColors);
		
	//COMANDS
		System.out.println("THE COMMANDS: ");
		System.out.print("		-->  Color \n"
				+ "		--> \"Up\" OR \"Down\" \n"
				+ "		--> \"Forward\" steps \n"  
				+ "		--> \"Right\" angle OR \"Left\" angle \n"

				+ "		or \n"
				+ "		-->\"Quit\" \n" );
		
		//displays starting point
		turtle.forward(0);

		
//BEGGINING - runs until the user quits
		while(true) {
			
		//gets the user input
			System.out.print("Enter a command: ");
			String input = scan.nextLine();
			input.toLowerCase();
		
			
	//LEFT
			//Assigns angle if it was entered  after left
			if  (input.contains("left")) {
					try {
						String [] line = input.split(" ");
						angle = Double.parseDouble(line [1]);
						//assigns angle to the direction
						turtle.left(angle);
					}
					catch(Exception e){
						System.out.println("	Invalid Entry.\n"
								+ "	nter \"left\" followed by a number.)");
					}
				}
			
			
	//RIGHT	
			//Assigns angle if it was entered with after
			else if (input.contains("right")) {
					try {
						String [] line = input.split(" ");
						angle = Double.parseDouble(line [1]);
					//assigns angle to the direction
						turtle.right(angle);
					}
					catch(Exception e){
						System.out.println("	Invalid Entry.\n"
								+ "	Enter \"right\" followed by a number." );
					}
			}
			
			
	//STEPS
			//assigns the step count if it was after the steps
			else if (input.contains("forward")) {
				//gets angle
					try {
						String [] line = input.split(" ");
						step = Integer.parseInt(line [1]);
						turtle.forward(step);
					}
					catch(Exception e){
						System.out.println("	Invalid Entry. \n"
								+ "	Enter \"forward\" followed by a number." );
					}
			}
			
	//UP
			else if (input.contains("up")) {
				turtle.penUp();
			}
			
			
	//DOWN
			else if (input.contains("down")) {
				turtle.penDown();
			}
			
			
	//COLOR
			//if an acceptable color was entered without "Color" prefix 
			else if (colorList.contains(input)) {
				color = input;
				color = input;
			turtle.setPenColor(color);
			}
			//if "color" was entered before the pen color
			else if (input.equals("color") || input.contains("color")) {
				try {
					String [] line = input.split(" ");
					color = line [1];
					if (! (colorList.contains(color))) {
						System.out.println("		Error. Invalid color entered. "
							+ "Availiable colors include: \n" + colorList );
						color = "null";
					}
					else 
						turtle.setPenColor(color);
				}
				catch (Exception e) {
					System.out.println("		Error. Invalid color entered. "
							+ "Availiable colors include: \n" 
							+ "		" +colorList );
			}
		}
	
		
	//QUIT
			else if (input.equals("quit")) {
				System.out.print("		The command \"QUIT\" was entered.\n"
						+ " 		    Turtle is now exiting. \n"
						+ "			   Thank you(:");
				System.exit(0);
			}
		
			
	//ERROR
			else {
				System.out.println("	Error. Invalid entry made. \n"
						+ "	Please retry the desired command.");
			}
			
//END 	
		}

}
}