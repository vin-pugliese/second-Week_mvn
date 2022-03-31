package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private static Log L;
    private Properties properties;
    private InputStream inputStream;
    private String resourceName;
    private ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public ReadProperties(){
        this.init();
    }

    /**
     * Constructor
     *
     * @param properties
     * @param inputStream
     */
    public ReadProperties(Properties properties, InputStream inputStream) {
        this.properties = properties;
        this.inputStream = inputStream;
    }

    public void init(){
        this.L = Log.getInstance();
        this.properties = new Properties();

    }


    public void read(String resourceName) throws IOException {

        inputStream = new FileInputStream("src/main/resources/" +resourceName);

        this.properties.load(inputStream);
    }

    public void read() throws IOException {

        this.resourceName = "application.properties";
        inputStream = new FileInputStream("src/main/resources/" +this.resourceName);

        this.properties.load(inputStream);
    }

 /*   public static void main(String[] args)  {
        ReadProperties rp = new ReadProperties();

        rp.init();
        try {
            rp.read();

            String user = rp.properties.getProperty("db.username");
            String psw = rp.properties.getProperty("db.password");
            String dburl = rp.properties.getProperty("db.url");
            String dbdriver= rp.properties.getProperty("db.driverUrl");

            L.info(user);
            L.info(psw);
            L.info(dburl);
            L.info(dbdriver);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }*/






    public String getUser() {
        String user = this.properties.getProperty("db.username");
        return user;
    }

    public void setUser(String user) {
        //this.user = user;
    }

    public String getPsw() {
        String psw = this.properties.getProperty("db.password");
        return psw;
    }

    public void setPsw(String psw) {
        //this.psw = psw;
    }

    public String getDburl() {
        String dburl = this.properties.getProperty("db.url");
        return dburl;
    }

    public void setDburl(String dburl) {
        //this.dburl = dburl;
    }

    public String getDbdriver() {
        String dbdriver= this.properties.getProperty("db.driverUrl");
        return dbdriver;
    }

    public void setDbdriver(String dbdriver) {
       // this.dbdriver = dbdriver;
    }

    public static Log getL() {
        return L;
    }

    public static void setL(Log l) {
        L = l;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public ClassLoader getLoader() {
        return loader;
    }

    public void setLoader(ClassLoader loader) {
        this.loader = loader;
    }
}
