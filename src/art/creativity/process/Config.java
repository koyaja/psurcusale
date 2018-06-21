package art.creativity.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Requirements class for services
 */
public class Config {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8615011458202541601L;
	private String username="";
	private String password="";
	private String version;
	private static Config config = null;
	private String url;

	private Config(){
//		chargeConfig();
	}

	private Config(String username, String password) {
		this.username = username;
		this.password = password;
//		chargeConfig();
	}

	/**
	 * takes the name of a property configuration and 
	 * returns an object.
	 * @return Object
	 */
	/*public static Object getConfig(String property){
		if(config==null){
			config = new Config();
		}
		return jsonConfig.getProperty(property);		
	}*/
	
	/*private void chargeConfig(){
//		File file = new File("config.json");
		
		try {		
			String json = readJsonFile(getClass().getResourceAsStream("/config.json"));
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.create();
			jsonConfig = gson.fromJson(json.toString(), JsonConfig.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new Exception("file config not found");
		} 
	}*/
	
	/**
	 * Creates a configuration parameter required for a user.
	 * @param username
	 * @param password
	 * @param url
	 * @return Config
	 */
	public static Config getConfig(String username, String password, String url){
		Config conf = new Config(username, password);
		/*if(url==null||url.isEmpty())conf.setUrl(UtilsConnexion.URL_DEFAULT_PAGE);
		else conf.setUrl(url);*/
                conf.setUrl(url);
		return conf;
	}

	/**
	 * Takes a feed, read the stream and returns the data as text.
	 * @param inputStream
	 * @return String
	 */
	public static String readJsonFile(InputStream inputStream){
    	BufferedReader in;
    	in = new BufferedReader(
		        new InputStreamReader(inputStream));
		
		String inputLine;
		StringBuffer response = new StringBuffer();

		try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.toString();
    }
	
	/**
	 * return the API version
	 * @return String
	 */
	/*public String getVersion(){
		if(version==null){
			GsonBuilder gb = new GsonBuilder();
	        Gson gson = gb.create();
	        JsonObject jsonObject = gson.fromJson(readJsonFile(getClass().getResourceAsStream("/composer.json")), JsonObject.class);
	        version = jsonObject.get("version").getAsString();
		}
		
        return version;
	}*/
	
	/**
	 * takes the address of the new json configuration file of the service to use and loads it into the configuration.
	 * @param urlJsonEndpoint
	 */ 
	/*public void setNewJsonConfig(String urlJsonEndpoint) throws IOException{
		HttpURLConnection client;
		URL obj = new URL(urlJsonEndpoint);
		client = (HttpURLConnection) obj.openConnection();
		client.setRequestMethod("GET");
		client.setRequestProperty("Content-Type", "application/json");
		client.setRequestProperty("api-sdk", "java-"+getVersion());
		int responseCode = client.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {		
			//print result
			String json = readJsonFile(client.getInputStream());
			GsonBuilder gb = new GsonBuilder();
			Gson gson = gb.create();
			jsonConfig = gson.fromJson(json.toString(), JsonConfig.class);
			
		}else{
			String response = Config.readJsonFile(client.getErrorStream());;
		}	
	}*/
	
	
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * set username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
