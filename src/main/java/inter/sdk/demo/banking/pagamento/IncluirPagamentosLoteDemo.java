package inter.sdk.demo.banking.pagamento;

import inter.InterSdk;
import inter.banking.model.BoletoLote;
import inter.banking.model.DarfLote;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pagamento.IncluirPagamentosLote;
import inter.utils.HttpUtils;

import java.math.BigDecimal;

public class IncluirPagamentosLoteDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String linhaDigitavel = App.getString("linhaDigitavel");
            BigDecimal valorBoleto = App.getBigDecimal("valorBoleto");
            String dataVencimentoBoleto = App.getString("dataVencimentoBoleto(YYYY-MM-DD)");
            String cnpjCpf = App.getString("cnpjCpf");
            String codigoReceita = App.getString("codigoReceita");
            String dataVencimentoDarf = App.getString("dataVencimentoDarf(YYYY-MM-DD)");
            String descricao = App.getTextoCompleto("descricao");
            String nomeEmpresa = App.getTextoCompleto("nomeEmpresa");
            String periodoApuracao = App.getString("periodoApuracao");
            String valorDarf = App.getString("valorDarf(99.99)");
            String referencia = App.getString("referencia");
            String meuIdentificador = App.getString("meuIdentificador");
            BoletoLote boletoLote = BoletoLote.builder()
                    .codBarraLinhaDigitavel(linhaDigitavel)
                    .valorPagar(valorBoleto)
                    .dataVencimento(dataVencimentoBoleto)
                    .build();
            DarfLote darfLote = DarfLote.builder()
                    .cnpjCpf(cnpjCpf)
                    .codigoReceita(codigoReceita)
                    .dataVencimento(dataVencimentoDarf)
                    .descricao(descricao)
                    .nomeEmpresa(nomeEmpresa)
                    .periodoApuracao(periodoApuracao)
                    .valorPrincipal(valorDarf)
                    .referencia(referencia)
                    .build();

            System.out.println("Aguarde...");
            new IncluirPagamentosLote().exemplo(interSdk, meuIdentificador, boletoLote, darfLote);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
