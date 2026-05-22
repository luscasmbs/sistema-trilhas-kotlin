# 🧪 Plano e Checklist de Testes Manuais (QA)

Este documento descreve detalhadamente os Casos de Teste (CT) executados manualmente para garantir a robustez, estabilidade e conformidade das regras de negócio do sistema frente aos requisitos estabelecidos.

---

## 👤 1. Módulo de Autenticação e Gestão de Usuários

### CT01: Cadastro de Aluno com Injeção Dinâmica (Caminho Feliz)
* **Pré-condição:** Sistema iniciado na tela de registro.
* **Dados de Entrada:** Nome: `Ana Silva`, Email: `ana.silva@escola.com`, Senha: `1234`, Perfil: `2 - Aluno`.
* **Passos:**
  1. Acessar menu de cadastro.
  2. Escolher a opção de Aluno.
  3. Preencher os dados solicitados e confirmar.
* **Resultado Esperado:** Usuário gravado com ID autogerado. O campo interno `student` deve ser instanciado automaticamente carregando o status `ATIVO` e listas de cursos/trilhas vazias.
* **Status:** [x] Passou

### CT02: Impedir Cadastro de E-mail Duplicado (Cenário de Exceção)
* **Pré-condição:** Um usuário já cadastrado com o e-mail `ana.silva@escola.com`.
* **Dados de Entrada:** Nome: `Ana Outra`, Email: `ana.silva@escola.com`, Senha: `9999`, Perfil: `2 - Aluno`.
* **Passos:**
  1. Tentar registrar um novo usuário utilizando o mesmo e-mail exato do CT01.
* **Resultado Esperado:** O sistema deve disparar a validação defensiva, abortar a gravação no `MemoryStorage` e exibir a mensagem amigável: `Erro ao salvar: Este e-mail já está cadastrado no sistema!`.
* **Status:** [x] Passou

### CT03: Login e Redirecionamento por Perfil (Controle de Fluxo)
* **Pré-condição:** Usuário do tipo Professor cadastrado (Ex: ID 1, `prof@escola.com`, senha `4321`).
* **Dados de Entrada:** E-mail: `prof@escola.com`, Senha: `4321`.
* **Passos:**
  1. Acessar a tela de Login.
  2. Inserir as credenciais válidas do Professor.
* **Resultado Esperado:** O sistema valida os dados e efetua o redirecionamento imediato para a função `Teacherm()`, exibindo o menu exclusivo com opções de gerenciamento de cursos e trilhas.
* **Status:** [x] Passou

---

## 🎓 2. Módulo de Gerenciamento Acadêmico (Core Business)

### CT04: Alteração de Situação de Estudante por ID (Mutação de Estado)
* **Pré-condição:** Aluno cadastrado com ID `1` e status inicial `ATIVO`.
* **Dados de Entrada:** ID do Aluno: `1`, Nova Situação: `2 - BLOQUEADO`.
* **Passos:**
  1. Logar como Professor e acessar o menu "Gerenciar Alunos".
  2. Escolher a opção "1 - Alterar situação do aluno".
  3. Informar o ID `1` e selecionar a opção correspondente a `BLOQUEADO`.
* **Resultado Esperado:** O sistema deve localizar o usuário na lista global, acessar a propriedade mutável do perfil estudantil e atualizar o enum para `StudentSituation.BLOQUEADO`. Uma busca posterior deve refletir o novo estado.
* **Status:** [x] Passou

### CT05: Bloqueio de Matrícula Duplicada em Trilha (Regra de Negócio)
* **Pré-condição:** Uma trilha válida cadastrada no sistema (ID `10`). Aluno (ID `1`) já vinculado a esta mesma trilha `10`.
* **Dados de Entrada:** ID do Aluno: `1`, ID da Trilha: `10`.
* **Passos:**
  1. No menu de gerenciamento, tentar associar o aluno `1` à trilha `10` pela segunda vez.
* **Resultado Esperado:** A camada de serviço deve validar a lista de inteiros (`trail`) do aluno e disparar uma exceção de interrupção, exibindo: `Você já está matriculado nesta trilha!`. O ID não pode ser duplicado na coleção.
* **Status:** [x] Passou

### CT06: Bloqueio de Curso Duplicado na Mesma Trilha (Encapsulamento)
* **Pré-condição:** Trilha "Desenvolvimento Mobile" criada. Curso "Kotlin Básico" (ID `5`) já associado a esta trilha.
* **Dados de Entrada:** ID do Curso: `5`.
* **Passos:**
  1. Tentar adicionar o curso `5` novamente na mesma trilha.
* **Resultado Esperado:** A função `adicionarCurso()` da classe `Trail` deve recusar a inserção por meio do validador interno, exibindo a mensagem: `Este curso já faz parte desta trilha!`.
* **Status:** [x] Passou

---

## 📊 3. Módulo de Cálculos e Relatórios

### CT07: Proteção Contra Divisão por Zero no Progresso (Cenário de Estresse)
* **Pré-condição:** Trilha cadastrada (ID `20`), porém nenhum curso foi associado a ela ainda (lista de cursos vazia). Aluno matriculado nesta trilha.
* **Dados de Entrada:** ID do Aluno, ID da Trilha: `20`.
* **Passos:**
  1. Solicitar a exibição do progresso acadêmico ou exportar o relatório deste aluno.
* **Resultado Esperado:** O método de cálculo deve identificar de forma preventiva que o divisor (`trilha.cursos.size`) é igual a zero, desviar do cálculo aritmético padrão e retornar estritamente `0.0%`, evitando o travamento do sistema por `ArithmeticException`.
* **Status:** [x] Passou

### CT08: Geração e Consistência do Arquivo de Relatório (I/O Física)
* **Pré-condição:** Pelo menos 1 Aluno e 1 Professor cadastrados no sistema.
* **Dados de Entrada:** Acionamento da opção "Exportar Relatório para Excel".
* **Passos:**
  1. Acessar o submenu de relatórios do Professor.
  2. Escolher a opção de exportação.
* **Resultado Esperado:** O sistema deve ignorar contas do tipo Professor, varrer apenas os Alunos, processar os dados estruturados separados por ponto e vírgula (`;`) e gravar com sucesso o arquivo físico `relatorio_excel_worldskills.csv` na raiz do projeto.
* **Status:** [x] Passou
