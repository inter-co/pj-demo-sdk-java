package inter.sdk.exemplos.pix.pix;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.FiltroConsultarPixRecebidos;
import inter.pix.model.Pix;

import java.util.List;

public class ConsultarPixRecebidos {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarPixRecebidos filtro = null; // filtros opcionais para consulta, ver documentação da API
            List<Pix> lista = interSdk.pix().consultarPixRecebidos(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(lista));
            System.out.println(lista.size() + " pix retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
