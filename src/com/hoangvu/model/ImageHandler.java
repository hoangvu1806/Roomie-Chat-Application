
package com.hoangvu.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageHandler {

    // Phương thức mã hóa mảng byte thành ImageIcon
    public static Icon decodeImage(byte[] imageData) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        BufferedImage bufferedImage = ImageIO.read(bis);
        bis.close();
        // Tạo ImageIcon từ BufferedImage
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        // Chuyển đổi ImageIcon thành Icon
        return new ImageIcon(imageIcon.getImage().getScaledInstance(
                bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH));
    }

    // Phương thức giải mã ImageIcon thành mảng byte
    public static byte[] encodeImage(ImageIcon imageIcon, String format) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(
                imageIcon.getIconWidth(),
                imageIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);

        // Vẽ ImageIcon lên BufferedImage
        Image image = imageIcon.getImage();
        bufferedImage.createGraphics().drawImage(image, 0, 0, null);

        // Ghi BufferedImage thành mảng byte
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, format, bos);
        bos.close();

        return bos.toByteArray();
    }

    // Phương thức đọc dữ liệu từ một tệp hình ảnh và mã hóa thành mảng byte
    public static byte[] readImageFile(String filePath) throws IOException {
        File imageFile = new File(filePath);
        InputStream inputStream = new FileInputStream(imageFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
        return outputStream.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\Roomie Project\\src\\com\\hoangvu\\icon\\backgroundPanel.png";
        byte[] imageData = readImageFile(filePath);
        System.out.println(imageData);
        // Mã hóa dữ liệu hình ảnh thành ImageIcon
        Icon imageIcon = decodeImage(imageData);
        // Hiển thị ImageIcon trong một JFrame
        JFrame frame = new JFrame("Decoded Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel(imageIcon);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
        ModelSendMessage sender = new ModelSendMessage(1, 2, imageData);
        System.out.println(sender.toJsonObject());
    }
}
