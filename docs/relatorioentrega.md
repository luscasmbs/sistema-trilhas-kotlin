# 📄 Relatório Técnico de Implementação (WS-Academy)

Este relatório sintetiza as funcionalidades desenvolvidas, os mecanismos de consistência aplicados e as oportunidades de evolução identificadas no sistema.

---

## 🚀 1. Funcionalidades Implementadas

### Módulo Administrativo (Professor)
* **Autenticação e Perfis:** Fluxo de login e cadastro segregado por nível de acesso (`PROFESSOR` e `ALUNO`).
* **Gerenciamento de Entidades:** Cadastro completo de Alunos, Cursos (utilizando Enums para Nível e Categoria) e Trilhas.
* **Vínculo Relacional:** Associação direta de múltiplos cursos dentro de uma trilha.
* **Controle Acadêmico:** Matrícula de estudantes em trilhas específicas.
* **Motor de Desempenho:** Cálculo em tempo real da porcentagem de evolução de cada aluno.
* **Exportação Física:** Geração de arquivo de relatório unificado em formato `.csv` estruturado para abertura direta no Microsoft Excel.

### Módulo do Estudante (Aluno)
* **Painel Exclusivo:** Menu dinâmico adaptado para o aluno autenticado.
* **Monitoramento:** Consulta de trilhas matriculadas e status individual de cada curso (`⏳ Em andamento` ou `✅ Concluído`).
* **Histórico:** Registro de conclusão de cursos através da entrada do ID correspondente.

---

## 🛡️ 2. Validações e Limitações Aplicadas

Para garantir a consistência do banco de dados em memória (`MemoryStorage`), foram aplicadas barreiras lógicas através de estruturas `if/else`:

* **Validação de Sintaxe:** Bloqueio e rejeição de e-mails fora do padrão sintático aceitável.
* **Garantia de Unicidade:** Impedimento de duplicação de matrículas (um aluno não pode ser matriculado na mesma trilha duas vezes) e bloqueio de nomes duplicados para trilhas.
* **Existência de Dados:** Verificação prévia de IDs. Não é possível matricular alunos inexistentes ou vincular cursos que não constam no catálogo.
* **Proteção Matemática:** Bloqueio preventivo contra divisão por zero no cálculo de progresso caso uma trilha ainda não possua cursos associados.
* **Segurança de Navegação:** Loops de retenção com `while(true)` e pontos de fuga explícitos via `return` para evitar estouro de pilha de memória.

---

## 📈 3. Pontos de Melhoria Identificados

Para futuras iterações do software, foram mapeadas as seguintes oportunidades de evolução técnica:

* **Tratamento de Erros:** Substituir as validações manuais de console por um sistema robusto de manipulação de exceções (`try-catch`), permitindo capturar falhas inesperadas de entrada de dados e chamadas nulas de forma centralizada.
* **Padronização do Código:** Uniformizar a nomenclatura de variáveis, pacotes e funções (atualmente mescladas entre inglês e português) seguindo estritamente as convenções oficiais da linguagem Kotlin.
* **Alinhamento com Princípios de POO:** Aprofundar a aplicação da Programação Orientada a Objetos, reduzindo a dependência de funções puramente procedimentais em arquivos de serviço isolados. Isso inclui aplicar conceitos de encapsulamento rígido (tornando propriedades privadas), herança e polimorfismo para a especialização dos tipos de usuários.
