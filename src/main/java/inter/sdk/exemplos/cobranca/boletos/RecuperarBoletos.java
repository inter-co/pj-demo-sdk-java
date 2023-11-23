package inter.sdk.exemplos.cobranca.boletos;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.cobranca.model.BoletoDetalhado;
import inter.cobranca.model.FiltroRecuperarBoletos;
import inter.cobranca.model.Ordenacao;
import inter.cobranca.model.enums.OrdenadoPor;
import inter.cobranca.model.enums.TipoDataBoleto;
import inter.cobranca.model.enums.TipoOrdenacao;
import inter.exceptions.SdkException;

import java.util.List;

public class RecuperarBoletos {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal) {
        try {
            FiltroRecuperarBoletos filtro = FiltroRecuperarBoletos.builder()
                    .filtrarDataPor(TipoDataBoleto.VENCIMENTO)
                    .build();
            Ordenacao ordenacao = Ordenacao.builder()
                    .ordenarPor(OrdenadoPor.DATAVENCIMENTO)
                    .tipoOrdenacao(TipoOrdenacao.DESC)
                    .build();
            List<BoletoDetalhado> boletos = interSdk.cobranca().recuperarBoletos(dataInicial, dataFinal, filtro, ordenacao);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(boletos));
            System.out.println(boletos.size() + " boletos retornados");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
