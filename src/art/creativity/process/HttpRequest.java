/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.creativity.process;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Geraud
 */
public class HttpRequest {

    private HttpURLConnection client;
    private HashMap<String, String> header = new HashMap<>();
    private Config config;

    /**
     * Initialization of the manufacturer.
     *
     * @param config Config
     */
    public HttpRequest(Config config) {
        this.config = config;
    }

    /**
     * Adds a general request property specified by a key-value pair. This
     * method will not overwrite existing values associated with the same key.
     *
     * @param key - the keyword by which the request is known (e.g., "Accept").
     * @param value - the value associated with it.
     */
    public void addHeader(String key, String value) {
        header.put(key, value);
    }

    /**
     * Adds a general request property specified by a key-value pair. This
     * method will not overwrite existing values associated with the same key.
     */
    public void addHeader(HashMap<String, String> map) {
        Set<Entry<String, String>> set = map.entrySet();
        for (Entry<String, String> entry : set) {
            header.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * retrieves the data on the URL ending with "route".
     *
     * @param method
     * @param route
     * @param requestOptions
     * @return String
     */
    public String send(String method, String route, String requestOptions) {
        String url = config.getUrl() + route;

        try {

            byte[] postDataBytes = requestOptions.getBytes("UTF-8");
            URL obj = new URL(url);
            client = (HttpURLConnection) obj.openConnection();

            client.setRequestMethod(method.toUpperCase());
            Set<Entry<String, String>> set = header.entrySet();
            for (Entry<String, String> entry : set) {
                client.addRequestProperty(entry.getKey(), entry.getValue());
            }
            if (!config.getUsername().isEmpty() && !config.getPassword().isEmpty()) {
                String userPassword = config.getUsername() + ":" + config.getPassword();
                //String encoded = java.util.Base64.getEncoder().encodeToString(((userPassword).getBytes()), Base64.NO_WRAP);
                Authenticator.setDefault(new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(config.getUsername(), config.getPassword().toCharArray());
                    }
                });
//				client.setRequestProperty("Authorization", "Basic " + encoded);

            }
            client.addRequestProperty("accept", "application/json");
            client.addRequestProperty("Content-Type", "application/json");
            client.addRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            //if(config.getCertifiedPath()!=null)client.setRequestProperty("verify", config.getCertifiedPath());			
            //client.setRequestProperty("partner-token", config.getPartnerToken());
            if (!method.toLowerCase().equals("get")) {
                client.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(client.getOutputStream());
                wr.write(postDataBytes);
                wr.flush();
                wr.close();
            }

            int responseCode = client.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return Config.readJsonFile(client.getInputStream());
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                String response = Config.readJsonFile(client.getErrorStream());
                System.out.println(response.toString());
            } else {
                throw new HttpRetryException(client.getResponseMessage(), client.getResponseCode());
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * returns the HttpURLConnection
     *
     * @return HttpURLConnection
     */
    public HttpURLConnection getClient() {
        return client;
    }

    /**
     * set the HttpURLConnection
     *
     * @param client
     */
    public void setClient(HttpURLConnection client) {
        this.client = client;
    }

    /**
     * returns the request property
     *
     * @return HashMap
     */
    public HashMap<String, String> getHeader() {
        return header;
    }

    /**
     * set the request property
     *
     * @param header
     */
    public void setHeader(HashMap<String, String> header) {
        this.header = header;
    }

    /**
     * return config
     *
     * @return Config
     */
    public Config getConfig() {
        return config;
    }

    /**
     * set config
     *
     * @param config
     */
    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * return url to connect
     *
     * @return String
     */
    public String getUrl() {
        return config.getUrl();
    }

    /**
     * set url to connectConfig.java
     *
     * @param url
     */
    public void setUrl(String url) {
        config.setUrl(url);
    }
}
