package cz.muni.fi.pb162.hw01.impl;

/**
 * Enum for Ports and their values.
 * @author Petr Smejkal
 */
public enum Ports {
    HTTP(80),
    HTTPS(443),
    FTP(21),
    SFTP(22),
    SSH(22);

    private final int value;

    public int getValue() {
        return value;
    }

    /**
     * Constructor of enum Ports for setting value to each port.
     * @param value Value of port
     */
    Ports(int value) {
        this.value = value;
    }
}
