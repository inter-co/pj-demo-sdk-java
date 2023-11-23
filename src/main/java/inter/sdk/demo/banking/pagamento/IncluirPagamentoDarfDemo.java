package inter.sdk.demo.banking.pagamento;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pagamento.IncluirPagamentoDarf;
import inter.utils.HttpUtils;

public class IncluirPagamentoDarfDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String cnpjCpf = App.getString("cnpjCpf");
            String codigoReceita = App.getString("codigoReceita");
            String dataVencimento = App.getString("dataVencimento(YYYY-MM-DD)");
            String descricao = App.getString("descricao");
            String nomeEmpresa = App.getTextoCompleto("nomeEmpresa");
            String periodoApuracao = App.getString("periodoApuracao");
            String valorPrincipal = App.getString("valorPrincipal(99.99)");
            String referencia = App.getString("referencia");

            System.out.println("Aguarde...");
            new IncluirPagamentoDarf().exemplo(interSdk, cnpjCpf, codigoReceita, dataVencimento, descricao, nomeEmpresa, periodoApuracao, valorPrincipal, referencia);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
