package nhvu.xekhach.UserSite.component.enums;

public enum NotificationType {
    EMAIL, SMS, PUSH;

    public static boolean isValid(String type) {
        for (NotificationType t : values()) {
            if (t.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

}
