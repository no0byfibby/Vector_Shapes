import java.util.Scanner;
import java.awt.*;

public class VectorShapes
{
    static Scanner enter = new Scanner(System.in);
    static int numShapes = 0;
    static int numMoves = 0;
    
    static String[] shapeStorage = new String[20];
    static boolean storageValid = false;
    
    static int[] shapeSizes = new int[20];

    static String[] shapeColors = new String[20];
    static boolean colorsValid = false;
    
    static int[] shapeMovement = new int[20];
    static boolean movementValid = false;    
    
    static int[] shapeSpeed = new int[20];
    static boolean speedValid = false; 
    
    static int[] shapeX = new int[20];
    static int[] shapeY = new int[20];
//Gets shape information with user inputs; has checks on each input with a corresponding global boolean, although not required for the project
public static void getShapeInformation(int numShapes){
    int i = 0;
    String shape;
    String color;
    int movement;
    int speed;
    while(i < numShapes){
    
    shape = enter.next();
    if(shape.equals("Square") || shape.equals("Circle")){storageValid = true;}
 else{storageValid = false;}
 if(storageValid == true){shapeStorage[i] = shape;}
 
 shapeSizes[i] = enter.nextInt();
 
 color = enter.next();
    if(color.equals("Red") || color.equals("Black") || color.equals("Cyan") || color.equals("Blue") || color.equals("Pink") || color.equals("Yellow") || color.equals("Green")
 || color.equals("Magenta") || color.equals("Orange") || color.equals("Dark_gray") || color.equals("Light_gray") || color.equals("Gray")
 ){colorsValid = true;}
 else{colorsValid = false;}
 if(colorsValid == true){shapeColors[i] = color;}
 
 movement = enter.nextInt();
 if(movement >= 0 && movement <= 7){movementValid = true;}
 else{movementValid = false;}
 if(movementValid == true){shapeMovement[i] = movement;}

 
 speed = enter.nextInt();
 if(speed <= 10 && speed >= 0){speedValid = true;}
 else{speedValid = false;}
 if(speedValid == true){shapeSpeed[i] = speed;}

    i++;}
    return;
}
//Gets the midpoint of the DrawingPanel based on user input, then based on size of the shape assigns the shape coordinates that center it at this said midpoint
public static void initialPosition(DrawingPanel mypanel, int w, int h, int numShapes){
boolean pShow = true;

for(int i = 0; i < numShapes; i++){
    shapeX[i] = ((w/2) - (shapeSizes[i]/2));
    shapeY[i] = ((w/2) - (shapeSizes[i]/2));
}

showShapes(mypanel, pShow, numShapes);
mypanel.sleep(100);
return;
}
//Shows all the shapes initially with the boolean pShow starting off as "true"
public static void showShapes(DrawingPanel mypanel, boolean pShow, int numShapes){
int i;
String currShape;

for(i = 0; i < numShapes; i++){
    if(pShow) {graphicsSetColor(mypanel, i);}
    else {setNoColor(mypanel);}
    
    currShape = shapeStorage[i];
    
    if(currShape.equals("Square")) {showSquare(mypanel, i, pShow);}
    else {showCircle(mypanel, i, pShow);}
    }
return;
}
//Simulates movement of the shapes, with a tenth of a second delay after each move; goes by "frames" as the shape is deleted in each iteration and replaced with it being at a new position based on the speed assigned to that shape
public static void showShapesMoving(DrawingPanel mypanel, int numMoves, int numShapes){
    boolean pShow;
    for(int i = 0; i < numMoves; i++){
        pShow = false;
        showShapes(mypanel, pShow, numShapes);
        changePositions(numShapes);
        pShow = true;
        showShapes(mypanel, pShow, numShapes);
        mypanel.sleep(100);
    }
    return;
}
//Implemented the extra credit directions 1, 3, 5 and 7
public static void changePositions(int numShapes){
    for(int i = 0; i < numShapes; i++){
        if(shapeMovement[i] == 0){shapeX[i] = shapeX[i] - shapeSpeed[i];}
        
        else if(shapeMovement[i] == 1){shapeY[i] = shapeY[i] - shapeSpeed[i]; shapeX[i] = shapeX[i] - shapeSpeed[i];}
                
        else if(shapeMovement[i] == 2){shapeY[i] = shapeY[i] - shapeSpeed[i];}

        else if(shapeMovement[i] == 3){shapeY[i] = shapeY[i] - shapeSpeed[i]; shapeX[i] = shapeX[i] + shapeSpeed[i];}
        
        else if(shapeMovement[i] == 4){shapeX[i] = shapeX[i] + shapeSpeed[i];}
                
        else if(shapeMovement[i] == 5){shapeX[i] = shapeX[i] + shapeSpeed[i]; shapeY[i] = shapeY[i] + shapeSpeed[i];}
        
        else if(shapeMovement[i] == 6){shapeY[i] = shapeY[i] + shapeSpeed[i];}
                
        else if(shapeMovement[i] == 7){shapeY[i] = shapeY[i] + shapeSpeed[i]; shapeX[i] = shapeX[i] - shapeSpeed[i];}
    }
    return;
}
//"Deletes" the previous frame of the shape to simulate movement
public static void setNoColor(DrawingPanel mypanel){
    Graphics mypen = mypanel.getGraphics();
    mypen.setColor(Color.WHITE);
    return;
}
//Sets the color of the shape based on user input
public static void graphicsSetColor(DrawingPanel mypanel, int i){
    Graphics mypen = mypanel.getGraphics();
    String oldColor = shapeColors[i];
    
    if(oldColor.equals("Red")){mypen.setColor(Color.RED);}
      else if(oldColor.equals("Blue")){mypen.setColor(Color.BLUE);}
      else if(oldColor.equals("Black")){mypen.setColor(Color.BLACK);}
      else if(oldColor.equals("Pink")){mypen.setColor(Color.PINK);}
      else if(oldColor.equals("Yellow")){mypen.setColor(Color.YELLOW);}
      else if(oldColor.equals("Green")){mypen.setColor(Color.GREEN);}
      else if(oldColor.equals("Magenta")){mypen.setColor(Color.MAGENTA);}
      else if(oldColor.equals("Orange")){mypen.setColor(Color.ORANGE);}
      else if(oldColor.equals("Dark_gray")){mypen.setColor(Color.DARK_GRAY);}
      else if(oldColor.equals("Light_gray")){mypen.setColor(Color.LIGHT_GRAY);}
      else if(oldColor.equals("Gray")){mypen.setColor(Color.GRAY);}
      else if(oldColor.equals("Cyan")){mypen.setColor(Color.CYAN);}

    return;
}
//If prompted to "delete" a frame by the boolean value pShow, it will color the outline white for this effect; otherwise it forms a frame around the already present shape
public static void showSquare(DrawingPanel mypanel, int i, boolean pShow){
    Graphics mypen = mypanel.getGraphics();
    mypen.fillRect(shapeX[i], shapeY[i], shapeSizes[i], shapeSizes[i]);
    if(pShow){
        mypen.setColor(Color.BLACK);
        mypen.drawRect(shapeX[i], shapeY[i], shapeSizes[i], shapeSizes[i]);
    }
    else{mypen.setColor(Color.WHITE);
    mypen.drawRect(shapeX[i], shapeY[i], shapeSizes[i], shapeSizes[i]);}
    return;
}
//Same as the showSquare method, but for oval shapes
public static void showCircle(DrawingPanel mypanel, int i, boolean pShow){
    Graphics mypen = mypanel.getGraphics();
        mypen.fillOval(shapeX[i], shapeY[i], shapeSizes[i], shapeSizes[i]);
    if(pShow){
        mypen.setColor(Color.BLACK);
        mypen.drawOval(shapeX[i], shapeY[i], shapeSizes[i], shapeSizes[i]);
    }
     else{mypen.setColor(Color.WHITE);
    mypen.drawOval(shapeX[i], shapeY[i], shapeSizes[i], shapeSizes[i]);}
     
    return;
}

 public static void main(String[] args) {
 
  System.out.println("Vector Shapes - written by Chinedum Akunne\n");
  System.out.println("Please input width, height of the panel, # of shapes, # of times to move followed by the shape, size, color, orientation, and speed of every shape:");

    int width = enter.nextInt();
    int height = enter.nextInt();
    numShapes = enter.nextInt();
    numMoves = enter.nextInt();
    
    DrawingPanel mypanel = new DrawingPanel(width, height);//DrawingPanel object to be used in all the methods, with user-specified dimensions
    
    getShapeInformation(numShapes); //Gets the user input of the panel width, height, # of shapes and # of moves, then each shapes form, size, color, direction and speed

    initialPosition(mypanel, width, height, numShapes); //Calculates the position of all shapes in refrence to the size of the panel and size of said shape
    
    showShapesMoving(mypanel, numMoves, numShapes); //Simulates movement with many methods
}
}
