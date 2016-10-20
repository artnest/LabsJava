package homework.lab7;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppLocale {
    private static final String strMsg = "homework.lab7.Msg";
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(AppLocale.strMsg, AppLocale.locale);

    static Locale getLocale() {
        return AppLocale.locale;
    }

    static void setLocale(Locale locale) {
        AppLocale.locale = locale;
        resourceBundle = ResourceBundle.getBundle(AppLocale.strMsg, AppLocale.locale);
    }

    static ResourceBundle getResourceBundle() {
        return AppLocale.resourceBundle;
    }

    static String getString(String key) {
        return AppLocale.resourceBundle.getString(key);
    }

    public static final String library_part = "library_part";
    public static final String type = "type";
    public static final String info = "info";
    public static final String creation = "creation";
    public static final String library = "library";
    public static final String catalog = "catalog";
    public static final String administrator = "administrator";
    public static final String librarian = "librarian";
    public static final String reader = "reader";
    public static final String book = "book";
}
