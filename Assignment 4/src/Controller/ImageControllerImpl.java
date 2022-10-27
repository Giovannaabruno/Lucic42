package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Model.ImageModel;
import Model.ImageModelImp;
import View.ImageOfView;
/// After reading the direction, we will have to list our own list of commands ( Scrip)
(write the scriped )
public class ImageControllerImpl implements ImageController {
  private Readable read;
  private ImageModel image;
  private ImageOfView view;
  public ImageControllerImpl( Readable read,ImageModel image, ImageOfView view ){
    if (read != null || image != null || view != null) {
      this.read = read;
      this.image = image;
      this.view = view;
    } else {
      throw new IllegalArgumentException("null");
    }

  }


  @Override
  public void interact() throws IOException {
    Scanner scan = new Scanner(this.read);
    try {
      this.view.renderMessage("How you want to change the image?");
    }
    catch (IOException e) {
      throw new IllegalStateException(" Error ");

    }
    while (scan.hasNext()) {
      String x = scan.next();

    }


  }
}
