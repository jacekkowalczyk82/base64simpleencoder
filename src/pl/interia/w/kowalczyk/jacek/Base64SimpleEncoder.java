/**
 *
 */
package pl.interia.w.kowalczyk.jacek;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

/**
 * @author kowalczykj
 */
public class Base64SimpleEncoder {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        final Base64SimpleEncoder b64 = new Base64SimpleEncoder();
        final String output = null;

        if (args.length > 0) {
            for (final String arg : args) {

                System.out.println(arg + " --Base64--> " + b64.encodeBase64(arg));
                System.out.println("\n");

            }
        }

        ////////////////////////////////

        final String configPath = b64.getUserHomeDirPath() + "/.jira-client-config.properties";
        try {
            final Properties props = b64.getPropertiesFromConfigFile(configPath);
            final String encodedUsername = props.getProperty("encoded.username");
            // System.out.println("encoded.username value is \t" + encodedUsername);
            final String encodedPassword = props.getProperty("encoded.password");
            // System.out.println("encoded.password value is \t" + encodedPassword);

            System.out.println("decoded username: " + b64.decodeBase64(encodedUsername));
            System.out.println("decoded password: " + b64.decodeBase64(encodedPassword));

        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ////////////////////////
        final String str = "hasL0";
        System.out.println(System.getProperty("user.home"));
        //// encrypted password aGFzTDA=
        System.out.println("Base64 encoded is \taGFzTDA=");
        // encode data using BASE64
        final String encoded = DatatypeConverter.printBase64Binary(str.getBytes());
        System.out.println("encoded value is \t" + encoded);

        // Decode data
        final String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        System.out.println("decoded value is \t" + decoded);

        System.out.println("original value is \t" + str);

    }

    public String encodeBase64(final String in) {

        final String encoded = DatatypeConverter.printBase64Binary(in.getBytes());
        return encoded;
    }

    public String decodeBase64(final String encoded) {

        final String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        return decoded;
    }

    public String getUserHomeDirPath() {

        return System.getProperty("user.home");
    }

    public Properties getPropertiesFromConfigFile(final String filepath) throws IOException {
        final Properties props = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filepath);

            if (inputStream != null) {
                props.load(inputStream);
            }
        } catch (final FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new FileNotFoundException(e.getMessage());
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return props;

    }

}
