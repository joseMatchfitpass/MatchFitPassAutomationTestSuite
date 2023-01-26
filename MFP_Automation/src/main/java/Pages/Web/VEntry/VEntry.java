package Pages.Web.VEntry;

import Pages.Base;
import org.openqa.selenium.support.PageFactory;

public class VEntry extends Base {
    public LandingPage landingPage;
    public VEntry()
    {
        landingPage = new LandingPage();
        PageFactory.initElements(driver, landingPage);
    }
}
