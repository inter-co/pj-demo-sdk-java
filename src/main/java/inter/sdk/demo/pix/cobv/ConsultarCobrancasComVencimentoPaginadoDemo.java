package inter.sdk.demo.pix.cobv;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.cobv.ConsultarCobrancasComVencimentoPaginacao;
import inter.utils.HttpUtils;

public class ConsultarCobrancasComVencimentoPaginadoDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String dataInicial = App.getString("dataInicial(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
            String dataFinal = App.getString("dataFinal(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");

            System.out.println("Aguarde...");
            new ConsultarCobrancasComVencimentoPaginacao().exemplo(interSdk, dataInicial, dataFinal);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
