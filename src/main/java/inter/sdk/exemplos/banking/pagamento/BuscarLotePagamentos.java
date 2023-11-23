package inter.sdk.exemplos.banking.pagamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.ProcessamentoLote;
import inter.exceptions.SdkException;

public class BuscarLotePagamentos {
    public void exemplo(InterSdk interSdk, String idLote) {
        try {
            ProcessamentoLote resposta = interSdk.banking().buscarLotePagamentos(idLote);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(resposta));
            System.out.println(resposta.getPagamentos().size() + " pagamentos retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
