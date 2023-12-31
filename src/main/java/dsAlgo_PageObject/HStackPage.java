package dsAlgo_PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dsAlgo_Utilities.PageUtils;

public class HStackPage {
		private WebDriver driver;
		public  HStackPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		private String result;
		 @FindBy(xpath = "//ul/a[text()='Operations in Stack']")private WebElement operationstackpython;
		 @FindBy(xpath = "//a[text()='Try here>>>']")private WebElement tryhere;
		 @FindBy(xpath = "//button[text()='Run']" )private WebElement runbtn;
		 @FindBy(xpath = "//input[@value='Submit']" )private WebElement submitbtn;	
		 @FindBy(id = "output")private WebElement outputbox;
		  @FindBy(xpath="//*[@id='answer_form']/div/div/div[1]/textarea")private WebElement tryEditor;
		 @FindBy(xpath = "//a[text()='Practice Questions']") WebElement practicequestionlink;
		 @FindBys(value = { @FindBy(how = How.XPATH,using="//div[contains(@style,'margin-bottom')]/ul")}) private List<WebElement> stackmenu;
		 @FindBys(value = { @FindBy(how = How.XPATH,using="//div[@class='list-group']/a")}) private List<WebElement> practicemenu;
		 private PageUtils pageutil=new PageUtils();
		 
		 public void operationstack_click() 
		 { // pageutil.scrolldown(driver);
		 //	pageutil.explicit_wait(driver, operationstackpython);
		 	operationstackpython.click();
		 }
		 public void stackmenu_click(String option)
		 {pageutil.menu_click(driver, stackmenu, option);}

		 public void practicemenu_click(String option)
		 {pageutil.menu_click(driver, practicemenu, option);}


		 public void tryedit_click()
		 {	pageutil.scrolldown(driver);
		 	pageutil.scrolldown(driver);
		 	tryhere.click();
		 	}
		 
		 public void practice_click()
		 {	//pageutil.explicit_wait(driver, practicequestionlink);
		 	practicequestionlink.click();
		 }
		 public void enter_code(String code) throws InterruptedException 
		 {	Thread.sleep(2000);
			 tryEditor.sendKeys(code);
		 	}
		 public void click_run() 
		 {	
		 	pageutil.mouse_action(driver, runbtn);
		 	//pageutil.explicit_wait(driver,runbtn);
		 	runbtn.click();
		 }
		 public void click_submit()
		 {
		 	pageutil.mouse_action(driver, submitbtn);
		 	submitbtn.click();
		 }
		 public String present_result()
		 {
		 result=	outputbox.getText();
		 return result;
		 }
		 public String present_invalidmsg()
		 {
		 	result= driver.switchTo().alert().getText();
		 	driver.switchTo().alert().accept();
		 	return result; 
		 }
}
