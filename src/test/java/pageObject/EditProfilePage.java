package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditProfilePage extends BasePage {
    @FindBy(xpath = "//input[@value='Update resume']")
    private WebElement updateButton;

    @FindBy(xpath = "//div[@class='card mt15']//div//span[@class='edit icon'][normalize-space()='editOneTheme']")
    private WebElement updateResumeHeading;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement updateResumeHeadingSaveButton;

    @FindBy(css = "h1.user-name span.new-pencil")
    private WebElement updateProfileButton;
    @FindBy(css = "#submit-btn")
    private WebElement saveProfileButton;
    @FindBy(xpath = "//h1[text()='Key skills']//span")
    private WebElement updateSkillsButton;
    @FindBy(css = "#submit-btn")
    private WebElement saveSkillsButton;
    @FindBy(xpath = "//h1[text()='Profile Summary']//span")
    private WebElement updateProfileSummaryButton;

    @FindBy(css = "#submit-btn")
    private WebElement saveProfileSummaryButton;

    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }


    public void uploadResume() throws InterruptedException {

//        Thread.sleep(2000);
//        StringSelection filePathSelection = new StringSelection("C:\\Users\\hthit\\IdeaProjects\\Naukari\\testData\\Harshal_Resume.pdf");
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(filePathSelection, null);
//        Thread.sleep(2000);
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(2000);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//        } catch (AWTException e) {
//            throw new RuntimeException(e);
//        }

        WebElement uploadInput = driver.findElement(By.id("undefined-err-inp"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadInput);
        uploadInput.sendKeys(System.getProperty("user.dir") + "/testData/RutikThitame.pdf");
//        driver.findElement(By.cssSelector("input.dummyUpload")).click();

    }

//    public void uploadResume() {
//        // Example XPath or ID — update this based on actual hidden file input
//        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
//        fileInput.sendKeys("/home/ubuntu/resume/Harshal_Resume.pdf");
//
//    }

    public void clickUpdateResumeHeading() {
        wait.until(ExpectedConditions.elementToBeClickable(updateResumeHeading));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", updateResumeHeading);
    }

    public void clickUpdateResumeHeadingSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(updateResumeHeadingSaveButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", updateResumeHeadingSaveButton);
    }

    public void updateProfile() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(updateProfileButton)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(saveProfileButton)).click();
        Thread.sleep(2000);
    }

    public void updateSkills() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(updateSkillsButton)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(saveSkillsButton)).click();
        Thread.sleep(2000);
    }

    public void updateProfileSummary() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(updateProfileSummaryButton).click().perform();
//        wait.until(ExpectedConditions.elementToBeClickable(updateProfileSummaryButton)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(saveProfileSummaryButton)).click();
        Thread.sleep(2000);
    }
}
