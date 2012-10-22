package org.bimserver.mesaOffscreen;   
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import java.awt.image.BufferedImage;




/** Simple example of native library declaration and usage. */
public class mesaOffscreen {     
    
	public static void main(String[] args) throws IOException {    
		File myFile = new File(args[0]);
		final int size = (int) myFile.length();
		final InputStream in = new FileInputStream(myFile);
		
		osdemoDLL.StreamCallback fn = new osdemoDLL.StreamCallback() {
			int total = 0;
			public int invoke(Pointer pointer) {
				if (total == size) {
					return -1;
				}
				ByteBuffer byteBuffer = pointer.getByteBuffer(0, 1024);
				try {
					byte[] buffer = new byte[1024];
					int red = in.read(buffer, 0, Math.min(1024, size - total));
					if (red == -1) {
						return -1;
					}
					total += red;
					byteBuffer.put(buffer, 0, red);
					return red;
				} catch (IOException e) {
				}
				return -1;
			}
		};	
		
		osdemoDLL sdll = osdemoDLL.INSTANCE; 					
		
		int width = 800;
		int height = 800;
		Memory pV = new Memory(width * height * 4);

		if (sdll.RenderToBufferFromStream(fn, pV, width, height) > 0)
		{
			pV.getByteBuffer(0, width * height * 4);
			BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			int pos = 0;
			for (int y=0; y <width; y++)
			{
				for (int x=0; x <height; x++)
				{
					
						im.setRGB(x, width - 1 - y, (pV.getByte(pos + 3) << 24)  + (pV.getByte(pos + 0) << 16) + (pV.getByte(pos + 1) << 8) + pV.getByte(pos + 2));
						pos += 4;
				}
			}
			
			ImageIO.write(im, "PNG", new File("C:\\JavaTest3.png"));
	    }
		// call of void function           
		
	} 
} 

