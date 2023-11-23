package inter.sdk.demo.banking.pix;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pix.IncluirPixChave;
import inter.utils.HttpUtils;

import java.math.BigDecimal;

public class IncluirPixChaveDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String chave = App.getString("chave");
            BigDecimal valor = App.getBigDecimal("valor(99.99)");

            System.out.println("Aguarde...");
            new IncluirPixChave().exemplo(interSdk, chave, valor);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
