package inter.sdk.exemplos.banking.extrato;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.Extrato;
import inter.exceptions.SdkException;

public class ConsultarExtrato {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            Extrato extrato = interSdk.banking().consultarExtrato(dataInicial, dataFinal);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(extrato));
            System.out.println(extrato.getTransacoes().size() + " transações retornadas");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
