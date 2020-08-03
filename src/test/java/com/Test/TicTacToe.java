package com.Test;

import com.Pages.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicTacToe extends TestBase {

    // Verifying that Grid give us equal number for row and column
    @Test(priority=0, groups = {"smoke"})
    public void verifyGrid() {

            String squares = "4";

            homePage.textField.sendKeys(squares);
            homePage.playButton.click();

            int  rowCount = homePage.rowCount.size();
            System.out.println("Row Count= "+ rowCount);
            int columnCount =homePage.columnCount.size();
            System.out.println("Column Count= "+ columnCount);


            int sqr = Integer.parseInt(squares);

            Assert.assertTrue(sqr == rowCount && sqr == columnCount, "count of rows and columns are not equals to entered value...");

    }


    // Verifying the behaviour for second entry without refreshing the page
    @Test(priority=1, groups = {"smoke"})
    public void withoutRefresh() {

        String squares = "3";
        homePage.textField.sendKeys(squares);
        homePage.playButton.click();

        squares ="5";
        homePage.textField.sendKeys(squares);
        homePage.playButton.click();

        int sqr = Integer.parseInt(squares);
        int rowcount = homePage.rowCount.size();
        System.out.println("row count= "+ rowcount);

        int columncount = homePage.columnCount.size();
        System.out.println("column count= "+ columncount);

        softAssert.assertEquals(rowcount, sqr, "Count of rows are not equals to entered value...");
        softAssert.assertEquals(columncount, sqr, "Count of columns are not equals to entered value...");
        softAssert.assertAll();


    }

    //Verifying that When X player wins the game, Pop up message displays player O as winner.
    @Test(priority=2, groups = {"smoke","sanity"})
    public void xWinner() {
        String squares = "3";

        homePage.textField.sendKeys(squares);
        homePage.playButton.click();

        homePage.row1Column1.click();
        homePage.row1Column2.click();
        homePage.row2Column2.click();
        homePage.row2Column3.click();
        homePage.row1Column1.click();
        homePage.row3Column3.click();


        String expectedResult = "Congratulations player X! You've won. Refresh to play again!";
        String actualResult = driver.findElement(By.id("endgame")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verifying that When O player wins the game, Pop up message displays player X as winner.
    @Test(priority=3, groups = {"smoke","regression"})
    public void oWinner(){
        String squares = "3";

        homePage.textField.sendKeys(squares);
        homePage.playButton.click();
        homePage.row1Column1.click();
        homePage.row1Column2.click();
        homePage.row1Column3.click();
        homePage.row2Column2.click();
        homePage.row2Column3.click();
        homePage.row3Column2.click();

        String expectedResult = "Congratulations player O! You've won. Refresh to play again!";
        String actualResult= driver.findElement(By.id("endgame")).getText();


        Assert.assertEquals(actualResult,expectedResult);


    }

    // Verifying that with refresh we can game a new game but still same problem with Test oWinner or xWinner
    @Test(priority=4, groups = {"smoke","regression"})
    public void refreshEnterNewValue() throws InterruptedException {
        String squares = "3";
        homePage.textField.sendKeys(squares);
        homePage.playButton.click();

        homePage.row1Column1.click();
        homePage.row1Column2.click();
        homePage.row2Column2.click();
        homePage.row2Column3.click();
        homePage.row1Column1.click();
        homePage.row3Column3.click();

        Thread.sleep(5000);

        driver.navigate().refresh();

        squares= "3";
        driver.switchTo().frame("result");

        homePage.textField.sendKeys(squares);
        homePage.playButton.click();
        homePage.row1Column1.click();
        homePage.row1Column3.click();
        homePage.row2Column2.click();
        homePage.row2Column3.click();
        homePage.row3Column1.click();
        homePage.row3Column3.click();

        String expectedResult = "Congratulations player O! You've won. Refresh to play again!";
        String actualResult= driver.findElement(By.id("endgame")).getText();
        Assert.assertEquals(actualResult,expectedResult);


    }
    // Verifying that "Tie" message is not displayed.
    @Test(priority=5, groups = {"smoke"})
    public void noWinner() {

        String squares = "3";
        homePage.textField.sendKeys(squares);
        homePage.playButton.click();

        homePage.row2Column1.click();
        homePage.row2Column2.click();
        homePage.row2Column3.click();
        homePage.row1Column2.click();
        homePage.row3Column2.click();
        homePage.row3Column3.click();
        homePage.row1Column3.click();
        homePage.row3Column1.click();
        homePage.row1Column1.click();

        Assert.assertTrue(driver.findElement(By.id("endgame")).isDisplayed(), "Tie message is NOT displayed!...");


    }

}
