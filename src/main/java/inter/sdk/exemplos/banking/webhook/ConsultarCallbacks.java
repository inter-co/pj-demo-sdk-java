package inter.sdk.exemplos.banking.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.Callback;
import inter.banking.model.FiltroBuscarCallbacks;
import inter.exceptions.SdkException;

import java.util.List;

public class ConsultarCallbacks {

    public void exemplo(InterSdk interSdk, String tipo, String dataInicial, String dataFinal, FiltroBuscarCallbacks filtro) {
        try {
            List<Callback> callbacks = interSdk.banking().consultarCallbacks(tipo, dataInicial, dataFinal, filtro);
            System.out.println("Lista de callbacks recebida com sucesso");
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(callbacks));
            System.out.println(callbacks.size() + " callbacks retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
