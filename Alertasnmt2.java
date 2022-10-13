package week4.day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertasnmt2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//1)Login to  https://www.leafground.com/alert.xhtml
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2)click on show button to get simple alert
		driver.findElement(By.xpath("//button[@id=\"j_idt88:j_idt91\"]")).click();
		//3)Switch to alert and accept.
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//4)Click on 2nd show button to get confirm alert.
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']")).click();
		//switching to alert and dismiss it.
		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		//5)Confirming the alert click message
		WebElement msg2 = driver.findElement(By.xpath("//span[@id='result']"));
		String text = msg2.getText();
		System.out.println(text);
		//6)Click on 3rd show button to get sweet alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']")).click();
		//7)click on dismiss button on simple dialog window
	
		WebElement dismiss = driver.findElement(By.xpath("//div[@class='ui-dialog-footer ui-widget-content']//span//button"));
		Actions builder=new Actions(driver);
		builder.moveToElement(dismiss).click().perform();
		
		//8)click on the 4th show button to get modal dialog
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt100\"]/span[2]")).click();
		//9) closing the modal dialog window
		WebElement close = driver.findElement(By.xpath("//div[@id='j_idt88:j_idt101']//div//a//span"));
		Actions builder2=new Actions(driver);
		builder2.moveToElement(close).click().perform();// this statement not working but below statements are working
		//10 click on 5th show button and giving text in the prompt dialog window
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
		Alert alert3= driver.switchTo().alert();
		alert3.sendKeys("TeatLeaf");
		alert3.accept();
		//11 click on Delete button
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt106']//span[2]")).click();
		WebElement yes = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt108']//span[2]"));
		Actions builder3=new Actions(driver);
		builder3.moveToElement(yes).click().perform();
		//12 click on 6th show button
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt111']//span[2]")).click();
		//Thread.sleep(1000);
//		WebElement min = driver.findElement(By.xpath("//div[@id='j_idt88:j_idt112']//div//a[3]//span"));
//		Actions builder4=new Actions(driver);
//		builder3.moveToElement(min).click().perform();
		System.out.println(driver.getTitle());

	}

}
