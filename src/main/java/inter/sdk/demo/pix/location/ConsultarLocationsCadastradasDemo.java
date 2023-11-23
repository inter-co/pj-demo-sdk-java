package inter.sdk.demo.pix.location;

import com.google.common.base.Strings;
import inter.InterSdk;
import inter.pix.model.enums.TipoCob;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.location.ConsultarLocationsCadastradas;
import inter.utils.HttpUtils;

public class ConsultarLocationsCadastradasDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String dataInicial = App.getString("dataInicial(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
            String dataFinal = App.getString("dataFinal(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
            String tipo = App.getStringOrNull("Tipo (cob,cobv)");

            TipoCob tipoCob = null;
            if (!Strings.isNullOrEmpty(tipo)) {
                tipoCob = TipoCob.valueOf(tipo);
            }

            System.out.println("Aguarde...");
            new ConsultarLocationsCadastradas().exemplo(interSdk, dataInicial, dataFinal, tipoCob);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
