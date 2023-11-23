package inter.sdk.exemplos.cobranca.boletos;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.cobranca.model.BoletoDetalhado;
import inter.exceptions.SdkException;

public class RecuperarBoletoDetalhado {
    public void exemplo(InterSdk interSdk, String nossoNumero) {
        try {
            BoletoDetalhado boleto = interSdk.cobranca().recuperarBoletoDetalhado(nossoNumero);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(boleto));
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
