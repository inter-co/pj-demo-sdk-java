package inter.sdk.exemplos.banking.pix;

import inter.InterSdk;
import inter.banking.model.DadosBancarios;
import inter.banking.model.Destinatario;
import inter.banking.model.InstituicaoFinanceira;
import inter.banking.model.Pix;
import inter.banking.model.RespostaIncluirPix;
import inter.banking.model.enums.TipoConta;
import inter.exceptions.SdkException;

import java.math.BigDecimal;

public class IncluirPixDadosBancarios {
    public void exemplo(InterSdk interSdk, String cpfCnpj, String nome, String contaCorrente, String agencia, BigDecimal valor, String codigoBanco, String nomeBanco, String ispb) {
        try {
            InstituicaoFinanceira instituicaoFinanceira = InstituicaoFinanceira.builder()
                    .codigo(codigoBanco)
                    .nome(nomeBanco)
                    .ispb(ispb)
                    .build();
            Destinatario destinatario = DadosBancarios.builder()
                    .cpfCnpj(cpfCnpj)
                    .nome(nome)
                    .contaCorrente(contaCorrente)
                    .tipoConta(TipoConta.CONTA_CORRENTE)
                    .agencia(agencia)
                    .instituicaoFinanceira(instituicaoFinanceira)
                    .build();
            Pix pix = Pix.builder()
                    .valor(valor)
                    .destinatario(destinatario)
                    .build();
            RespostaIncluirPix resposta = interSdk.banking().incluirPix(pix);
            System.out.println("Pix enviado, e2eId=" + resposta.getEndToEndId());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
