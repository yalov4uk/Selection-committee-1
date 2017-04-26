package by.training.nc.dev3.localosation;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Valera Yalov4uk on 4/26/2017.
 */
public class Bundle {
    public static ResourceBundle getResourceBundle(HttpServletRequest request) {
        ResourceBundle resourceBundle;
        Locale locale = (Locale) request.getSession().getAttribute("language");
        if (locale == null) {
            resourceBundle = ResourceBundle.getBundle("bundle", new Locale("en", "US"));
        } else {
            resourceBundle = ResourceBundle.getBundle("bundle", locale);
        }
        return resourceBundle;
    }
}
