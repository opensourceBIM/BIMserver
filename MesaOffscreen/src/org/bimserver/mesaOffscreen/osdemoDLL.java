package org.bimserver.mesaOffscreen;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface osdemoDLL extends Library {         
	osdemoDLL INSTANCE = (osdemoDLL) Native.loadLibrary(             
			 "osdemo", osdemoDLL.class);         
	// it's possible to check the platform on which program runs, for example purposes we assume that there's a linux port of the library (it's not attached to the downloadable project)
	interface StreamCallback extends Callback {
		int invoke(Pointer pointer);
	}	
	
	int RenderToBufferFromStream(StreamCallback callbackAddress, Pointer buffer, int width, int height);  

}  