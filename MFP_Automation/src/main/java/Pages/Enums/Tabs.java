package Pages.Enums;

public enum Tabs {
    FOR_ADMIN_VERIFICATION("For Admin Verification","/users"),
    VIEW_CURRENT_APP_USERS("View Current App Users","/user-verifications"),
    VIEW_MFP_USERS("View MFP Users","/mfp-users"),
    VIEW_VACCINATION_CENTRE_USERS("View Vaccination Centre Users","/vaccine-users"),
    VIEW_TEST_CENTRE_USERS("View Test Centre Users","/testing-users");

    Tabs() {
    }

    Tabs(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public String getHref() {
        return href;
    }

    public String title;
    public String href;

}
