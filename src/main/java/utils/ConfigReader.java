package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	public Properties ConfigurationManager() {
		prop = new Properties();
		File proFile = new File("src\\test\\resources\\config\\configreader.properties");
		try {
			FileInputStream fis =new FileInputStream(proFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
		}
	public String getBrowserName() {
		String browsername=prop.getProperty("browsername");
		return browsername;
	}
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	public String getMail() {
		String mail=prop.getProperty("mail");
		return mail;
	}
	public String getFirstName() {
		String FirstName=prop.getProperty("FirstName");
		return FirstName;
	}
	public String getLastName() {
		String LastName=prop.getProperty("LastName");
		return LastName;
	}
	public String getPassword() {
		String Password=prop.getProperty("Password");
		return Password;
	}
	public String getValidateName() {
		String NameValidate=prop.getProperty("NameValidate");
		return NameValidate;
	}
	public String geterrorMessage() {
		String ErrorMessage =prop.getProperty("ErrorMessageAuthentification");
		return ErrorMessage;
	}

}
