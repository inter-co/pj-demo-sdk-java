package inter.sdk.exemplos.pix.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.Location;

public class DesvincularLocation {
    public void exemplo(InterSdk interSdk, String id) {
        try {
            Location location = interSdk.pix().desvincularLocation(id);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(location));
            System.out.println("Location desvinculada " + location.getLocation());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
