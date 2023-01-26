package Pages.Enums;

public enum TableHeaders {
    NAME("Name"),
    MATCH_FIT_ID("Match Fit ID"),
    PHONE_NUMBER("Phone Number"),
    EMAIL_ADDRESS("Email Address"),
    LAST_ACTIVE("Last Active"),
    VIEW_PROFILE("View Profile");



    TableHeaders(String title) {
        this.title = title;
    }
    public String title;

    public String getTitle() {
        return title;
    }
}
