 import java.io.*;
 import java.net.*;
 import java.awt.image.BufferedImage;
 import javax.imageio.ImageIO;
 import java.nio.ByteBuffer;
 public class client {
 // public static void main(String[] args) {
 //
 // try{
 // Socket soc=new Socket("localhost",2004);
 // DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
 // dout.writeUTF("Hello");
 // dout.flush();
 // dout.close();
 // soc.close();
 // }catch(Exception e){
 //     e.printStackTrace();}
 // }


 public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 2004);
        OutputStream outputStream = socket.getOutputStream();

        BufferedImage image = ImageIO.read(new File("D:\\Repositories\\gitRep\\TestServer\\dataImage\\test.png"));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayOutputStream);

        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        System.out.println("Flushed: " + System.currentTimeMillis());

        Thread.sleep(120000);
        System.out.println("Closing: " + System.currentTimeMillis());
        socket.close();
    }
}
