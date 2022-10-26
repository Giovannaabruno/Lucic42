package Model;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import View.Pixel;

// It's a hypothesis maybe uses constructor BufferImage to eventually  create the image.
// all of them will probably have 3 values which is height, width, and type.

public class ImageModelImp implements ImageModel {
  Pixel[][] pixels;

  public ImageModelImp(String filename) {
    loadImage(filename);
  }

  @Override
  public void loadImage(String filename) {
    Scanner sc;
    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException var12) {
      System.out.println("File " + filename + " not found!");
      return;
    }

    StringBuilder builder = new StringBuilder();

    String s;
    while (sc.hasNextLine()) {
      s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());
    s = sc.next();
    if (!s.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }

    int width = sc.nextInt();
    //System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    //System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    //System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    pixels = new Pixel[height][width];
    for (int i = 0; i < height; ++i) {
      for (int j = 0; j < width; ++j) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels[i][j] = new Pixel(r, g, b);
        //System.out.println("Color of pixel (" + j + "," + i + "): " + r + "," + g + "," + b);
      }
    }
  }

    // save image-path image-name: Save the image with the given name to the
    // specified path which should include the name of the file.
    // need help
    public void saveImage() {

    }

  @Override
  public void saveImage(Pixel[][] pixels, String fileName) {
    try {
      File f = new File(fileName);
      FileWriter fw = new FileWriter(f);

      fw.append("P3\n");
      fw.append(pixels.length + " " + pixels[0].length + "\n");
      for(int i = 0; i < pixels.length; i++) {
        for(int j = 0; j < pixels[0].length; j++) {
          fw.append(pixels[i][j].red + "\n");
          fw.append(pixels[i][j].green + "\n");
          fw.append(pixels[i][j].blue + "\n");
        }
      }
      fw.close();

    } catch(Exception e) {
      System.out.println("Save operation failed!");
    }

  }

  @Override
  public void redGreyscale(String sourceFilename, String destinationFilename) {
    loadImage(sourceFilename);

    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[i].length; j++) {
        int x = pixels[i][j].red;
        copy[i][j] = new Pixel(x, x, x);
      }
    }
    saveImage(copy, destinationFilename);

  }

  @Override
  public void greenGreyscale(String sourceFilename, String destinationFilename) {
    loadImage(sourceFilename);

    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[i].length; j++) {
        int x = pixels[i][j].green;
        copy[i][j] = new Pixel(x, x, x);
      }
    }
    saveImage(copy, destinationFilename);
  }

  @Override
  public void blueGreyscale(String sourceFilename, String destinationFilename) {
    loadImage(sourceFilename);

    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[i].length; j++) {
        int x = pixels[i][j].blue;
        copy[i][j] = new Pixel(x, x, x);
      }
    }
    saveImage(copy, destinationFilename);
  }

  @Override
  public void valueGreyscale(String sourceFilename, String destinationFilename) {
    loadImage(sourceFilename);

    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[i].length; j++) {
        int x = pixels[i][j].getValue();
        copy[i][j] = new Pixel(x, x, x);
      }
    }
    saveImage(copy, destinationFilename);
  }

  @Override
  public void intensityGreyscale(String sourceFilename, String destinationFilename) {
    loadImage(sourceFilename);

    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[i].length; j++) {
        int x = pixels[i][j].getIntensity();
        copy[i][j] = new Pixel(x, x, x);
      }
    }
    saveImage(copy, destinationFilename);
  }

  @Override
  public void lumaGreyscale(String sourceFilename, String destinationFilename) {
    loadImage(sourceFilename);

    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];
    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[i].length; j++) {
        int x = pixels[i][j].getLuma();
        copy[i][j] = new Pixel(x, x, x);
      }
    }
    saveImage(copy, destinationFilename);
  }

  @Override
  public void horizontalFlip(String sourceFilename, String destinationFilename) {
    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        copy[i][pixels[0].length - 1 - j] = pixels[i][j];
      }
    }

    saveImage(copy, destinationFilename);
  }

  @Override
  public void verticalFlip(String sourceFilename, String destinationFilename) {
    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        copy[pixels.length - 1 - i][j] = pixels[i][j];
      }
    }

    saveImage(copy, destinationFilename);
  }

  @Override
  public void brightenImage(int brightness, String sourceFilename, String destinationFilename) {
    Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];

    for(int i = 0; i < pixels.length; i++) {
      for(int j = 0; j < pixels[0].length; j++) {
        int r = pixels[i][j].red + brightness;
        int g = pixels[i][j].green + brightness;
        int b = pixels[i][j].blue + brightness;

        if(r > 255) r = 255;
        if(g > 255) g = 255;
        if(b > 255) b = 255;
        if(r < 0) r = 0;
        if(g < 0) g = 0;
        if(b < 0) b = 0;

        copy[i][j] = new Pixel(r,g,b);
      }
    }

    saveImage(copy, destinationFilename);
  }
}