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
  
  Random gen = new Random();
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

  
  
  public void copyZucc(Picture p, int x, int y)
  {
      Picture sourcePicture = p;

      Pixel sourcePixel = null;
      Pixel targetPixel = null;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns

      for(int sourceX = 0, targetX = x ; sourceX < sourcePicture.getWidth() ; sourceX++, targetX++)
      {
          for(int sourceY = 0, targetY = y ; sourceY < sourcePicture.getHeight() ; sourceY++, targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
              targetPixel = this.getPixel(targetX, targetY);
              targetPixel.setColor(sourcePixel.getColor());
          }
      }
  }
  
  /**
   * Mirror along vertical line
   */
  public void mirrorVertical()
  {
      int width = this.getWidth();
      int mirrorPoint = width/2;
      
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //loop rowns
      for(int y = 0 ; y < getHeight() ; y++)
      {
          //loop column 0 to mid
          for(int x = 0 ; x < mirrorPoint ; x++)
          {
              leftPixel = getPixel(x,y);
              rightPixel = getPixel(width - 1 - x, y);
              rightPixel.setColor(leftPixel.getColor());
            }
    }
}

  public void mirrorVertical2()
  {
      int width = this.getWidth();
      int mirrorPoint = width/2;
      
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      //loop rowns
      for(int y = 0 ; y < getHeight() ; y++)
      {
          //loop column 0 to mid
          for(int x = 0 ; x < mirrorPoint ; x++)
          {
              leftPixel = getPixel(x,y);
              rightPixel = getPixel(width - 1 - x, y);
              leftPixel.setColor(rightPixel.getColor());
            }
    }
}

public void mirrorVerticalFull()
  {
      int width = this.getWidth();
      int mirrorPoint = width/2;
      
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Color col = null;
      Color temp = null;
      
      //loop rowns
      for(int y = 0 ; y < getHeight() ; y++)
      {
          //loop column 0 to mid
          for(int x = 0 ; x < mirrorPoint ; x++)
          {
              leftPixel = getPixel(x,y);
              rightPixel = getPixel(width - 1 - x, y);
              temp = leftPixel.getColor();
              col = new Color(temp.getRed(), temp.getGreen(), temp.getBlue());
              leftPixel.setColor(rightPixel.getColor());
              rightPixel.setColor(col);
              
            }
    }
}

/**
 * Mirror along middle horizontal line
 */
public void mirrorHorizontal()
{
    int height = this.getHeight();
    int mirrorPoint = height/2;
    
    Pixel topPixel = null;
    Pixel botPixel = null;
    
    //loop rows
      for(int y = 0 ; y < mirrorPoint ; y++)
      {
          //loop column 0 to mid
          for(int x = 0 ; x < getWidth() ; x++)
          {
              topPixel = getPixel(x,y);
              botPixel = getPixel(x, height - 1 - y);
              botPixel.setColor(topPixel.getColor());
            }
    }
}

public void recursivePasteRight(int interval)
{
      Picture sourcePicture = new Picture("images/zucc.png");

      Pixel sourcePixel = null;
      Pixel targetPixel = null;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns
      if (interval <= 24)
      {
          for(int sourceX = 0, targetX = (getWidth()/interval)*(interval-1) ; sourceX < sourcePicture.getWidth() ; sourceX+=interval, targetX++)
          {
              for(int sourceY = 0, targetY = 0 ; sourceY < sourcePicture.getHeight() ; sourceY+=interval, targetY++)
              {
                  sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                  targetPixel = this.getPixel(targetX, targetY);
                  targetPixel.setColor(sourcePixel.getColor());
              }
          }
          this.recursivePasteRight(interval*2);
        }
        else{
            return;
        }
}

public void recursivePasteRight(Picture p, int interval)
{
      Picture sourcePicture = p;

      Pixel sourcePixel = null;
      Pixel targetPixel = null;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns
      if (interval <= 24)
      {
          for(int sourceX = 0, targetX = (getWidth()/interval)*(interval-1) ; sourceX < sourcePicture.getWidth() ; sourceX+=interval, targetX++)
          {
              for(int sourceY = 0, targetY = 0 ; sourceY < sourcePicture.getHeight() ; sourceY+=interval, targetY++)
              {
                  sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                  targetPixel = this.getPixel(targetX, targetY);
                  targetPixel.setColor(sourcePixel.getColor());
              }
          }
          this.recursivePasteRight(interval*2);
        }
        else{
            return;
        }
}        

public void recursivePasteLeft(Picture p, int interval)
{
      Picture sourcePicture = p;

      Pixel sourcePixel = null;
      Pixel targetPixel = null;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns
      if (interval <= 24)
      {
          for(int sourceX = 0, targetX = 0 ; sourceX < sourcePicture.getWidth() ; sourceX+=interval, targetX++)
          {
              for(int sourceY = 0, targetY = 0 ; sourceY < sourcePicture.getHeight() ; sourceY+=interval, targetY++)
              {
                  sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                  targetPixel = this.getPixel(targetX, targetY);
                  targetPixel.setColor(sourcePixel.getColor());
              }
          }
          this.recursivePasteLeft(p, interval*2);
        }
        else{
            return;
        }
}

public void randomPlacement()
{
    int pixNum = getHeight()*getWidth();
    Pixel orig = null;
    Pixel copy = null;
    while(pixNum > 0)
    {
        orig = getPixel(gen.nextInt(getWidth()-1), gen.nextInt(getHeight()-1));
        copy = getPixel(gen.nextInt(getWidth()-1), gen.nextInt(getHeight()-1));
        copy.setColor(orig.getColor());
        pixNum--;
    }
}

public void lizardIFY()
{
    Pixel pixel = null;
    Color col = null;
    double d;
    int green;
    //loop rows
      for(int y = 0 ; y < getHeight() ; y++)
      {
          //loop column 0 to mid
          for(int x = 0 ; x < getWidth() ; x++)
          {
              pixel = getPixel(x, y);
              col = pixel.getColor();
              d = (col.getGreen()*1.5);
              green = (int)d;
              if(green > 255)
              {
                  green = 255;
                }
              Color newCol = new Color(col.getRed(), green, col.getBlue());
              pixel.setColor(newCol);
            }
    }
}

public  void copySmall(String sf, int x, int y)
  {
      String sourceFile = sf;
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns

      for(int sourceX = 0, targetX = x ; sourceX < sourcePicture.getWidth() ; sourceX+=2, targetX++)
      {
          for(int sourceY = 0, targetY = y ; sourceY < sourcePicture.getHeight() ; sourceY+=2, targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
              targetPixel = this.getPixel(targetX, targetY);
              targetPixel.setColor(sourcePixel.getColor());
          }
      }
      
  }
  
  public void blend(String p)
  {
      Picture sourcePicture = new Picture(p);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      Color color1 = null;
      Color color2 = null;
      Color newCol = null;
      double r, b, g;
      int startX = 0;
      int startY = 0;
      if(getHeight() > sourcePicture.getHeight())
        startY = (getHeight() - sourcePicture.getHeight())/2;
      if(getWidth() > sourcePicture.getWidth())
        startX = (getWidth() - sourcePicture.getWidth())/2;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns

      for(int sourceX = 0, targetX = startX ; sourceX < sourcePicture.getWidth() ; sourceX++, targetX++)
      {
          for(int sourceY = 0, targetY = startY; sourceY < sourcePicture.getHeight() ; sourceY++, targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
              targetPixel = this.getPixel(targetX, targetY);
              color1 = targetPixel.getColor();
              color2 = sourcePixel.getColor();
              r = (color1.getRed()*.4) + (color2.getRed()*.6);
              g = (color1.getGreen()*.4) + (color2.getGreen()*.6);
              b = (color1.getBlue()*.4) + (color2.getBlue()*.6);
              newCol = new Color((int)r, (int)g, (int)b);
              targetPixel.setColor(newCol);
          }
      }
    }
    
    public void blend(Picture p)
  {
      Picture sourcePicture = p;

      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      Color color1 = null;
      Color color2 = null;
      Color newCol = null;
      double r, b, g;
      int startX = 0;
      int startY = 0;
      if(getHeight() > sourcePicture.getHeight())
        startY = (getHeight() - sourcePicture.getHeight())/2;
      if(getWidth() > sourcePicture.getWidth())
        startX = (getWidth() - sourcePicture.getWidth())/2;

      //width of source must be  = to or < than canvas I am copying to
      //loop through the columns

      for(int sourceX = 0, targetX = startX ; sourceX < sourcePicture.getWidth() ; sourceX++, targetX++)
      {
          for(int sourceY = 0, targetY = startY; sourceY < sourcePicture.getHeight() ; sourceY++, targetY++)
          {
              sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
              targetPixel = this.getPixel(targetX, targetY);
              color1 = targetPixel.getColor();
              color2 = sourcePixel.getColor();
              r = (color1.getRed()*.65) + (color2.getRed()*.35);
              g = (color1.getGreen()*.65) + (color2.getGreen()*.35);
              b = (color1.getBlue()*.65) + (color2.getBlue()*.35);
              newCol = new Color((int)r, (int)g, (int)b);
              targetPixel.setColor(newCol);
          }
      }
    }
    
    public void negativeZucc()
    {
        int colValue;
        Pixel [] pixels_arr;
        pixels_arr = this.getPixels();
        for (Pixel spot: pixels_arr)
        {
            colValue = spot.getRed();
            spot.setRed((colValue-255)*-1);
            colValue = spot.getBlue();
            spot.setBlue((colValue-255)*-1);
            colValue = spot.getGreen();
            spot.setGreen((colValue-255)*-1);
        }
    }
    
    public void all(Picture p)
    {
        mirrorVertical();
        mirrorHorizontal();;
        randomPlacement();
        lizardIFY();
        negativeZucc();
    }
    
    public void sheparFairey()
    {
        Pixel[] pixels_arr = getPixels();
        int value, total=0, b, s, interval;
        double avg;
        for (Pixel spot: pixels_arr)
        {
            value = spot.getRed();
            total = total + value;
            value = spot.getBlue();
            total = total + value;
            value = spot.getGreen();
            total = total + value;
            avg = total / 3;
            spot.setRed((int)avg);
            spot.setBlue((int)avg);
            spot.setGreen((int)avg);
            total = 0;
        }
        
        b = -1;
        s = 256;
        
        for (Pixel spot: pixels_arr)
        {
            value = spot.getRed();
            if (value > b)
            {
                b = value;
            }
            if (value < s)
            {
                s = value;
            }
        }
        
        interval = (b-s)/4;
        
        for (Pixel spot: pixels_arr)
        {
            value = spot.getRed();
            if (value <= interval + 15)
            {
                spot.setRed(0);
                spot.setBlue(47);
                spot.setGreen(0);
            }
            if (value <= (interval*2) && value > interval + 15)
            {
                spot.setRed(220);
                spot.setBlue(50);
                spot.setGreen(50);
            }
            if (value <= ((interval*3)-30) && value > (interval*2))
            {
                spot.setRed(71);
                spot.setBlue(71);
                spot.setGreen(213);
            }
            if (value > ((interval*3)-30))
            {
                spot.setRed(158);
                spot.setBlue(211);
                spot.setGreen(215);
            }
        }
    }
  
  
  
  
  

} // this } is the end of class Picture, put all new methods before this
