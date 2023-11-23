package inter.sdk.exemplos.pix.cob;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.pix.model.Calendario;
import inter.pix.model.Cobranca;
import inter.pix.model.CobrancaDetalhada;
import inter.pix.model.Devedor;
import inter.pix.model.Valor;
import inter.exceptions.SdkException;

public class CriarCobrancaImediata {

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
                    .txid(txId) // se for null, será gerado pelo PSP
                    .devedor(devedor)
                    .valor(valor)
                    .chave(chave)
                    .calendario(calendario)
                    .build();
            CobrancaDetalhada cobrancaCriada = interSdk.pix().criarCobrancaImediata(cobranca);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobrancaCriada));
            System.out.println("Cobrança criada, status=" + cobrancaCriada.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
