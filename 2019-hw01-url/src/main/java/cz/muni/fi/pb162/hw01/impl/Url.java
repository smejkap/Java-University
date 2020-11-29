package cz.muni.fi.pb162.hw01.impl;

import cz.muni.fi.pb162.hw01.url.PortResolver;
import cz.muni.fi.pb162.hw01.url.SmartUrl;

import java.util.Arrays;

/**
 * Class representing Url
 *
 * @author Petr Smejkal
 */
public class Url implements SmartUrl, PortResolver {
    private String url;

    /**
     * Constructor of Url class
     *
     * @param url Entered String url for analyze
     */
    public Url(String url) {
        this.url = url;
    }

    @Override
    public String getAsString() {
        String tmpUrl = this.getProtocol() + "://" + this.getHost();
        String path = this.getPath();
        if (!path.equals("")) {
            tmpUrl += "/" + path;
        }
        String query = this.getQuery();
        if (!query.equals("")) {
            tmpUrl += "?" + query;
        }
        String fragment = this.getFragment();
        if (!fragment.equals("")) {
            tmpUrl += "#" + fragment;
        }
        if (this.getPort() != this.getPort(this.getProtocol())) {
            return null;
        }
        return tmpUrl;
    }

    @Override
    public String getAsRawString() {
        return this.url;
    }

    @Override
    public boolean isSameAs(SmartUrl url) {
        if (url.getPort() != this.getPort()) {
            return false;
        }
        return this.getAsString().equals(url.getAsString());
    }

    @Override
    public boolean isSameAs(String url) {
        Url tmpUrl = new Url(url);
        if (tmpUrl.getPort() != this.getPort()) {
            return false;
        }
        return this.getAsString().equals(tmpUrl.getAsString());
    }

    @Override
    public String getHost() {
        String[] tmpHost = url.split("://", 2);
        String startHost = "";
        String[] host;
        if (tmpHost.length < 2) {
            if (tmpHost[0].equals("")) {
                return "";
            }
            startHost = tmpHost[0];
        } else {
            startHost = tmpHost[1];
        }
        host = startHost.split(":", 2);
        if (host.length < 2) {
            host = startHost.split("/");
        }
        return host[0];
    }

    @Override
    public String getProtocol() {
        String[] protocol = url.split("://", 2);
        if (protocol.length == 2) {
            return protocol[0];
        }
        return "";
    }

    @Override
    public int getPort() {
        String[] protocol = url.split("://", 2);
        int firstProtocol = 0;
        int secondPort = 0;
        if (protocol.length == 2) {
            firstProtocol = getPort(protocol[0]);
        }
        String[] port = protocol[1].split(":", 2);
        if (port.length == 1) {
            secondPort = -1;
        } else {
            String[] isExplicit = port[1].split("/|#|\\?", 2);
            try {
                secondPort = Integer.parseInt(isExplicit[0]);
            } catch (NumberFormatException e) {
                secondPort = -1;
            }
        }
        if (secondPort > 0) {
            return secondPort;
        } else {
            return firstProtocol;
        }
    }

    @Override
    public String getPath() {
        String[] hasProtocol = url.split("://", 2);
        String withoutProtocol = "";
        if (hasProtocol.length < 2) {
            withoutProtocol = hasProtocol[0];
        } else {
            withoutProtocol = hasProtocol[1];
        }
        String[] rawPath = withoutProtocol.split("/", 2);
        if (rawPath.length < 2) {
            return "";
        }
        if (rawPath[1].equals("")) {
            return "";
        }
        String[] path = rawPath[1].split("#|\\?", 2);
        return canonisePath(path[0]);
    }

    @Override
    public String getQuery() {
        String[] query = url.split("\\?", 2);
        if (query.length == 1) {
            return "";
        }
        if (query[1].equals("")) {
            return "";
        }
        String[] queryParam = query[1].split("&");
        Arrays.sort(queryParam);
        String resultQuery = "";
        for (int i = 0; i < queryParam.length - 1; i++) {
            resultQuery += queryParam[i] + "&";
        }
        resultQuery += queryParam[queryParam.length - 1];
        return resultQuery;
    }

    @Override
    public String getFragment() {
        String[] fragment = url.split("#", 2);
        if (fragment.length == 1) {
            return "";
        }
        return fragment[1];
    }

    @Override
    public int getPort(String schema) {
        return Ports.valueOf(schema.toUpperCase()).getValue();
    }

    /**
     * Method for canonising given Path.
     *
     * @param rawPath String path for canonising
     * @return Returns canonised path
     */
    private String canonisePath(String rawPath) {
        int level = 0;
        String[] dividedPath = rawPath.split("/");
        String[] canonisedPath = new String[dividedPath.length];
        for (int i = 0; i < dividedPath.length; i++) {
            if (dividedPath[i].equals("..")) {
                if (i == 0) {
                    return "";
                }
                if ((level - 1) < 0) {
                    return "";
                }
                canonisedPath[level - 1] = "";
                level--;
            }
            if (!(dividedPath[i].equals("..")) && !(dividedPath[i].equals("."))) {
                canonisedPath[level] = dividedPath[i];
                level++;
            }
        }
        String returnedPath = "";
        for (int j = 0; j < canonisedPath.length; j++) {
            if (canonisedPath[j] != null) {
                returnedPath += canonisedPath[j] + "/";
            }
        }
        return returnedPath.substring(0, returnedPath.lastIndexOf('/'));
    }
}

