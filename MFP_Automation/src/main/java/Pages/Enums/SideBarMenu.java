package Pages.Enums;

public enum SideBarMenu {
    USERS("Users","/users"),
    HOSTS("Hosts","/hosts"),
    VACCINATION("Vaccination","/vaccination/centers"),
    TESTING("Testing","/testing/centers"),
    AUDIT_TRAIL("Audit Trail","/audit/trail"),
    INVOICES("Invoice","/invoices"),
    BROADCAST_MESSAGE("Broadcast Message","broadcast"),
    ADMINISTERED_TEST_TYPES("Administered Test Types","administered-types"),
    REGISTERED_TEST_TYPES("Registered Test Types","registered-types"),
    USER_MANAGEMENT("User Management","user/create"),
    USER_CODES("User Codes","/codes"),

    //Host Dashboard
    TICKETS("Tickets","/tickets"),
    TRACKING("Tracking","/tracking"),
    COMPANY_DETAILS("Company Details","/details"),
    TEAM_MANAGEMENT("Team Management","/management"),
    VIEW_VACCINE_BATCHES("View Vaccine Batches","/ViewVaccineBatches"),
    INVOICE("Invoice","/invoice"),
    REGISTERED_VACCINES("Registered Vaccines","/registered-vaccines");


    SideBarMenu() {
    }

    SideBarMenu(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String title;
    public String href;

    public String getTitle() {
        return title;
    }

    public String getHref() {
        return href;
    }

    public String getNavMenuXpath()
    {
        return "//div[@class='nav-menu-item__text'][text()='"+title+"']";
    }
    public String getHeaderXpath()
    {
        return "//div[@class='page-header__title'][text()='"+title+"']";
    }
}
