package inter.sdk.exemplos.banking.extrato;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.FiltroConsultarExtratoEnriquecido;
import inter.banking.model.TransacaoEnriquecida;
import inter.exceptions.SdkException;

import java.util.List;

public class ConsultarExtratoEnriquecido {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarExtratoEnriquecido filtro = null; // filtros opcionais para consulta, ver documentação da API
            List<TransacaoEnriquecida> transacoes = interSdk.banking().consultarExtratoEnriquecido(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(transacoes));
            System.out.println(transacoes.size() + " transações retornadas");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
