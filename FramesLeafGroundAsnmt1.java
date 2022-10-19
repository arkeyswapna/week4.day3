package week4.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGroundAsnmt1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notification");
		ChromeDriver driver= new ChromeDriver();
		
		//1)Login to  https://www.leafground.com/frame.xhtml
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Switching to frame1
		driver.switchTo().frame(0);
		WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));
		button.click();
		String text = button.getText();
		System.out.println(text);
		
		// count the number of iframes in the DOM
		driver.switchTo().defaultContent();
		List<WebElement> countframes = driver.findElements(By.xpath("//iframe"));
		int size = countframes.size();
		System.out.println(size+" frames are there in this webpage");
		
		//Switching to nested frame
		driver.switchTo().frame(2);
		System.out.println("In frame 3");
		driver.switchTo().frame("frame2");
		System.out.println("In nested frame");
		WebElement nestedframebutton = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));
		nestedframebutton.click();
		String text2 = nestedframebutton.getText();
		System.out.println(text2);
		//entering the text in the textbox
		//WebElement findElement = driver.findElement(By.xpath("//h5[text()=\" Click Me (Inside frame)\"]//following::iframe[1]"));
	}

}
