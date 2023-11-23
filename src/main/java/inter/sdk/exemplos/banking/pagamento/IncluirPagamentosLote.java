package inter.sdk.exemplos.banking.pagamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.BoletoLote;
import inter.banking.model.DarfLote;
import inter.banking.model.ItemLote;
import inter.banking.model.RespostaIncluirPagamentosLote;
import inter.exceptions.SdkException;

import java.util.ArrayList;
import java.util.List;

public class IncluirPagamentosLote {
    public void exemplo(InterSdk interSdk, String meuIdentificador, BoletoLote boleto, DarfLote darf) {
        try {
            List<ItemLote> pagamentos = new ArrayList<>();
            pagamentos.add(boleto);
            pagamentos.add(darf);
            RespostaIncluirPagamentosLote resposta = interSdk.banking().incluirPagamentosLote(meuIdentificador, pagamentos);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(resposta));
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
