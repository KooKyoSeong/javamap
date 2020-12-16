import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;

public class GoogleAPI {
	
	public void downloadMap(String location) {
		try {
			String imageURL="https://maps.googleapis.com/maps/api/staticmap?key=AIzaSyD94CvfcKAOHNvVYLPGE0Ez_5EPWET0_E0&center="
					+URLEncoder.encode(location,"UTF-8")+"&zoom=15&size=612x612&scale=2";  //zoom값 크게하면 지도 확대 
			URL url=new URL(imageURL);
			InputStream is=url.openStream();
			OutputStream os=new FileOutputStream(location);
			byte[] b=new byte[1024];
			int length;
			while((length=is.read(b))!=-1) {
				os.write(b,0,length);
			}
			is.close();
			os.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ImageIcon getMap(String location) {
		return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(1024,800, java.awt.Image.SCALE_SMOOTH));
		
	}
	
	public void fileDelete(String fileName) {
		File f=new File(fileName);
		f.delete();
	}
	
	
}

