# 🎓 Sistema de Trilhas Educacionais
Sistema desenvolvido em Kotlin para gerenciamento
de alunos, cursos, trilhas e matrículas no console.

---

## 📌 Objetivo do Projeto
O propósito deste sistema é aprender na pŕatica o desenvolvimento com POO, além de começar a desenvolver códigos mais completos para a competição da WorldSkills:
* **Programação Orientada a Objetos (POO):** Mitigação de acoplamento rígido através de composição e blindagem de estados por encapsulamento.
* **Organização em Camadas (SoC):** Separação clara entre os mecanismos de captura de dados (Console) e os motores de processamento (Services).
* **Robustez de Fluxo (UX/CLI):** Construção de menus isolados que evitam o empilhamento de chamadas na memória da JVM (*StackOverflowError*).
* **Validação Precoce (*Fail-Fast*):** Barreiras de segurança com expressões `require` que interrompem operações inconsistentes antes da gravação de dados.

---

## 🛠️ Funcionalidades

### 👤 Usuários
- Cadastro de usuário
- Login
- Controle de acesso por perfil

### 🎓 Alunos
- Cadastro de alunos
- Listagem de alunos
- Busca de aluno
- Atualização de dados

### 📚 Cursos
- Cadastro de cursos
- Listagem de cursos
- Associação com trilhas

### 🛤️ Trilhas
- Cadastro de trilhas
- Adição de cursos
- Controle de status

### 📋 Matrículas
- Matrícula de alunos
- Registro de progresso
- Conclusão de trilha

### 📊 Relatórios
- Ranking de progresso
- Alunos sem matrícula
- Relatórios CSV


  ## 🏗️ Arquitetura e Organização do Repositório
O código-fonte está distribuído em pacotes coesos, isolando as responsabilidades do sistema:

```text
src/main/kotlin/
├── app/       -> Camada de Apresentação (Menus interativos, leitura de inputs e I/O de console)
├── model/     -> Camada de Domínio (Entidades de dados, Enums e persistência volátil em MemoryStorage)
├── service/   -> Camada de Aplicação (Classes de serviço focadas estritamente nas regras de negócio)
├── enums/     -> Centralização dos estados do sistema (UserType, StudentSituation, CourseCategory)
└── utils/     -> Componentes utilitários de suporte (Ex: Validação e tratamento de e-mails)
