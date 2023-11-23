package inter.sdk.exemplos.pix.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.pix.model.Callback;
import inter.pix.model.FiltroBuscarCallbacks;
import inter.exceptions.SdkException;

import java.util.List;

public class ConsultarCallbacks {

    public void exemplo(InterSdk interSdk, String dataHoraInicial, String dataHoraFinal, FiltroBuscarCallbacks filtro) {
        try {
            List<Callback> callbacks = interSdk.pix().consultarCallbacks(dataHoraInicial, dataHoraFinal, filtro);
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
