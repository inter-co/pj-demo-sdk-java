package inter.sdk.exemplos.banking.pix;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.Chave;
import inter.banking.model.Destinatario;
import inter.banking.model.Pix;
import inter.banking.model.RespostaIncluirPix;
import inter.exceptions.SdkException;

import java.math.BigDecimal;

public class IncluirPixChave {
    public void exemplo(InterSdk interSdk, String chave, BigDecimal valor) {
        try {
            Destinatario destinatario = Chave.builder()
                    .chave(chave)
                    .build();
            Pix pix = Pix.builder()
                    .valor(valor)
                    .destinatario(destinatario)
                    .build();
            RespostaIncluirPix resposta = interSdk.banking().incluirPix(pix);
            System.out.println("Pix enviado, e2eId=" + resposta.getEndToEndId());
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(resposta));
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
