package by.training.nc.dev3.localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
public class Bundle {
    private static ResourceBundle resourceBundle;

    public static ResourceBundle getInstance() {
        if (resourceBundle == null) {
            Locale locale = new Locale("en", "EN");
            resourceBundle = ResourceBundle.getBundle("Bundle_en", locale);
        }
        return resourceBundle;
    }

    private Bundle() {
    }

    public static void change(){
        if (resourceBundle.getBaseBundleName().equals("Bundle_en")){
            resourceBundle = ResourceBundle.getBundle("Bundle_ru", new UTF8Control());
        } else{
            Locale locale = new Locale("en", "EN");
            resourceBundle = ResourceBundle.getBundle("Bundle_en", locale);
        }
    }
}
