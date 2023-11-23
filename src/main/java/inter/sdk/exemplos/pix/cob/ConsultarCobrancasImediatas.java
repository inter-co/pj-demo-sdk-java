package inter.sdk.exemplos.pix.cob;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.CobrancaDetalhada;
import inter.pix.model.FiltroConsultarCobrancasImediatas;

import java.util.List;

public class ConsultarCobrancasImediatas {

    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarCobrancasImediatas filtro = null; // filtros opcionais para consulta, ver documentação da API
            List<CobrancaDetalhada> cobrancas = interSdk.pix().consultarCobrancasImediatas(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobrancas));
            System.out.println(cobrancas.size() + " cobranças retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
