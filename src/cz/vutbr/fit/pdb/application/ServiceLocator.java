package cz.vutbr.fit.pdb.application;

import cz.vutbr.fit.pdb.config.Loader;
import cz.vutbr.fit.pdb.security.Authenticator;
import cz.vutbr.fit.pdb.security.IIdentity;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Paulík Miroslav
 * @author Mikulica Tomáš
 * @author Gajdoš Pavel
 */
public class ServiceLocator {

    private static Properties properties = null;
    private static Authenticator authenticator = null;

    /**
     *
     */
    public ServiceLocator() {
        Loader loader = new Loader();
        ServiceLocator.properties = loader.getProperties();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public static OracleDataSource getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        IIdentity identity = ServiceLocator.getAuthenticator().getIdentity();
        String connectionString = "jdbc:oracle:thin:@berta.fit.vutbr.cz:1522:DBFIT";
        ods.setURL(connectionString);

        ods.setUser(identity.getUsername());
        ods.setPassword(identity.getPassword());
        return ods;
    }

    /**
     *
     * @return
     */
    public static Properties getProperties() {
        if (ServiceLocator.properties == null) {
            Loader loader = new Loader();
            ServiceLocator.properties = loader.getProperties();
        }
        return ServiceLocator.properties;
    }

    /**
     *
     * @return
     */
    public static Authenticator getAuthenticator() {
        if (ServiceLocator.authenticator == null) {
            ServiceLocator.authenticator = new Authenticator();
        }
        return ServiceLocator.authenticator;
    }
}
