import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GrayScale2 {
   public static int compteur = 0;
   public static void GrayScale2(String fileName) {
	BufferedImage  image;
	int width;
	int height;
      try {
         File input = new File(fileName);
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         
         for(int i=0; i<height; i++){
         
            for(int j=0; j<width; j++){
            
               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,
               
               red+green+blue,red+green+blue);
               
               image.setRGB(j,i,newColor.getRGB());
            }
         }
         
         File ouptut = new File(compteur + "-output.jpg");
		 compteur++;
         ImageIO.write(image, "jpg", ouptut);
		 
         
      } catch (Exception e) {}
   }
   
    public static void BlackAndWhite (String fileName) throws IOException {

		File file = new File(fileName);
		BufferedImage orginalImage = ImageIO.read(file);

		BufferedImage blackAndWhiteImg = new BufferedImage(
			orginalImage.getWidth(), orginalImage.getHeight(),
			BufferedImage.TYPE_BYTE_BINARY);

		Graphics2D graphics = blackAndWhiteImg.createGraphics();
		graphics.drawImage(orginalImage, 0, 0, null);

		ImageIO.write(blackAndWhiteImg, "jpg", new File(compteur + "-blackAndWhite.jpg")); 
	}
   
   public static void main(String args[]) throws IOException 
   {
      GrayScale2(args[0]);
	  BlackAndWhite(args[0]);
	  GrayScale2(args[1]);
	  BlackAndWhite(args[1]);
   }
}