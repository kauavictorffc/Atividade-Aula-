import java.util.ArrayList;
import java.util.List;

interface VeiculoEscolar {
    void exibirInformacoes();
    void embarcarAluno(String nomeAluno);
    void desembarcarAluno(String nomeAluno);
}

class VanEscolar implements VeiculoEscolar {
    private int capacidade;
    private String rota;
    private List<String> alunos;

    public VanEscolar(int capacidade, String rota) {
        this.capacidade = capacidade;
        this.rota = rota;
        this.alunos = new ArrayList<>();
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Van Escolar - Capacidade: " + capacidade);
        System.out.println("Rota: " + rota);
    }

    @Override
    public void embarcarAluno(String nomeAluno) {
        if (alunos.size() < capacidade) {
            alunos.add(nomeAluno);
            System.out.println(nomeAluno + " embarcou na van escolar.");
        } else {
            System.out.println("A van escolar está cheia. " + nomeAluno + " não pôde embarcar.");
        }
    }

    @Override
    public void desembarcarAluno(String nomeAluno) {
        if (alunos.contains(nomeAluno)) {
            alunos.remove(nomeAluno);
            System.out.println(nomeAluno + " desembarcou da van escolar.");
        } else {
            System.out.println(nomeAluno + " não está na van escolar.");
        }
    }
}

class OnibusEscolar implements VeiculoEscolar {
    private int capacidade;
    private String rota;
    private List<String> alunos;

    public OnibusEscolar(int capacidade, String rota) {
        this.capacidade = capacidade;
        this.rota = rota;
        this.alunos = new ArrayList<>();
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Ônibus Escolar - Capacidade: " + capacidade);
        System.out.println("Rota: " + rota);
    }

    @Override
    public void embarcarAluno(String nomeAluno) {
        if (alunos.size() < capacidade) {
            alunos.add(nomeAluno);
            System.out.println(nomeAluno + " embarcou no ônibus escolar.");
        } else {
            System.out.println("O ônibus escolar está cheio. " + nomeAluno + " não pôde embarcar.");
        }
    }

    @Override
    public void desembarcarAluno(String nomeAluno) {
        if (alunos.contains(nomeAluno)) {
            alunos.remove(nomeAluno);
            System.out.println(nomeAluno + " desembarcou do ônibus escolar.");
        } else {
            System.out.println(nomeAluno + " não está no ônibus escolar.");
        }
    }
}

interface FabricaVeiculoEscolar {
    VeiculoEscolar criarVeiculoEscolar();
}

class FabricaVanEscolar implements FabricaVeiculoEscolar {
    @Override
    public VeiculoEscolar criarVeiculoEscolar() {
        return new VanEscolar(10, "Rota A");
    }
}

class FabricaOnibusEscolar implements FabricaVeiculoEscolar {
    @Override
    public VeiculoEscolar criarVeiculoEscolar() {
        return new OnibusEscolar(40, "Rota B");
    }
}

public class Principal {
    public static void main(String[] args) {
        FabricaVeiculoEscolar fabricaVanEscolar = new FabricaVanEscolar();
        VeiculoEscolar vanEscolar = fabricaVanEscolar.criarVeiculoEscolar();
        System.out.println("Informações da Van Escolar:");
        vanEscolar.exibirInformacoes();
        System.out.println();

        FabricaVeiculoEscolar fabricaOnibusEscolar = new FabricaOnibusEscolar();
        VeiculoEscolar onibusEscolar = fabricaOnibusEscolar.criarVeiculoEscolar();
        System.out.println("Informações do Ônibus Escolar:");
        onibusEscolar.exibirInformacoes();
        System.out.println();

        System.out.println("Gestão de Alunos:");
        vanEscolar.embarcarAluno("Alice");
        vanEscolar.embarcarAluno("Bob");
        onibusEscolar.embarcarAluno("Charlie");
        onibusEscolar.embarcarAluno("David");

        System.out.println();
        vanEscolar.desembarcarAluno("Bob");
        onibusEscolar.desembarcarAluno("David");
        vanEscolar.embarcarAluno("Eve");
        onibusEscolar.embarcarAluno("Frank");
    }
}