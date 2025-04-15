import javax.swing.*;

public class Main {
    private static ListaDupla<Cidade> cidades = new ListaDupla<>();

    public static void main(String[] args) {
        String opcao;
        do {
            opcao = JOptionPane.showInputDialog(
                "✨ ExpressLine ✨\n" +
                "Bem-vindo ao sistema!\n" +
                "Escolha uma opção:\n" +
                "1. Cadastrar cidade\n" +
                "2. Cadastrar ligação\n" +
                "3. Listar cidades e ligações\n" +
                "4. Verificar ligação direta\n" +
                "5. Listar ligações por tempo máximo\n" +
                "0. Sair"
            );

            if (opcao == null || opcao.trim().isEmpty()) {
                break;
            }

            switch (opcao.trim().charAt(0)) {
                case '1':
                    cadastrarCidade();
                    break;
                case '2':
                    cadastrarLigacao();
                    break;
                case '3':
                    listarCidadesELigacoes();
                    break;
                case '4':
                    verificarLigacao();
                    break;
                case '5':
                    listarPorTempoMaximo();
                    break;
                case '0':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (!opcao.equals("0"));
    }

    private static void cadastrarCidade() {
        String nome = JOptionPane.showInputDialog("Nome da cidade:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação cancelada ou nome inválido!");
            return;
        }
        
        cidades.adicionar(new Cidade(nome.trim()));
        JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
    }

    private static void cadastrarLigacao() {
        try {
            String nomeCidade = JOptionPane.showInputDialog("Nome da cidade:");
            if (nomeCidade == null || nomeCidade.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
                return;
            }

            Cidade cidade = encontrarCidade(nomeCidade.trim());
            if (cidade == null) {
                JOptionPane.showMessageDialog(null, "Cidade não encontrada!");
                return;
            }

            String destino = JOptionPane.showInputDialog("Destino da ligação:");
            if (destino == null || destino.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Destino inválido!");
                return;
            }

            String distanciaStr = JOptionPane.showInputDialog("Digite a distância (em km):");
            double distancia = Double.parseDouble(distanciaStr);

            String trafegoStr = JOptionPane.showInputDialog("Digite o fator de tráfego (0 a 2, sendo 0 sem trânsito e 2 com muito trânsito):");
            double trafego = Double.parseDouble(trafegoStr);
            if (trafego < 0 || trafego > 2) {
                JOptionPane.showMessageDialog(null, "Fator de tráfego deve estar entre 0 e 2!");
                return;
            }

            String pedagiosStr = JOptionPane.showInputDialog("Digite o número de pedágios:");
            int pedagios = Integer.parseInt(pedagiosStr);

            cidade.getLigacoes().adicionar(new Ligacao(destino.trim(), distancia, trafego, pedagios));
            JOptionPane.showMessageDialog(null, "Ligação cadastrada com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor numérico inválido digitado!");
        }
    }

    private static void listarCidadesELigacoes() {
        if (cidades.isVazia()) {
            JOptionPane.showMessageDialog(null, "Nenhuma cidade cadastrada!");
            return;
        }
    
        String resultado = "Cidades e ligações:\n";
        NoDuplo<Cidade> atual = cidades.getPrimeiro();
        
        while (atual != null) {
            resultado += atual.getDado().toString() + "\n";
            atual = atual.getProximo();
        }
        
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    private static void verificarLigacao() {
        String cidadeOrigem = JOptionPane.showInputDialog("Nome da cidade de origem:");
        if (cidadeOrigem == null || cidadeOrigem.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
            return;
        }

        String cidadeDestino = JOptionPane.showInputDialog("Nome da cidade de destino:");
        if (cidadeDestino == null || cidadeDestino.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
            return;
        }

        Cidade origem = encontrarCidade(cidadeOrigem.trim());
        if (origem == null) {
            JOptionPane.showMessageDialog(null, "Cidade de origem não encontrada!");
            return;
        }

        NoDuplo<Ligacao> lig = origem.getLigacoes().getPrimeiro();
        while (lig != null) {
            if (lig.getDado().getDestino().equalsIgnoreCase(cidadeDestino.trim())) {
                double tempo = lig.getDado().getTempoEstimado();
                JOptionPane.showMessageDialog(null, 
                    "Existe ligação direta!\nTempo estimado: " + 
                    String.format("%.2f", tempo) + " minutos.");
                return;
            }
            lig = lig.getProximo();
        }
        JOptionPane.showMessageDialog(null, "Não há ligação direta entre essas cidades.");
    }

    private static void listarPorTempoMaximo() {
        try {
            String tempoMaxStr = JOptionPane.showInputDialog("Digite o tempo máximo (em minutos):");
            if (tempoMaxStr == null || tempoMaxStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
                return;
            }
    
            double tempoMax = Double.parseDouble(tempoMaxStr);
            String resultado = "Ligações com tempo ≤ " + tempoMax + " minutos:\n";
            boolean encontrou = false;
    
            NoDuplo<Cidade> atual = cidades.getPrimeiro();
            while (atual != null) {
                Cidade cidade = atual.getDado();
                NoDuplo<Ligacao> lig = cidade.getLigacoes().getPrimeiro();
                while (lig != null) {
                    double tempo = lig.getDado().getTempoEstimado();
                    if (tempo <= tempoMax) {
                        resultado += cidade.getNome() + " → " + 
                                   lig.getDado().getDestino() + " (" + 
                                   String.format("%.2f", tempo) + " min)\n";
                        encontrou = true;
                    }
                    lig = lig.getProximo();
                }
                atual = atual.getProximo();
            }
    
            JOptionPane.showMessageDialog(null, encontrou ? resultado : "Nenhuma ligação encontrada.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tempo inválido! Digite um valor numérico.");
        }
    }

    private static Cidade encontrarCidade(String nome) {
        NoDuplo<Cidade> atual = cidades.getPrimeiro();
        while (atual != null) {
            if (atual.getDado().getNome().equalsIgnoreCase(nome.trim())) {
                return atual.getDado();
            }
            atual = atual.getProximo();
        }
        return null;
    }
}