package pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class utility 
{
	 WebDriver w;
 
	public utility(WebDriver w) 
	{
		this.w =w;
	}

	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)w;
		js.executeScript("window.scrollBy(0, 500)");
	}
	

	
}
