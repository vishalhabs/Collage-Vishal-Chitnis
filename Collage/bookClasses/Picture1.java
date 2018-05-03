import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

  public void gray()
  {
	  Pixel[] pixelArray = this.getPixels();
	  int i;
	  for(Pixel p : pixelArray)
	  {
		  i = (int)((p.getRed() + p.getBlue() + p.getGreen())/3);
		  Color col = new Color(i, i, i);
		  p.setColor(col);
	  }
  }

  public void copyZucc(String sf)
  {
	  String sourceFile = sf;
	  Picture sourcePicture = new Picture(sourceFile);

	  Pixel sourcePixel = null;
	  Pixel targetPixel = null;

	  //width of source must be  = to or < than canvas I am copying to
	  //loop through the columns

	  for(int sourceX = 0, targetX=0 ; sourceX < sourcePicture.getWidth() ; sourceX++, targetX++)
	  {
		  for(int sourceY = 0, targetY = 0 ; sourceY < sourcePicture.getHeight() ; sourceY++, targetY++)
		  {
			  sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
			  targetPixel = this.getPixel(targetX, targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
  }

} // this } is the end of class Picture, put all new methods before this
