# 📝 Anotação Técnica de Desenvolvimento

## 🎯 Decisões Importantes de Arquitetura

* **Segregação de Interfaces (Aluno vs. Professor):** Optei estrategicamente por separar completamente as telas e os fluxos do Aluno e do Professor. Essa decisão foi tomada para garantir uma maior organização visual e estrutural no console, facilitando a manutenção do código e abrindo espaço para acrescentar novas funcionalidades de forma isolada e sem impactos cruzados.
* **Interoperabilidade com Exportação de Dados:** Implementei a geração de um arquivo físico formatado para leitura direta no Excel (CSV). Decidi incluir essa funcionalidade por entender que enriquece a experiência do usuário, permitindo que os dados acadêmicos guardados na memória do sistema sejam extraídos e utilizados externamente de forma prática.

---

## 🔬 Dificuldades Enfrentadas no Processo

* **Aderência aos Pilares da POO:** Minha maior barreira durante o desenvolvimento foi seguir rigorosamente as normas da Programação Orientada a Objetos. Passei bastante tempo pesquisando para garantir que a estrutura estivesse correta, mas reconheço que o projeto ainda não atingiu um nível de excelência em POO, operando muitas vezes de forma mais procedural por meio de funções isoladas.
* **Persistência e Trânsito de Dados:** Enfrentei muitos problemas no gerenciamento e na passagem de dados entre as entidades do sistema. Conectar listas de IDs com os objetos reais dentro da memória (`MemoryStorage`) e fazer com que uma alteração em uma ponta se refletisse corretamente na outra gerou diversos erros de compatibilidade que exigiram bastante tempo de depuração.

---

## 🛠️ Oportunidades de Correção Futura

Para elevar o nível técnico do software em próximas iterações, identifico as seguintes correções necessárias:

1. **Refatoração para POO Avançada:** Reduzir o uso de arquivos de funções soltas e passar a centralizar os comportamentos dentro das próprias classes. Aplicar encapsulamento estrito (propriedades privadas com métodos de acesso) e utilizar herança ou polimorfismo para tratar as semelhanças e diferenças entre os tipos de usuários.
2. **Implementação de Tratamento de Exceções Nativo:** Substituir as checagens e validações manuais feitas por condicionais de console por um sistema robusto de gerenciamento de erros baseado em `try-catch`. Isso blindará o fluxo contra entradas de dados inválidas ou falhas inesperadas de leitura.
3. **Padronização Global do Projeto:** Uniformizar a nomenclatura das variáveis, pacotes e propriedades do sistema. Atualmente, há uma mistura entre os idiomas inglês e português na escrita das entidades, sendo necessária uma limpeza para seguir estritamente as convenções de código limpo da linguagem.
