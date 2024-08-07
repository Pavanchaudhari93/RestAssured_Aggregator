package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import CommonLibs.Implementation.Base;

public class encryptionJSP extends Base{
	
	private static By search = By.xpath("//div[contains(text(),'COMPOSE')]");

	public static void enc(String body) {
	openDriver();
	navigateToURL("https://uat.sbiepay.sbi/secure/getEncryptDecryptChecksumString.jsp");
	driver.findElement(By.id("merchantid")).sendKeys("1000003");
//	waitUntilElementIsVisible(By.name("encryptionFlag"), 5);
//	Select sel = new Select(driver.findElement(By.name("encryptionFlag")));
//	hardPause(2000);
//	sel.selectByVisibleText("AES256");
	driver.findElement(By.name("encryptionFlag")).click();
	driver.findElement(By.xpath("//option[.='AES256']")).click();
	driver.findElement(By.id("encDecValue")).sendKeys(body);
	driver.findElement(By.id("selectionType2")).click();
	
	System.out.println(driver.findElement(By.id("encDecResult")).getText());
	}
}
