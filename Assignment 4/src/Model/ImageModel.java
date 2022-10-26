package Model;

import java.awt.*;

/**
 * define what rules:
 * Load an image from an ASCII PPM file (see below).
 * Create images that visualize individual R,G,B components of an image.
 * Create images that visualize the value, intensity or luma of an image as defined above.
 * Flip an image horizontally or vertically.
 * Brighten or darken an image.
 * Save an image to an ASCII PPM file (see below).
 * Allow a user to interact with your program to use these operations,
 * using simple text-based scripting (see below).
 **/

public interface ImageModel {

  /**
   * feature 1: Load an image from an ASCII PPM file (see below).
   */
  public void loadImage(Image image);


  /**
   * feature 2: Create images that visualize individual R,G,B components of an image.
   * 2D arrays
   */
  public void visualizeRGB(int[][] colorSettings);

  /**
   * feature 3:Create images that visualize the value, intensity or luma of an image as
   * defined above.
   */
  public void visualizeValue(int[][] valueSettings);


  /**
   * feature 4:Flip an image horizontally or vertically.
   */
  public void flipHV(int[][] adjustSettings);

  /**
   * feature 5: Brighten or darken an image.
   */
  public void Brightness(int[][] brightnessSettings);

  /**
   * feature 6: Save an image to an ASCII PPM file (see below).
   */
  public void saveImage(Image image);


}
