package org.rapla.framework;

public class ConfigurationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ConfigurationException(String string, Exception exception) {
        super( string, exception);
    }

    public ConfigurationException(String string) {
        super( string );
    }

}
