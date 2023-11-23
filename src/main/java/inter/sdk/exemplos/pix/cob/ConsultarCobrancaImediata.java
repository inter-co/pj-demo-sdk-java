package inter.sdk.exemplos.pix.cob;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.CobrancaDetalhada;

public class ConsultarCobrancaImediata {

    public void exemplo(InterSdk interSdk, String txId) {
        try {
            CobrancaDetalhada cobranca = interSdk.pix().consultarCobrancaImediata(txId);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobranca));
            System.out.println("Cobrança recuperada: " + cobranca.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
