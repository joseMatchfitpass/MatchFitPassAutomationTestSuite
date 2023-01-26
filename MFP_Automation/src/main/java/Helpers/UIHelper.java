package Helpers;

import Pages.Enums.TableHeaders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Pages.Base.*;

public class UIHelper {
    public int getColHeaderIndex(String colHeader)
    {
        List<WebElement> colHeaders = getElements("//th");
        for(int i=0;i<=colHeaders.size()-1;i++)
        {
            if(colHeaders.get(i).getText().equals(colHeader))
            {
                return i+1;
            }
        }
        return 0;
    }

    public String getCellValue(TableHeaders tableHeaders, int row)
    {
        return getObject("//tr["+row+"]/td["+getColHeaderIndex(tableHeaders.getTitle())+"]").getText();

    }

    public WebElement getObject(String locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
