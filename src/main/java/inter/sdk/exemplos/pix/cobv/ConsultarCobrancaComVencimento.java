package inter.sdk.exemplos.pix.cobv;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.CobrancaVencimentoDetalhada;

public class ConsultarCobrancaComVencimento {

    public void exemplo(InterSdk interSdk, String txId) {
        try {
            CobrancaVencimentoDetalhada cobranca = interSdk.pix().consultarCobrancaComVencimento(txId);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobranca));
            System.out.println("Cobrança recuperada: " + cobranca.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
