package inter.sdk.exemplos.pix.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.FiltroConsultarLocations;
import inter.pix.model.PaginaLocations;
import inter.pix.model.enums.TipoCob;

public class ConsultarLocationsCadastradasPaginacao {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal, TipoCob tipoCob) {
        try {
            FiltroConsultarLocations filtro = FiltroConsultarLocations.builder().tipoCob(tipoCob).build();
            int pagina = 0;
            int n = 0;
            PaginaLocations paginaLocations;
            do {
                paginaLocations = interSdk.pix().consultarLocationsCadastradas(dataInicial, dataFinal, filtro, pagina);
                //Se desejar alterar o número de ítens por página, use esta outra forma, alterando o valor "100" para o valor desejado:
                //paginaLocations = interSdk.pix().consultarLocationsCadastradas(dataInicial, dataFinal, filtro, pagina, 100);
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(paginaLocations));
                n += paginaLocations.getLocs().size();
                System.out.println(paginaLocations.getLocs().size() + " locations retornadas na página");
                pagina++;
            } while (pagina < paginaLocations.getQuantidadeDePaginas());
            System.out.println(n + " locations retornados no total");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
