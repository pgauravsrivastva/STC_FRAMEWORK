package helper;



import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;


/*
 * Method to create Folder 
 * @Author Nitya Ranjan
 * Implement date: 13/3/2019
 */

public class SoftAssert {

  private static List<Throwable> softAssertList = new ArrayList<Throwable>();

  private static void addSoftAsserts(Throwable e) {
    softAssertList.add(e);
  }

  public static void assertTrue(boolean condition, String msg) {
    try {
      Assert.assertTrue(condition, msg);
    } catch(Throwable e) {
      addSoftAsserts(e);
    }
  }

  public static void assertFalse(boolean condition, String msg) {
    try {
      Assert.assertFalse(condition, msg);
    } catch(Throwable e) {
      addSoftAsserts(e);
    }
  }

  public static void assertEquals(Object actual, Object expected, String msg) {
    try {
      Assert.assertEquals(actual, expected, msg);
    } catch(Throwable e) {
      addSoftAsserts(e);
    }
  }

  public int count() {
    return softAssertList.size();
  }

  public Throwable get(int index) {
    return softAssertList.get(index);
  }

  
}

