public class test {
    public static void main(String[] args) {
        Estrela sol = new Estrela("Sol", 1.989e30, 4, "Ana Amarela", 5778);
        Planeta terra = new Planeta("Terra", 5.972e24, 1.0, 1, 6371, 4, sol);
        sol.adicionarPlaneta(terra);
        Lua lua = new Lua("Lua", 7.35e22, 4, 1737, terra);
        terra.adicionarLua(lua);
        
        System.out.println("Informacoes sobre a estrela:");
        System.out.println(sol.descricao());
        System.out.println();
        System.out.println("Informacoes sobre o planeta:");
        System.out.println(terra.descricao());
        System.out.println();
        System.out.println("Informacoes sobre a lua:");
        System.out.println(lua.descricao());
        System.out.println();
    }
}

/* A fazer
Outras Classes(Sistema Solar, Galaxia)
Menu
Tratamento de erros(no menu talvez?)
Revisao das formulas(?)
Refatorar o codigo(gambiarra)
Outros metodos ainda nao pensados
Ver um jeito de melhorar as entradas
Resolver bug das fontes(utf8)
*/