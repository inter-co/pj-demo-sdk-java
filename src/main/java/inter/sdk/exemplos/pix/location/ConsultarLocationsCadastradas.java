package inter.sdk.exemplos.pix.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.FiltroConsultarLocations;
import inter.pix.model.Location;
import inter.pix.model.enums.TipoCob;

import java.util.List;

public class ConsultarLocationsCadastradas {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal, TipoCob tipoCob) {
        try {
            FiltroConsultarLocations filtro = FiltroConsultarLocations.builder().tipoCob(tipoCob).build();
            List<Location> lista = interSdk.pix().consultarLocationsCadastradas(dataInicial, dataFinal, filtro);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(lista));
            System.out.println(lista.size() + " locations retornadas");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
