package cz.vutbr.fit.pdb.config;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulík Miroslav
 * @author Mikulica Tomáš
 * @author Gajdoš Pavel
 */
public class Loader {

    private Properties properties;

    /**
     * Zjisti, zda existuje konfiguracni soubor s udaji pro pripojeni defaultniho uzivatele
     * @return
     */
    public static boolean existsLocalConfig() {
        Loader loader = new Loader();
        if (loader.getClass().getResourceAsStream("config.local.properties") == null) {
            return false;
        }
        return true;
    }

    /**
     * Zpracovani souboru s konfiguracemi.
     * Nejprve se zpracuje soubor se zakladni konfiguraci a pote
     * jsou prepsana lokalne zavisla data ze souboru config.local.properties
     * @return
     */
    public Properties getProperties() {
        if (properties == null) {
            Properties prop1 = parsePropertiesFrom("config.properties");
            Properties prop2 = parsePropertiesFrom("config.local.properties");

            prop1.putAll(prop2);

            properties = prop1;
        }
        return properties;
    }

    private Properties parsePropertiesFrom(String configFileName) {
        Properties prop = new Properties();
        try {
            if (getClass().getResourceAsStream(configFileName) != null) {
                prop.load(getClass().getResourceAsStream(configFileName));
            }
        } catch (IOException ex) {
            Logger.getLogger(Loader.class
                    .getName()).log(Level.SEVERE, configFileName + " not found", ex);
            prop.setProperty(
                    "DB.HOST", "berta.fit.vutbr.cz");
            prop.setProperty(
                    "DB.PORT", "1522");
            prop.setProperty(
                    "DB.SID", "DBFIT");
        }
        return prop;
    }
}
