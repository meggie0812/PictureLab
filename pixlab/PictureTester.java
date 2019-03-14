/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVertical right to left */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  /** Method to test mirror horizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  /** Method to test mirror horizontal bottom to top*/
  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }
  
  /** Method to test mirror diagnose*/
  public static void testMirrorDiagonal()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorDiagonal();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorArms()
  {
    Picture temple = new Picture("snowman.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorGull()
  {
    Picture temple = new Picture("seagull.jpg");
    temple.explore();
    temple.mirrorGull();
    temple.explore();
  }
  
  public static void testCopy()
  {
    Picture canvas = new Picture("640x480.jpg");
    Picture swan = new Picture("swan.jpg");
    canvas.copy(swan, 0, 0, 47, 72, 289, 392);
    canvas.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /**
   *method to test keep only Blue
   */
  public static void testKeepOnlyBlue()
  {
      Picture beach = new Picture("beach.jpg");
      
      beach.keepOnlyBlue();
      beach.explore();
  }
  
  /**
   *method to test keep only red
   */
  public static void testKeepOnlyRed()
  {
      Picture beach = new Picture("beach.jpg");
      
      beach.keepOnlyRed();
      beach.explore();
  }
  
  /**
   *method to test keep only green
   */
  public static void testKeepOnlyGreen()
  {
      Picture beach = new Picture("beach.jpg");
      
      beach.keepOnlyGreen();
      beach.explore();
  }
  
  /**
   *method to test negate
   */
  public static void testNegate()
  {
      Picture beach = new Picture("beach.jpg");
      
      beach.negate();
      beach.explore();
  }
  
  /**
   *method to test negate
   */
  public static void testGrayscale()
  {
      Picture beach = new Picture("beach.jpg");
      
      beach.grayscale();
      beach.explore();
  }
  
  /**
   *method to test tofind fish
   */
  public static void testFixUnderwater()
  {
      Picture beach = new Picture("water.jpg");
      
      beach.fixUnderwater();
      beach.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //  testZeroBlue();
    //  testKeepOnlyBlue();
    //  testKeepOnlyRed();
    //  testKeepOnlyGreen();
    //  testNegate();
    //  testGrayscale();
    //  testFixUnderwater();
    //  testMirrorVertical();
    //  testMirrorVerticalRightToLeft();
    //  testMirrorHorizontal();
    //  testMirrorHorizontalBotToTop();
    //  testMirrorDiagonal();
    //  testMirrorTemple();
    //  testMirrorArms();
    //  testMirrorGull();
    //  testCollage();
    testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}