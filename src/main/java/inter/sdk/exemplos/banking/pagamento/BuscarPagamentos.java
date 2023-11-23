package inter.sdk.exemplos.banking.pagamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.FiltroBuscarPagamentos;
import inter.banking.model.Pagamento;
import inter.exceptions.SdkException;

import java.util.List;

public class BuscarPagamentos {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroBuscarPagamentos filtro = null; // filtros opcionais para consulta, ver documentação da API
            List<Pagamento> pagamentos = interSdk.banking().buscarPagamentos(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pagamentos));
            System.out.println(pagamentos.size() + " pagamentos retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
