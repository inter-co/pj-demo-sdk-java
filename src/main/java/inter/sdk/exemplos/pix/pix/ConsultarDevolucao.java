package inter.sdk.exemplos.pix.pix;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.DevolucaoDetalhada;

public class ConsultarDevolucao {
    public void exemplo(InterSdk interSdk, String e2eId, String id) {
        try {
            DevolucaoDetalhada devolucao = interSdk.pix().consultarDevolucao(e2eId, id);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(devolucao));
            System.out.println("Devolução recuperada, status=" + devolucao.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
