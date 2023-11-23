package inter.sdk.exemplos.banking.extrato;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.ExtratoEnriquecido;
import inter.banking.model.FiltroConsultarExtratoEnriquecido;
import inter.exceptions.SdkException;

public class ConsultarExtratoEnriquecidoPaginacao {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarExtratoEnriquecido filtro = null; // filtros opcionais para consulta, ver documentação da API
            int pagina = 0;
            int n = 0;
            ExtratoEnriquecido extrato;
            do {
                extrato = interSdk.banking().consultarExtratoEnriquecido(dataInicial, dataFinal, filtro, pagina);
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(extrato));
                n += extrato.getTransacoes().size();
                System.out.println(extrato.getTransacoes().size() + " transações retornadas na página");
                pagina++;
            }  while (pagina < extrato.getTotalPaginas());
            System.out.println(n + " transações retornadas no total");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
