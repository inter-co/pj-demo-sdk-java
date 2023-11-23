package inter.sdk.exemplos.pix.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.Location;
import inter.pix.model.enums.TipoCob;

public class CriarLocation {
    public void exemplo(InterSdk interSdk, TipoCob tipoCob) {
        try {
            Location location = interSdk.pix().criarLocation(tipoCob);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(location));
            System.out.println("Location criada: " + location.getLocation());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
