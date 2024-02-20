/**
* Author: Angela Burns
* November 5, 2018
* project 4
*/

package turtle;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.lang.Math;
import javax.swing.text.html.StyleSheet;

	public class Turtle {
	
		private double xCord, yCord;
		private double direction;
		private boolean penDown;
		private Color color;
	
		public Turtle() {
			int CANVAS_SIZE = 500;
			StdDraw.setCanvasSize(CANVAS_SIZE,  CANVAS_SIZE);
			StdDraw.setXscale(0, CANVAS_SIZE);
	        StdDraw.setYscale(0, CANVAS_SIZE);
	        xCord = CANVAS_SIZE/2;
	        yCord = CANVAS_SIZE/2;
	        direction = 0;
	        color = (StdDraw.BLACK);
	        StdDraw.setPenColor(color); 
	    }
		
		
		public void right (double angle) {
			direction = 0; //reset angle to zero
			direction -= (angle - 90) % 360; 
		}
		
		
		public void left (double angle) {
			direction = 0; //reset angle
			direction = (angle + 90) % 360 ; 
			} 
		
		
		public void penUp () {
			penDown = false; 
		}
		
		
		public void penDown (){
			penDown = true; 
		}
		
		
		public void setPenColor (String color){	
			StyleSheet type = new StyleSheet();
			this.color = type.stringToColor(color);
			StdDraw.setPenColor(this.color); 
		}
		
		
		public void forward(int steps){
			
		//initialize old x and y variables (needed for line 
			double oldX = xCord;
	    	double oldY = yCord;
	    
	    //To initialize the "turtle"
	    	if (steps == 0) {
    		StdDraw.circle(xCord, yCord, 20);
    		StdDraw.text(xCord, yCord, "Start");
	    	}
	    
	    //to move +30 in the given direction
	    	for (int i = 0; i < steps; i++ ) {
	    		xCord += 30 * Math.cos(Math.toRadians(direction));
	    		yCord += 30 * Math.sin(Math.toRadians(direction));	
	    		
	    		//draws the final location larger than steps
	    		if (i == (steps-1)) {
	    			StdDraw.filledCircle(xCord, yCord, 15);
	    		}
	    		//draws the smaller steps
	    		else {
	    			StdDraw.filledCircle(xCord, yCord, 10);
	    		}
	    	}
	    	
	     //draws line to connect steps
	        if (penDown) 
	        {	StdDraw.setPenRadius(.005); //the default size was to small to be seen with lighter colors
	        	StdDraw.line(oldX, oldY, xCord, yCord); } 
		}
		

	
}