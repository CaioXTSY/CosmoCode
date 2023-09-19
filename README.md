# 🌌 CosmoCode: O Universo em OOP 🚀

## 👩‍🚀 Informações da Equipe 🧑‍🚀

| 🌠 Nome                 | 🎫 Matrícula  |
|------------------------|--------------|
| Caio Teixeira da Silva  | 22112243     |
| Noemy Torres Pereira    | 22112110     |

**🏫 Universidade Federal de Alagoas (UFAL)**  
**🏛️ Campus Arapiraca**  
**📚Disciplina : Programação Orientada a Objetos**  
**💻 Curso: Ciência da Computação**  
**👨‍🏫 Professores: Tácito e Tercio**  
**🛠️ Monitor : Rodrigo**

## 📝 Descrição da Área e Tema 🌍

### 🌐 Área
Este trabalho está situado na interseção entre ciência da computação 🖥️ e astronomia 🔭, especificamente na simulação computacional de sistemas astronômicos 🌠.

### 🌟 Tema
O tema central é a simulação do Sistema Solar e outros corpos celestes, como sistemas estelares e galáxias, usando conceitos de Programação Orientada a Objetos (OOP) 💻.

## 🎯 Justificativa da Importância do Tema 🌌

O estudo e a simulação do universo 🌌 têm aplicações práticas em diversas áreas, incluindo a exploração espacial, a previsão de eventos astronômicos e a pesquisa científica . O uso de OOP permite uma modelagem mais natural e extensível dos complexos sistemas astronômicos, facilitando o entendimento e a manutenção do código 🛠️.

## 🎩 Objetivos da Implementação 🌠

1. 🛠️ Desenvolver uma estrutura de classes que represente diferentes tipos de corpos celestes, como planetas, estrelas, luas, asteroides, cometas e buracos negros.
  
2. 🧪 Implementar métodos para simular a interação entre esses corpos, como movimento orbital e forças gravitacionais.
  
3. 👓 Utilizar padrões de projeto e boas práticas de OOP para criar um código modular, extensível e fácil de manter.

---

## 🌌 Classes e Conceitos de OOP 

### 👾 Classes Abstratas
- `CorpoCeleste`: Classe abstrata que contém campos como nome, massa e métodos.

### 🌀 Interfaces
- `Movimentavel`: Define métodos para translação e rotação.
- `Gravitacional`: Define métodos para calcular a força gravitacional entre corpos.

### 🌟 Classes Concretas
- `Planeta`: Extende `CorpoCeleste`, adiciona campos como distância ao Sol e número de luas.
- `Estrela`: Extende `CorpoCeleste`, acrescenta campos como tipo de estrela e temperatura.
- `Lua`: Extende `CorpoCeleste`, adiciona um campo para o planeta a que pertence.
- `Galaxia`: Contém uma lista de `CorpoCeleste` e métodos para adicionar/remover corpos.

### 🛠️ Composição
- `SistemaSolar`: Contém uma lista de `CorpoCeleste` e métodos para adicionar/remover corpos e calcular forças gravitacionais entre eles.

## 📚 Conceitos de Orientação a Objetos Utilizados

### 👶 Herança
- `Planeta`, `Estrela` e `Lua`, são subclasses de `CorpoCeleste`.

### 🎈 Abstração
- `CorpoCeleste` fornece uma abstração de alto nível para todos os corpos celestes.

### 🔮 Polimorfismo
- A interface `Movimentavel` permite diferentes implementações para os métodos de movimento.
- A interface `Gravitacional` permite cálculos polimórficos de força gravitacional.

### 🎁 Encapsulamento
- Atributos são mantidos privados, sendo acessíveis apenas por métodos `get` e `set`.

## 🚫 Tratamento de Erros ❓
- A aplicação de tratamento de erros, dará-se a no menu, onde o usuário poderá fazer o cadastro das entidades ou escolher visualizá-las, por se tratar de um menu baseado em opções númericas, a função InputMismatchException, será utilizada para inpedir entradas inválidas (letras e caracteres especiais), ocasionando uma quebra no código, assim como a função Exception, que será utilizada para capturar erros inesperados.
## 📜 Obs

Os métodos de cálculo de impacto, gravitacional e outros fenômenos astronômicos que serão implementados neste projeto são simplificações e idealizações. Eles não representam as complexas equações e teorias da física que descrevem esses fenômenos no universo real.
