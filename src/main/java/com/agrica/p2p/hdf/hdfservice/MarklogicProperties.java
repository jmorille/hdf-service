package com.agrica.p2p.hdf.hdfservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@ConfigurationProperties("marklogic")
@Validated
public class MarklogicProperties {

    /**
     * Marklogic Host
     */
    private String host;

    /**
     * Marklogic Port
     */
    @Pattern(regexp = "[0-9]+")
    private String port;

    /**
     * Marklogic Username
     */
    private String username;

    /**
     * Marklogic Password
     */
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
