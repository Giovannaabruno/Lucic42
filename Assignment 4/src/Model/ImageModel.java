package Model;

import java.awt.*;

import View.Pixel;

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



/*
Design:
Each method will take in 2 arguments: the source filename and the destination filename
Each method will make a 2D array of pixels that will be given to the saveImage method
 */


public interface ImageModel {

  /**
   * feature 1: Load an image from an ASCII PPM file (see below).
   */
  public void loadImage(String filename);


  /**
   * 3.2 Text-based scripting: save image-path image-name: S
   * ave the image with the given name
   * to the specified path which should include the name of the file.
   * @param fileName
   */
  public void saveImage(Pixel[][] pixels, String fileName);

  /**
   * 3.2 Text-based scripting
   * red-component image-name dest-image-name: Create a greyscale image with
   * the red-component of the image with the given name, and refer to it henceforth
   * in the program by the given destination name.
   * Similar commands for green, blue, value, luma, intensity components should be supported.
   *
   */
  public void redGreyscale(String sourceFilename, String destinationFilename);
  public void greenGreyscale(String sourceFilename, String destinationFilename);
  public void blueGreyscale(String sourceFilename, String destinationFilename);

  public void valueGreyscale(String sourceFilename, String destinationFilename);
  public void intensityGreyscale(String sourceFilename, String destinationFilename);
  public void lumaGreyscale(String sourceFilename, String destinationFilename);

  public void horizontalFlip (String sourceFilename, String destinationFilename);
  public void verticalFlip(String sourceFilename, String destinationFilename);
  public void brightenImage(int brightness, String sourceFilename, String destinationFilename);



}
