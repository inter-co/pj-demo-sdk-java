package inter.sdk.exemplos.pix.pix;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.Pix;

public class ConsultarPix {
    public void exemplo(InterSdk interSdk, String e2eId) {
        try {
            Pix pix = interSdk.pix().consultarPix(e2eId);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pix));
            System.out.println("Pix recuperado, chave=" + pix.getChave());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
