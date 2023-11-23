package inter.sdk.demo;

import inter.InterSdk;
import inter.sdk.demo.banking.webhook.ConsultarCallbacksDemo;
import inter.sdk.demo.pix.cob.ConsultarCobrancaImediataDemo;
import inter.sdk.demo.pix.cob.ConsultarCobrancasImediatasDemo;
import inter.sdk.demo.pix.cob.ConsultarCobrancasImediatasPaginadoDemo;
import inter.sdk.demo.pix.cob.CriarCobrancaImediataDemo;
import inter.sdk.demo.pix.cob.CriarCobrancaImediataTxIdDemo;
import inter.sdk.demo.pix.cob.RevisarCobrancaImediataDemo;
import inter.sdk.demo.pix.cobv.ConsultarCobrancaComVencimentoDemo;
import inter.sdk.demo.pix.cobv.ConsultarCobrancasComVencimentoDemo;
import inter.sdk.demo.pix.cobv.ConsultarCobrancasComVencimentoPaginadoDemo;
import inter.sdk.demo.pix.cobv.CriarCobrancaComVencimentoTxIdDemo;
import inter.sdk.demo.pix.cobv.RevisarCobrancaComVencimentoDemo;
import inter.sdk.demo.pix.location.ConsultarLocationsCadastradasDemo;
import inter.sdk.demo.pix.location.ConsultarLocationsCadastradasPaginadoDemo;
import inter.sdk.demo.pix.location.CriarLocationDemo;
import inter.sdk.demo.pix.location.DesvincularLocationDemo;
import inter.sdk.demo.pix.location.RecuperarLocationDemo;
import inter.sdk.demo.pix.pix.ConsultarDevolucaoDemo;
import inter.sdk.demo.pix.pix.ConsultarPixDemo;
import inter.sdk.demo.pix.pix.ConsultarPixRecebidosDemo;
import inter.sdk.demo.pix.pix.ConsultarPixRecebidosPaginadoDemo;
import inter.sdk.demo.pix.pix.SolicitarDevolucaoDemo;
import inter.sdk.demo.pix.webhook.CriarWebhookPixDemo;
import inter.sdk.demo.pix.webhook.ExcluirWebhookPixDemo;
import inter.sdk.demo.pix.webhook.ObterWebhookPixDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPix {
    private static final int COBRANCA_IMEDIATA_CRIAR = 1;
    private static final int COBRANCA_IMEDIATA_CRIAR_TXID = 2;
    private static final int COBRANCA_IMEDIATA_REVISAR = 3;
    private static final int COBRANCA_IMEDIATA_CONSULTAR = 4;
    private static final int COBRANCAS_IMEDIATAS_CONSULTAR = 5;
    private static final int COBRANCAS_IMEDIATAS_CONSULTAR_PAGINACAO = 6;
    private static final int COBRANCA_COM_VENCIMENTO_CRIAR_TXID = 7;
    private static final int COBRANCA_COM_VENCIMENTO_REVISAR = 8;
    private static final int COBRANCA_COM_VENCIMENTO_CONSULTAR = 9;
    private static final int COBRANCAS_COM_VENCIMENTO_CONSULTAR = 10;
    private static final int COBRANCAS_COM_VENCIMENTO_CONSULTAR_PAGINACAO = 11;
    private static final int LOCATION_CRIAR = 12;
    private static final int LOCATION_RECUPERAR = 13;
    private static final int LOCATION_DESVINCULAR = 14;
    private static final int LOCATIONS_CADASTRADAS_CONSULTAR = 15;
    private static final int LOCATIONS_CADASTRADAS_CONSULTAR_PAGINACAO = 16;
    private static final int PIX_CONSULTAR = 17;
    private static final int PIX_RECEBIDOS_CONSULTAR = 18;
    private static final int PIX_RECEBIDOS_CONSULTAR_PAGINACAO = 19;
    private static final int PIX_DEVOLUCAO_SOLICITAR = 20;
    private static final int PIX_DEVOLUCAO_CONSULTAR = 21;
    private static final int WEBHOOK_CRIAR = 22;
    private static final int WEBHOOK_OBTER = 23;
    private static final int WEBHOOK_EXCLUIR = 24;
    private static final int CALLBACKS_CONSULTAR = 25;

    public static int showMenu(String ambiente) {
        System.out.println("AMBIENTE " + ambiente);
        System.out.println(COBRANCA_IMEDIATA_CRIAR + " - Criar Cobrança Imediata");
        System.out.println(COBRANCA_IMEDIATA_CRIAR_TXID + " - Criar Cobrança Imediata TxId");
        System.out.println(COBRANCA_IMEDIATA_REVISAR + " - Revisar Cobrança Imediata");
        System.out.println(COBRANCA_IMEDIATA_CONSULTAR + " - Consultar Cobrança Imediata por TxId");
        System.out.println(COBRANCAS_IMEDIATAS_CONSULTAR + " - Consultar Cobranças Imediatas");
        System.out.println(COBRANCAS_IMEDIATAS_CONSULTAR_PAGINACAO + " - Consultar Cobranças Imediatas com paginação");

        System.out.println(COBRANCA_COM_VENCIMENTO_CRIAR_TXID + " - Criar Cobrança com vencimento com txId");
        System.out.println(COBRANCA_COM_VENCIMENTO_REVISAR + " - Revisar Cobrança com vencimento");
        System.out.println(COBRANCA_COM_VENCIMENTO_CONSULTAR + " - Consultar Cobrança com vencimento por TxId");
        System.out.println(COBRANCAS_COM_VENCIMENTO_CONSULTAR + " - Consultar Cobranças com vencimento");
        System.out.println(COBRANCAS_COM_VENCIMENTO_CONSULTAR_PAGINACAO + " - Consultar Cobranças com vencimento com paginação");

        System.out.println(LOCATION_CRIAR + " - Criar Location");
        System.out.println(LOCATION_RECUPERAR + " - Recuperar Location");
        System.out.println(LOCATION_DESVINCULAR + " - Desvincular Location");
        System.out.println(LOCATIONS_CADASTRADAS_CONSULTAR + " - Consultar Locations Cadastradas");
        System.out.println(LOCATIONS_CADASTRADAS_CONSULTAR_PAGINACAO + " - Consultar Locations Cadastradas com paginação");

        System.out.println(PIX_CONSULTAR + " - Consultar Pix");
        System.out.println(PIX_RECEBIDOS_CONSULTAR + " - Consultar Pix Recebidos");
        System.out.println(PIX_RECEBIDOS_CONSULTAR_PAGINACAO + " - Consultar Pix Recebidos com paginação");
        System.out.println(PIX_DEVOLUCAO_SOLICITAR + " - Solicitar Devolução");
        System.out.println(PIX_DEVOLUCAO_CONSULTAR + " - Consultar Devolução");

        System.out.println(WEBHOOK_CRIAR + " - Criar Webhook");
        System.out.println(WEBHOOK_OBTER + " - Obter Webhook");
        System.out.println(WEBHOOK_EXCLUIR + " - Excluir Webhook");
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
            case COBRANCA_IMEDIATA_CRIAR:
                new CriarCobrancaImediataDemo().execute(interSdk);
                break;
            case COBRANCA_IMEDIATA_REVISAR:
                new RevisarCobrancaImediataDemo().execute(interSdk);
                break;
            case COBRANCA_IMEDIATA_CONSULTAR:
                new ConsultarCobrancaImediataDemo().execute(interSdk);
                break;
            case COBRANCA_IMEDIATA_CRIAR_TXID:
                new CriarCobrancaImediataTxIdDemo().execute(interSdk);
                break;
            case COBRANCAS_IMEDIATAS_CONSULTAR:
                new ConsultarCobrancasImediatasDemo().execute(interSdk);
                break;
            case COBRANCAS_IMEDIATAS_CONSULTAR_PAGINACAO:
                new ConsultarCobrancasImediatasPaginadoDemo().execute(interSdk);
                break;
            case COBRANCA_COM_VENCIMENTO_CRIAR_TXID:
                new CriarCobrancaComVencimentoTxIdDemo().execute(interSdk);
                break;
            case COBRANCA_COM_VENCIMENTO_REVISAR:
                new RevisarCobrancaComVencimentoDemo().execute(interSdk);
                break;
            case COBRANCA_COM_VENCIMENTO_CONSULTAR:
                new ConsultarCobrancaComVencimentoDemo().execute(interSdk);
                break;
            case COBRANCAS_COM_VENCIMENTO_CONSULTAR:
                new ConsultarCobrancasComVencimentoDemo().execute(interSdk);
                break;
            case COBRANCAS_COM_VENCIMENTO_CONSULTAR_PAGINACAO:
                new ConsultarCobrancasComVencimentoPaginadoDemo().execute(interSdk);
                break;
            case LOCATION_CRIAR:
                new CriarLocationDemo().execute(interSdk);
                break;
            case LOCATIONS_CADASTRADAS_CONSULTAR:
                new ConsultarLocationsCadastradasDemo().execute(interSdk);
                break;
            case LOCATIONS_CADASTRADAS_CONSULTAR_PAGINACAO:
                new ConsultarLocationsCadastradasPaginadoDemo().execute(interSdk);
                break;
            case LOCATION_RECUPERAR:
                new RecuperarLocationDemo().execute(interSdk);
                break;
            case LOCATION_DESVINCULAR:
                new DesvincularLocationDemo().execute(interSdk);
                break;
            case PIX_CONSULTAR:
                new ConsultarPixDemo().execute(interSdk);
                break;
            case PIX_RECEBIDOS_CONSULTAR:
                new ConsultarPixRecebidosDemo().execute(interSdk);
                break;
            case PIX_RECEBIDOS_CONSULTAR_PAGINACAO:
                new ConsultarPixRecebidosPaginadoDemo().execute(interSdk);
                break;
            case PIX_DEVOLUCAO_SOLICITAR:
                new SolicitarDevolucaoDemo().execute(interSdk);
                break;
            case PIX_DEVOLUCAO_CONSULTAR:
                new ConsultarDevolucaoDemo().execute(interSdk);
                break;
            case WEBHOOK_CRIAR:
                new CriarWebhookPixDemo().execute(interSdk);
                break;
            case WEBHOOK_OBTER:
                new ObterWebhookPixDemo().execute(interSdk);
                break;
            case WEBHOOK_EXCLUIR:
                new ExcluirWebhookPixDemo().execute(interSdk);
                break;
            case CALLBACKS_CONSULTAR:
                new ConsultarCallbacksDemo().execute(interSdk);
                break;        }
        System.out.println();
    }
}
