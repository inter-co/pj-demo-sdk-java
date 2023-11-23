package inter.sdk.exemplos.pix.cobv;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.CobrancaVencimentoDetalhada;
import inter.pix.model.FiltroConsultarCobrancasComVencimento;

import java.util.List;

public class ConsultarCobrancasComVencimento {

    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarCobrancasComVencimento filtro = null; // filtros opcionais para consulta, ver documentação da API
            List<CobrancaVencimentoDetalhada> cobrancas = interSdk.pix().consultarCobrancasComVencimento(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobrancas));
            System.out.println(cobrancas.size() + " cobranças retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
