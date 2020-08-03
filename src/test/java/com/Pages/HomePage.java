package com.Pages;


import com.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends TestBase {

    public HomePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='number']")
   public WebElement textField;

    @FindBy(xpath = "//*[@id='start']")
    public WebElement playButton;

    @FindBy(xpath ="//*[@id=\"0\"]")
    public WebElement row1Column1;

    @FindBy(xpath ="//*[@id=\"1\"]")
    public WebElement row1Column2;

    @FindBy(xpath ="//*[@id=\"2\"]")
    public WebElement row1Column3;

    @FindBy(xpath ="//*[@id=\"3\"]")
    public WebElement row2Column1;

    @FindBy(xpath ="//*[@id=\"4\"]")
    public WebElement row2Column2;

    @FindBy(xpath ="//*[@id=\"5\"]")
    public WebElement row2Column3;

    @FindBy(xpath ="//*[@id=\"6\"]")
    public WebElement row3Column1;

    @FindBy(xpath ="//*[@id=\"7\"]")
    public WebElement row3Column2;

    @FindBy(xpath ="//*[@id=\"8\"]")
    public WebElement row3Column3;

    @FindBy(xpath = "//*[@id='table']/tr")
    public List<WebElement>  rowCount;

    @FindBy(xpath = "//*[@id=\"table\"]/tr[1]/td")
    public List<WebElement> columnCount;






}
