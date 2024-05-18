
package com.hoangvu.model;

import com.hoangvu.connection.ServerConnection;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

public class ImageSender {
    public ImageSender(){}
    public byte[] convertImageToBase64(String imagePath) {
        File file = new File(imagePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteOutStream);
            byte[] bytes = byteOutStream.toByteArray();
//            return Base64.getEncoder().encodeToString(bytes);
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendImage(String imagePath) {
        byte[] imageString = convertImageToBase64(imagePath);
        if (imageString != null) {
            System.out.println(imageString.toString().length());
        }
//        ServerConnection.getInstance().getClient().emit("send-images", imageString);
    }

    public static void main(String[] args) {
        ImageSender imageSender = new ImageSender();
        imageSender.sendImage("E:\\Roomie Project\\src\\com\\hoangvu\\icon\\bb.png");
    }
}
