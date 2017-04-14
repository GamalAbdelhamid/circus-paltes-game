package plate;

import java.io.File;

import level.Level;

public class DynamicLoader {
    public Plate getPlate(String url,Level level)
	    throws ClassNotFoundException, InstantiationException, IllegalAccessException {

	ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
	MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
	String plateName = "";
	for (int i = url.length() - 7; i > 0; i--) {
	    if (url.charAt(i) != '\\') {
		plateName = url.charAt(i) + plateName;
	    } else {
		break;
	    }
	}
	
	Class myObjectClass = classLoader.loadClass(url, "plate." + plateName, plateName);
	Plate object = (Plate) myObjectClass.newInstance();
	classLoader = new MyClassLoader(parentClassLoader);
	myObjectClass = classLoader.loadClass(url, "plate." + plateName, plateName);
	object = (Plate) myObjectClass.newInstance();
	object.init(level);
	CopyFile cp = new CopyFile();
	File x = new File("");
	String s = x.getAbsolutePath();
	cp.copy(url, s + "\\bin\\plate\\" + plateName + ".class");
	return object;

    }

}

