package STCDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;

import helper.Logger;



public class FolderUtils {
	
	/*
	 * Method to create Folder 
	 * @Author Nitya Ranjan
	 * Implement Date: 12/6/2019
	 */
	public boolean createFolder(String folderPath){
		File dir = new File(folderPath);
		boolean status = false;
		try{
			status = dir.mkdirs();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	/*
	 * Method to copy folder and subfolder from one source folder to destination folder
	 * creates the target folder if it doesn't exist , if the source path is a file then copies the file
	 * @Author Nitya Ranjan
	 */
	
	public static void copy(File sourceLocation, File targetLocation) throws IOException {
	    if (sourceLocation.isDirectory()) {
	        copyDirectory(sourceLocation, targetLocation);
	    } else {
	        copyFile(sourceLocation, targetLocation);
	    }
	}
	
	/*
	 * Method to copy folder and subfolder from one source folder to destination folder
	 * creates the target folder if it doesn't exist
	 * @Author Nitya Ranjan
	 */
	
	public static void copyDirectory(File source, File target) throws IOException {
	    if (!target.exists()) {
	    	
	        target.mkdirs();
	    }

	    for (String f : source.list()) {
	        copy(new File(source, f), new File(target, f));
	    }
	}

	/*
	 * Method to copy file from one source folder to destination file
	 * creates the target folder if it doesn't exist
	 * @Author Nitya Ranjan
	 */
	
	private static void copyFile(File source, File target) throws IOException {        
	    try (
	            InputStream in = new FileInputStream(source);
	            OutputStream out = new FileOutputStream(target)
	    ) {
	        byte[] buf = new byte[1024];
	        int length;
	        while ((length = in.read(buf)) > 0) {
	            out.write(buf, 0, length);
	        }
	    }
	}
	
	/*
	 * Create the Screenshot subfolder if doesn't exist
	 */
	
	public String createScreenshotFolder(String configFilePath, String testSuiteName){
		String screenshotFolderName = "Screenshots";
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("MMM_dd_yy_hh_mm_ss");
        String folderBasePath = configFilePath + "/" + testSuiteName + "/" +screenshotFolderName ;
		String folderLastRunPath = folderBasePath + "/LastRun";
		String folderArchievePath = folderBasePath + "/Archieve"+ "/" + timeFormat.format(cal.getTime());
		File lastRunFolder = new File(folderLastRunPath);
		File archieveFolder = new File(folderArchievePath);
		if (lastRunFolder.exists() && lastRunFolder.isDirectory()) {
			try {
				copy( lastRunFolder, archieveFolder);
				FileUtils.cleanDirectory(lastRunFolder);
			} catch (IOException e) {
				Logger.LOG(Level.WARNING, "Screenshot folder creation failed");
				e.printStackTrace();
			}
			return folderLastRunPath;
		}
		else {
			   createFolder(folderLastRunPath);
			 return folderLastRunPath;
		}
	}
}
