package inter.sdk.exemplos.cobranca.boletos;

import inter.InterSdk;
import inter.cobranca.model.Boleto;
import inter.cobranca.model.Pessoa;
import inter.cobranca.model.RespostaEmitirBoleto;
import inter.cobranca.model.enums.TipoPessoa;
import inter.exceptions.SdkException;

import java.math.BigDecimal;

public class EmitirBoleto {
    public void exemplo(InterSdk interSdk, TipoPessoa tipoPessoa, String cpfCnpj, String seuNumero, String dataVencimento, BigDecimal valor,
                        String nome, String endereco, String cidade, String uf, String cep) {
        try {
            Pessoa pagador = Pessoa.builder()
                    .cpfCnpj(cpfCnpj)        // CPF/CNPJ do pagador do título
                    .tipoPessoa(tipoPessoa)  // Tipo do pagador: FISICA ou JURIDICA
                    .nome(nome)
                    .endereco(endereco)
                    .cidade(cidade)
                    .uf(uf)
                    .cep(cep)
                    .build();
            Boleto boleto = Boleto.builder()
                    .seuNumero(seuNumero)
                    .valorNominal(valor)            // O valor nominal deve ser maior ou igual à R$2.50
                    .dataVencimento(dataVencimento) // Formato aceito: YYYY-MM-DD
                    .numDiasAgenda(0)               // Número de dias corridos após o vencimento para o cancelamento efetivo automático do boleto. (de 0 até 60)
                    .pagador(pagador)
                    .build();
            RespostaEmitirBoleto resposta = interSdk.cobranca().emitirBoleto(boleto);
            System.out.println("Boleto gerado com sucesso, nossoNumero=" + resposta.getNossoNumero());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
