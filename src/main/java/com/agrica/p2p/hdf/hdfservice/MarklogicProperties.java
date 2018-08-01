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
     * Marklogic Port for Final DB
     */
    @Pattern(regexp = "[0-9]+")
    private String portFinal;


    /**
     * Marklogic Port for Staging DB
     */
    @Pattern(regexp = "[0-9]+")
    private String portStaging;

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

    public String getPortFinal() {
        return portFinal;
    }

    public void setPortFinal(String portFinal) {
        this.portFinal = portFinal;
    }

    public String getPortStaging() {
        return portStaging;
    }

    public void setPortStaging(String portStaging) {
        this.portStaging = portStaging;
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

    @Override
    public String toString() {
        return "MarklogicProperties{" +
                "host='" + host + '\'' +
                ", portFinal='" + portFinal + '\'' +
                ", portStaging='" + portStaging + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
