package git.jenkins.connect;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jenkins_Connection {
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("buttonFromTo")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		//System.out.println(rows.size());
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < columns.size(); j++) {
				System.out.print(columns.get(j).getText());
				System.out.print("\t");				
			}
			System.out.println();
			
		}

	}

}
