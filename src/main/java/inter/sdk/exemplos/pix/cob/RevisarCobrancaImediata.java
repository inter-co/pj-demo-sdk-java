package inter.sdk.exemplos.pix.cob;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.pix.model.Calendario;
import inter.pix.model.Cobranca;
import inter.pix.model.CobrancaDetalhada;
import inter.pix.model.Devedor;
import inter.pix.model.Valor;
import inter.exceptions.SdkException;

public class RevisarCobrancaImediata {

    public void exemplo(InterSdk interSdk, String txId, String cpf, String nome, String valorOriginal, String chave, Integer expiracao) {
        try {
            Devedor devedor = Devedor.builder()
                    .cpf(cpf)
                    .nome(nome)
                    .build();
            Valor valor = Valor.builder()
                    .original(valorOriginal)
                    .build();
            Calendario calendario = Calendario.builder()
                    .expiracao(expiracao)
                    .build();
            Cobranca cobranca = Cobranca.builder()
                    .txid(txId)
                    .devedor(devedor)
                    .valor(valor)
                    .chave(chave)
                    .calendario(calendario)
                    .build();
            CobrancaDetalhada cobrancaRevisada = interSdk.pix().revisarCobrancaImediata(cobranca);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobrancaRevisada));
            System.out.println("Cobrança revisada, status=" + cobrancaRevisada.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
