package inter.sdk.exemplos.pix.pix;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.FiltroConsultarPixRecebidos;
import inter.pix.model.PaginaPix;

public class ConsultarPixRecebidosPaginacao {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarPixRecebidos filtro = null; // filtros opcionais para consulta, ver documentação da API
            int pagina = 0;
            int n = 0;
            PaginaPix paginaPix;
            do {
                paginaPix = interSdk.pix().consultarPixRecebidos(dataInicial, dataFinal, filtro, pagina);
                //Se desejar alterar o número de ítens por página, use esta outra forma, alterando o valor "100" para o valor desejado:
                //paginaPix = interSdk.pix().consultarPixRecebidos(dataInicial, dataFinal, filtro, pagina, 100);
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(paginaPix));
                n += paginaPix.getListaPix().size();
                System.out.println(paginaPix.getListaPix().size() + " pix retornados na página");
                pagina++;
            } while (pagina < paginaPix.getQuantidadeDePaginas());
            System.out.println(n + " pix retornados no total");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
