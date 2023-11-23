package inter.sdk.exemplos.banking.pagamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.FiltroBuscarPagamentosDarf;
import inter.banking.model.RetornoPagamentoDarf;
import inter.exceptions.SdkException;

import java.util.List;

public class BuscarPagamentosDarf {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroBuscarPagamentosDarf filtro = new FiltroBuscarPagamentosDarf();
            //filtro.setCamposAdicionais("nomeFiltro", "valorFiltro");
            List<RetornoPagamentoDarf> pagamentos = interSdk.banking().buscarPagamentosDarf(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pagamentos));
            System.out.println(pagamentos.size() + " pagamentos de DARF retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
