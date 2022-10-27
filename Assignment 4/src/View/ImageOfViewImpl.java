package View;

import java.io.IOException;

import Model.ImageModel;

public class ImageOfViewImpl  implements  ImageOfView {
  private Appendable append;

  public  ImageOfViewImpl(Appendable append) {
    this.append = append;

  }
  @Override
  public void renderMessage(String message) throws IOException {
    this.append.append(message + "\n");

  }
  // LOOK AT ME!!!!!!!!
  // Ask TA, would you call for
  // save image form save image model or call basic(width, hight, pixal, information about the model
  // Overally calling a specific method or putting in all information.
  @Override
  public void renderImage(ImageModel image) {

  }
}
