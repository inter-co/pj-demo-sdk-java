package inter.sdk.exemplos.cobranca.boletos;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.cobranca.model.FiltroRecuperarSumarioBoletos;
import inter.cobranca.model.Sumario;
import inter.exceptions.SdkException;

public class RecuperarSumarioBoletos {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroRecuperarSumarioBoletos filtro = null; // filtros opcionais para consulta, ver documentação da API
            Sumario sumario = interSdk.cobranca().recuperarSumarioBoletos(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(sumario));
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
