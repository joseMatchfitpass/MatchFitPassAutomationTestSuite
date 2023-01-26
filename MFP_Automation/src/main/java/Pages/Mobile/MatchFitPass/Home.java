package Pages.Mobile.MatchFitPass;

import Pages.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home extends Base {

    public Home() {
    }

    @FindBy(xpath = "(//android.widget.ImageView)[2]")
    public WebElement profilePhoto;
    @FindBy(xpath = "(//android.widget.ImageView)[3]")
    public WebElement qrCode;

    @Step("Perform Login")
    public boolean validateHomePage()
    {
        //int ctr = 0;
        //try {
            //do {
                return  mobileWait.until(ExpectedConditions.elementToBeClickable(profilePhoto)).isDisplayed() &&
                        mobileWait.until(ExpectedConditions.elementToBeClickable(qrCode)).isDisplayed();
                //sleep(1000);
              //  if(ctr == 10)
               // {
             //       break;
              //  }
             //   ctr++;
          //  }
           // while (!profilePhoto.isDisplayed()||!qrCode.isDisplayed());
         //   return true;
      //  }
       // catch (Exception e)
      //  {
       //     return false;
     //   }
    }
}
