/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author HOANG MINH HUY
 */
public class ImageHelper {
    public static Image resize(Image originalImage, int targetWidth, int targetHeight){
        Image resultingImage=originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    public static byte[] toByteArray(Image img, String type) throws IOException{
        BufferedImage bfImage=new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g=bfImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(bfImage, type, baos);
        byte[] imageInByte=baos.toByteArray();
        return imageInByte;
    }
    public Image createImageFromByteArray(byte[] data, String type) throws IOException{
        ByteArrayInputStream bais=new ByteArrayInputStream(data);
        BufferedImage bufferedImage2=ImageIO.read(bais);
        Image image= bufferedImage2.getScaledInstance(bufferedImage2.getWidth(), bufferedImage2.getHeight(), Image.SCALE_SMOOTH);
        return image;
    }
}
