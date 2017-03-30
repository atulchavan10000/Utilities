import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CoordinatesUsingSelenium {

 WebDriver driver;
 @BeforeTest
 public void setup(){
  System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
 }

 @Test
 public void getCoordinates(){
  driver = new ChromeDriver();
  driver.get("https://www.google.com");
  WebElement element = driver.findElement(By.id("hplogo"));
  
  Point location = element.getLocation();
  int x = location.getX();
  int y = location.getY();
  System.out.println("Coordinates of an element is : " + x + " and " + y);
 }

}


The below program shows the size of our webelement in height and width.

 @Test
 public void getCoordinates(){
  driver = new ChromeDriver();
  driver.get("https://www.google.com");
  WebElement element = driver.findElement(By.id("hplogo"));
  System.out.println(element.getText());

  int elementWidth = element.getSize().getWidth();
  System.out.println("Element width: "+ elementWidth);
  int elementHeight = element.getSize().getHeight();
  System.out.println("Element width: "+ elementHeight);

 }

