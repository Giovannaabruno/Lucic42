package View;


import java.io.IOException;

import Model.ImageModel;

public interface ImageOfView {

  void renderMessage(String message) throws IOException;
  void renderImage(ImageModel image);

}
