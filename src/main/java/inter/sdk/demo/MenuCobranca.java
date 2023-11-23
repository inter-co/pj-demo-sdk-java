package inter.sdk.demo;

import inter.InterSdk;
import inter.sdk.demo.cobranca.boletos.CancelarBoletoDemo;
import inter.sdk.demo.cobranca.boletos.EmitirBoletoDemo;
import inter.sdk.demo.cobranca.boletos.RecuperarBoletoDetalhadoDemo;
import inter.sdk.demo.cobranca.boletos.RecuperarBoletoPdfDemo;
import inter.sdk.demo.cobranca.boletos.RecuperarBoletosDemo;
import inter.sdk.demo.cobranca.boletos.RecuperarBoletosPaginadoDemo;
import inter.sdk.demo.cobranca.boletos.RecuperarSumarioBoletosDemo;
import inter.sdk.demo.cobranca.webhook.ConsultarCallbacksDemo;
import inter.sdk.demo.cobranca.webhook.CriarWebhookCobrancaDemo;
import inter.sdk.demo.cobranca.webhook.ExcluirWebhookCobrancaDemo;
import inter.sdk.demo.cobranca.webhook.ObterWebhookCobrancaDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCobranca {
    private static final int EMITIR_BOLETO = 1;
    private static final int RECUPERAR_BOLETOS = 2;
    private static final int RECUPERAR_BOLETOS_PAGINACAO = 3;
    private static final int RECUPERAR_SUMARIO_BOLETOS = 4;
    private static final int RECUPERAR_BOLETO_DETALHADO = 5;
    private static final int RECUPERAR_BOLETO_PDF = 6;
    private static final int CANCELAR_BOLETO = 7;
    private static final int CRIAR_WEBHOOK = 8;
    private static final int OBTER_WEBHOOK = 9;
    private static final int EXCLUIR_WEBHOOK = 10;
    private static final int CALLBACKS_CONSULTAR = 11;

    public static int showMenu(String ambiente) {
        System.out.println("AMBIENTE " + ambiente);
        System.out.println(EMITIR_BOLETO + " - Emitir Boleto");
        System.out.println(RECUPERAR_BOLETOS + " - Recuperar Boletos");
        System.out.println(RECUPERAR_BOLETOS_PAGINACAO + " - Recuperar Boletos com paginação");
        System.out.println(RECUPERAR_SUMARIO_BOLETOS + " - Recuperar Sumário Boletos");
        System.out.println(RECUPERAR_BOLETO_DETALHADO + " - Recuperar Boleto Detalhado");
        System.out.println(RECUPERAR_BOLETO_PDF + " - Recuperar Boleto PDF");
        System.out.println(CANCELAR_BOLETO + " - Cancelar Boleto");
        System.out.println(CRIAR_WEBHOOK + " - Criar Webhook");
        System.out.println(OBTER_WEBHOOK + " - Obter Webhook");
        System.out.println(EXCLUIR_WEBHOOK + " - Excluir Webhook");
        System.out.println(CALLBACKS_CONSULTAR + " - Consultar callbacks");
        System.out.println("0 - Sair");
        System.out.print("=> ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("opção inválida");
            return showMenu(ambiente);
        }
    }

    public static void execute(int op, InterSdk interSdk) {
        switch (op) {
            case EMITIR_BOLETO:
                new EmitirBoletoDemo().execute(interSdk);
                break;
            case RECUPERAR_BOLETOS:
                new RecuperarBoletosDemo().execute(interSdk);
                break;
            case RECUPERAR_BOLETOS_PAGINACAO:
                new RecuperarBoletosPaginadoDemo().execute(interSdk);
                break;
            case RECUPERAR_SUMARIO_BOLETOS:
                new RecuperarSumarioBoletosDemo().execute(interSdk);
                break;
            case RECUPERAR_BOLETO_DETALHADO:
                new RecuperarBoletoDetalhadoDemo().execute(interSdk);
                break;
            case RECUPERAR_BOLETO_PDF:
                new RecuperarBoletoPdfDemo().execute(interSdk);
                break;
            case CANCELAR_BOLETO:
                new CancelarBoletoDemo().execute(interSdk);
                break;
            case CRIAR_WEBHOOK:
                new CriarWebhookCobrancaDemo().execute(interSdk);
                break;
            case OBTER_WEBHOOK:
                new ObterWebhookCobrancaDemo().execute(interSdk);
                break;
            case EXCLUIR_WEBHOOK:
                new ExcluirWebhookCobrancaDemo().execute(interSdk);
                break;
            case CALLBACKS_CONSULTAR:
                new ConsultarCallbacksDemo().execute(interSdk);
                break;
        }
        System.out.println();
    }
}
