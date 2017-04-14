package plate;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JFileChooser;

public class DynamicLoad {
	public Class<?> loadChosenClass() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			URL myUrl;
			try {
				String nameOfClass = "";
				myUrl = file.toURL();
				String str = myUrl + "";// full path
				int i = 0;
				for (i = str.length() - 1; i >= 0; i--) {
					if (str.charAt(i) == '/') {
						break;
					}
				}
				nameOfClass = str.substring(++i, str.length() - 6);
				URL name;
				name = new URL(str.substring(0, i));
				return CheckClassExist(name, nameOfClass);
			} catch (MalformedURLException e1) {
			}
		}
		return null;
	}

	Class<?> CheckClassExist(URL name, String nameOfClass) {
		URL[] my = { name };
		URLClassLoader classloader = new URLClassLoader(my);
		try {
			return classloader.loadClass(nameOfClass);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
