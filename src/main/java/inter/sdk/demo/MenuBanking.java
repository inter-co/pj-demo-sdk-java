package inter.sdk.demo;

import inter.InterSdk;
import inter.sdk.demo.banking.extrato.ConsultarExtratoDemo;
import inter.sdk.demo.banking.extrato.ConsultarExtratoEnriquecidoDemo;
import inter.sdk.demo.banking.extrato.ConsultarExtratoEnriquecidoPaginadoDemo;
import inter.sdk.demo.banking.extrato.RecuperarExtratoPdfDemo;
import inter.sdk.demo.banking.pagamento.BuscarLotePagamentosDemo;
import inter.sdk.demo.banking.pagamento.BuscarPagamentosDarfDemo;
import inter.sdk.demo.banking.pagamento.BuscarPagamentosDemo;
import inter.sdk.demo.banking.pagamento.CancelarAgendamentoDemo;
import inter.sdk.demo.banking.pagamento.IncluirPagamentoDarfDemo;
import inter.sdk.demo.banking.pagamento.IncluirPagamentoDemo;
import inter.sdk.demo.banking.pagamento.IncluirPagamentosLoteDemo;
import inter.sdk.demo.banking.pix.IncluirPixChaveDemo;
import inter.sdk.demo.banking.pix.IncluirPixDadosBancariosDemo;
import inter.sdk.demo.banking.saldo.ConsultarSaldoDemo;
import inter.sdk.demo.banking.webhook.ConsultarCallbacksDemo;
import inter.sdk.demo.banking.webhook.CriarWebhookBankingDemo;
import inter.sdk.demo.banking.webhook.ExcluirWebhookBankingDemo;
import inter.sdk.demo.banking.webhook.ObterWebhookBankingDemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBanking {
    private static final int CONSULTAR_EXTRATO = 1;
    private static final int CONSULTAR_EXTRATO_PDF = 2;
    private static final int CONSULTAR_EXTRATO_ENRIQUECIDO = 3;
    private static final int CONSULTAR_EXTRATO_ENRIQUECIDO_PAGINACAO = 4;
    private static final int CONSULTAR_SALDO = 5;
    private static final int INCLUIR_PAGAMENTO = 6;
    private static final int BUSCAR_PAGAMENTOS = 7;
    private static final int INCLUIR_PAGAMENTO_DARF = 8;
    private static final int BUSCAR_PAGAMENTOS_DARF = 9;
    private static final int INCLUIR_PAGAMENTOS_LOTE = 10;
    private static final int BUSCAR_LOTE_PAGAMENTOS = 11;
    private static final int CANCELAR_AGENDAMENTO = 12;
    private static final int INCLUIR_PIX_CHAVE = 13;
    private static final int INCLUIR_PIX_DADOS_BANCARIOS = 14;
    private static final int CRIAR_WEBHOOK = 15;
    private static final int OBTER_WEBHOOK = 16;
    private static final int EXCLUIR_WEBHOOK = 17;
    private static final int CALLBACKS_CONSULTAR = 18;

    public static int showMenu(String ambiente) {
        System.out.println("AMBIENTE " + ambiente);
        System.out.println(CONSULTAR_EXTRATO + " - Consultar Extrato");
        System.out.println(CONSULTAR_EXTRATO_PDF + " - Recuperar Extrato PDF");
        System.out.println(CONSULTAR_EXTRATO_ENRIQUECIDO + " - Consultar Extrato Enriquecido");
        System.out.println(CONSULTAR_EXTRATO_ENRIQUECIDO_PAGINACAO + " - Consultar Extrato Enriquecido com paginação");
        System.out.println(CONSULTAR_SALDO + " - Consultar Saldo");
        System.out.println(INCLUIR_PAGAMENTO + " - Incluir Pagamento");
        System.out.println(BUSCAR_PAGAMENTOS + " - Buscar Pagamentos");
        System.out.println(INCLUIR_PAGAMENTO_DARF + " - Incluir Pagamento de DARF");
        System.out.println(BUSCAR_PAGAMENTOS_DARF + " - Buscar Pagamentos de DARF");
        System.out.println(INCLUIR_PAGAMENTOS_LOTE + " - Incluir Pagamentos em Lote");
        System.out.println(BUSCAR_LOTE_PAGAMENTOS + " - Buscar Lote Pagamentos");
        System.out.println(CANCELAR_AGENDAMENTO + " - Cancelar agendamento de pagamento");
        System.out.println(INCLUIR_PIX_CHAVE + " - Incluir Pix Chave");
        System.out.println(INCLUIR_PIX_DADOS_BANCARIOS + " - Incluir Pix Dados Bancários");
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
            case CONSULTAR_EXTRATO:
                new ConsultarExtratoDemo().execute(interSdk);
                break;
            case CONSULTAR_EXTRATO_PDF:
                new RecuperarExtratoPdfDemo().execute(interSdk);
                break;
            case CONSULTAR_EXTRATO_ENRIQUECIDO:
                new ConsultarExtratoEnriquecidoDemo().execute(interSdk);
                break;
            case CONSULTAR_EXTRATO_ENRIQUECIDO_PAGINACAO:
                new ConsultarExtratoEnriquecidoPaginadoDemo().execute(interSdk);
                break;
            case CONSULTAR_SALDO:
                new ConsultarSaldoDemo().execute(interSdk);
                break;
            case INCLUIR_PAGAMENTO:
                new IncluirPagamentoDemo().execute(interSdk);
                break;
            case BUSCAR_PAGAMENTOS:
                new BuscarPagamentosDemo().execute(interSdk);
                break;
            case INCLUIR_PAGAMENTO_DARF:
                new IncluirPagamentoDarfDemo().execute(interSdk);
                break;
            case BUSCAR_PAGAMENTOS_DARF:
                new BuscarPagamentosDarfDemo().execute(interSdk);
                break;
            case INCLUIR_PAGAMENTOS_LOTE:
                new IncluirPagamentosLoteDemo().execute(interSdk);
                break;
            case BUSCAR_LOTE_PAGAMENTOS:
                new BuscarLotePagamentosDemo().execute(interSdk);
                break;
            case INCLUIR_PIX_CHAVE:
                new IncluirPixChaveDemo().execute(interSdk);
                break;
            case INCLUIR_PIX_DADOS_BANCARIOS:
                new IncluirPixDadosBancariosDemo().execute(interSdk);
                break;
            case CRIAR_WEBHOOK:
                new CriarWebhookBankingDemo().execute(interSdk);
                break;
            case OBTER_WEBHOOK:
                new ObterWebhookBankingDemo().execute(interSdk);
                break;
            case EXCLUIR_WEBHOOK:
                new ExcluirWebhookBankingDemo().execute(interSdk);
                break;
            case CANCELAR_AGENDAMENTO:
                new CancelarAgendamentoDemo().execute(interSdk);
                break;
            case CALLBACKS_CONSULTAR:
                new ConsultarCallbacksDemo().execute(interSdk);
                break;
        }
        System.out.println();
    }
}
