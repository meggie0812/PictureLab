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
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
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
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  } //end zeroBlue()
  
  public void zeroRed()
  {
      Pixel[][] picture = this.getPixels2D();
      for(Pixel[] rows: picture)
      {
          for(Pixel p :rows)
          {
              //int red=p.getRed();
              p.setRed(0);//p.setRed(red-red);
          }
      }
  } //end zeroRed
  
  public void zeroGreen()
  {
      Pixel[][] picture = this.getPixels2D();
      for(Pixel[] rows: picture)
      {
          for(Pixel p: rows)
          {
              p.setGreen(0);
          }
      }
  }
  
  
  public void keepOnlyBlue()
  {
      zeroRed();
      zeroGreen();
  }
  
  public void keepOnlyRed()
  {
      zeroBlue();
      zeroGreen();
  }
  
  public void keepOnlyGreen()
  {
      zeroRed();
      zeroBlue();
  }
  
  public void negate()
  {
      Pixel[][] picture = this.getPixels2D();
      for(Pixel[] rows: picture)
      {
          for(Pixel p: rows)
          {
              p.setRed(255-p.getRed());
              p.setGreen(255-p.getGreen());
          }
      }
  }
  
  public void grayscale()
  {
      Pixel[][] picture = this.getPixels2D();
      for(Pixel[] rows: picture)
      {
          for(Pixel p: rows)
          {
              int gray=(p.getRed()+p.getBlue()+p.getGreen())/3;
              p.setRed(gray);
              p.setBlue(gray);
              p.setGreen(gray);
          }
      }
  }
  
  /**
   * method to make fish to be seen
   */
  
  public void fixUnderwater()
  {
      Pixel[][] picture = this.getPixels2D();
      for(int i=0; i<153; i++)
      {
          for(int j=150; j<478; j++)
          {
              
              if(picture[i][j].getRed()<23)
              {
                  picture[i][j].setRed(225);
              }
          }
      }
  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture diagnal */
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftBotPixel = null;
    Pixel rightTopPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;
    if(width>height)
    {
        for (int row = 0; row < height; row++)
        {
          for (int col = 0; col < row; col++)
          {
            leftBotPixel = pixels[row][col];
            rightTopPixel = pixels[col][row];
            rightTopPixel.setColor(leftBotPixel.getColor());
          }
        } 
    }
    else if(height>width)
    {
        for (int row = 0; row < width; row++)
        {
          for (int col = 0; col < row; col++)
          {
            leftBotPixel = pixels[row][col];
            rightTopPixel = pixels[col][row];
            rightTopPixel.setColor(leftBotPixel.getColor());
          }
        } 
    }
    
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
 
  /** Mirror just part of a picture of a temple */
  public void mirrorArms()
  {
    int mirrorPoint = 185;
    int mirrorPointRight = 195;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 159; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 104; col < 169; col++)
      {
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint + mirrorPoint - row]                       
                         [col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    
    for (int row = 171; row < mirrorPointRight; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 238; col < 293; col++)
      {
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPointRight + mirrorPointRight - row]                       
                         [col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 357;
    int mirrorPoint2 = 244;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    //seagulls breaking up
    
    for (int row = 228; row < 328; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 229; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    
    
    //seagull kissing???????
    /*
    for (int row = 228; row < 328; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 229; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col - mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    */
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, 
                 int startRow, int startCol,
                 int fSR,      int fSC,
                 int fER,      int fEC)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fSR, toRow = startRow; 
         fromRow < fER &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = fSC, toCol = startCol; 
           fromCol < fEC &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,20);
    this.copy(flower1,200,30);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,40);
    this.copy(flower1,400,50);
    this.copy(flower2,500,60);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
    Picture gull = new Picture("seagull.jpg");
    Picture swam = new Picture("swam.jpg");
    Picture morocco = new Picture("morocco.jpg");
    
    this.copy(gull,0,0,229,232,329,332);
    this.copy(swam,100,0,63,300,200,396);
    this.copy(morocco,200,0,67,301,167,400);
    
    Picture moroccoNoBlue = new Picture(morocco);
    moroccoNoBlue.zeroBlue();
    
    
    
    /**
     * 63,300,200,396
     */
    
    this.copy(moroccoNoBlue,300,0,67,301,167,400);
    this.copy(gull,400,0,229,232,329,332);
    //this.copy(swam,200,100,63,300,200,396);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    /**
     * modify this loop to make it compare up and down
     * 
     * 
     */
    for (int row = 0; row < pixels.length; row++) //change this
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++) // change this
      {
        leftPixel = pixels[row][col]; //change this
        rightPixel = pixels[row][col+1]; //change this
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
