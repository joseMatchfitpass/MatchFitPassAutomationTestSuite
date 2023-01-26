package Pages.Enums;

public enum StageURL {
    ADMIN_DASHBOARD("https://admin-dashboard-stg.mfpstaging.technology/"),
    TEST_DASHBOARD("https://testing-dashboard-stg.mfpstaging.technology/"),
    VACCINE_DASHBOARD("https://vaccination-dashboard-stg.mfpstaging.technology/"),
    HOST_DASHBOARD("https://host-dashboard-stg.mfpstaging.technology/"),
    MFP_WEBSITE("https://mfp-web-stg.mfpstaging.technology/"),
    SQR_WEBSITE("https://sqr-web-stg.mfpstaging.technology/"),
    E_MERCHANT("https://mfp.staging.merchant.emerchantpay.net/en"),
    GBG_ID_SCAN("https://poc.idscan.cloud/IDscanApp/#/login"),
    GBG_ID3("https://pilot.id3global.com/GlobalAdmin/loginPage.aspx"),
    TEST_SHOP_FOR_PAYMENT("https://35.177.189.4/shop/"),
    V_ENTRY("https://v-entry.com/");

    StageURL() {
    }
    StageURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String url;
}
