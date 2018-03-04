package Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config_Reader {
	Properties pro;
	
	public Config_Reader() {
		
		
		File src = new File("./Configuration/Config.property");
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			
       System.out.println(e.getMessage());		
       
		
		}
	}
	
	public String getgeckopath() {// now we are creating method for geckodriver path yes
		String path = pro.getProperty("dpath");
		System.out.println("path");
		
		return path;
	}

	
	public String geturl() {
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getepath() {
		String epath = pro.getProperty("epath");
		return epath;
	}
}
