package org.example;

    public class FabricaPagamentos {
        public static FormaPagamento criarPagamento(String tipo) {
            switch (tipo.toLowerCase()) {
                case "pix":
                    return new PagamentoPix();
                case "cartao":
                    return new PagamentoCartao();
                case "boleto":
                    return new PagamentoBoleto();
                default:
                    throw new IllegalArgumentException("Método de pagamento inválido: " + tipo);
            }
        }
    }