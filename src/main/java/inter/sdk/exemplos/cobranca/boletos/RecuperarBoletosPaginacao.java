package inter.sdk.exemplos.cobranca.boletos;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.cobranca.model.FiltroRecuperarBoletos;
import inter.cobranca.model.Ordenacao;
import inter.cobranca.model.PaginaBoletos;
import inter.exceptions.SdkException;

public class RecuperarBoletosPaginacao {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroRecuperarBoletos filtro = null; // filtros opcionais para consulta, ver documentação da API
            Ordenacao ordenacao = null;           // muda a ordenação, padrão = PAGADOR ascendente
            int pagina = 0;
            int n = 0;
            PaginaBoletos paginaBoletos;
            do {
                paginaBoletos = interSdk.cobranca().recuperarBoletos(dataInicial, dataFinal, filtro, ordenacao, pagina);
                //Se desejar alterar o número de ítens por página, use esta outra forma, alterando o valor "100" para o valor desejado:
                //paginaBoletos = interSdk.cobranca().recuperarBoletos(dataInicial, dataFinal, filtro, ordenacao, pagina, 100);
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(paginaBoletos));
                n += paginaBoletos.getBoletos().size();
                System.out.println(paginaBoletos.getBoletos().size() + " boletos retornados na página");
                pagina++;
            } while (pagina < paginaBoletos.getQuantidadeDePaginas());
            System.out.println(n + " boletos retornados no total");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
