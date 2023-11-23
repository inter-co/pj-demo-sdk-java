package inter.sdk.exemplos.pix.cobv;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.FiltroConsultarCobrancasComVencimento;
import inter.pix.model.PaginaCobrancasVencimento;

public class ConsultarCobrancasComVencimentoPaginacao {

    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroConsultarCobrancasComVencimento filtro = null; // filtros opcionais para consulta, ver documentação da API
            int pagina = 0;
            int n = 0;
            PaginaCobrancasVencimento paginaCobrancas;
            do {
                paginaCobrancas = interSdk.pix().consultarCobrancasComVencimento(dataInicial, dataFinal, filtro, pagina);
                //Se desejar alterar o número de ítens por página, use esta outra forma, alterando o valor "100" para o valor desejado:
                //paginaCobrancas = interSdk.pix().consultarCobrancasImediatas(dataInicial, dataFinal, filtro, pagina, 100);
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(paginaCobrancas));
                n += paginaCobrancas.getCobrancas().size();
                System.out.println(paginaCobrancas.getCobrancas().size() + " cobranças retornadas na página");
                pagina++;
            } while (pagina < paginaCobrancas.getQuantidadeDePaginas());
            System.out.println(n + " cobranças retornadoas no total");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
