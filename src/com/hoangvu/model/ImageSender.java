
package com.hoangvu.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageSender {
    public String convertImageToBase64(String imagePath) {
        File file = new File(imagePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteOutStream);
            byte[] bytes = byteOutStream.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendImage(String imagePath) {
        String imageString = convertImageToBase64(imagePath);
        if (imageString != null) {
            ServerConnection.getInstance().getClient().emit("send-image", imageString);
        }
    }
}
