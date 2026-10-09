# Desafio de Projeto - API de Orçamento com Validação de Negócio (Spring Boot)

API de orçamento financeiro desenvolvida como parte do desafio de projetos do ecossistema Spring Boot, aplicando boas práticas, arquitetura limpa e validações preventivas na camada de serviço.

## 🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot (Web, Data JPA)
- H2 Database (Banco de dados em memória)
- Lombok
- Maven

## 💡 Melhoria Implementada
Foi adicionada uma **Validação de Negócio robusta** no serviço (`TransacaoService`) que garante que nenhuma transação seja persistida no banco de dados sem cumprir as seguintes regras:
1. **Validação de Valor:** O valor da transação não pode ser nulo, zero ou negativo (deve ser estritamente maior que zero).
2. **Validação de Categoria:** A categoria informada precisa obrigatoriamente pertencer à lista de categorias válidas permitidas pelo sistema (`Alimentação`, `Transporte`, `Lazer`, `Moradia`, `Salário`). Caso contrário, a operação é barrada com uma exceção personalizada e retorno HTTP adequado.

## ⚙️ Como Executar a Aplicação
1. Clone o repositório ou abra a pasta no **VS Code**.
2. Certifique-se de ter o Java instalado.
3. Abra a classe principal `OrcamentoApplication.java` e clique em **Run**.
4. A API estará rodando localmente em `http://localhost:8080`.

## 🧪 Como Testar os Endpoints
Faça uma requisição **`POST`** para o endpoint:
`http://localhost:8080/transacoes`

### Exemplo de Sucesso (Status 200 OK):
```json
{
  "descricao": "Compra de supermercado",
  "valor": 150.00,
  "categoria": "Alimentação"
}

Exemplo de Erro de Negócio - Valor Inválido (Status 400 Bad Request):
JSON
{
  "descricao": "Erro de valor",
  "valor": -10.00,
  "categoria": "Alimentação"
}
Retorno esperado: "O valor da transação deve ser maior que zero."

Exemplo de Erro de Negócio - Categoria Inválida (Status 400 Bad Request):
JSON
{
  "descricao": "Gasto não listado",
  "valor": 200.00,
  "categoria": "Viagens"
}
Retorno esperado: "A categoria informada é inválida: Viagens"

O Aprendizado
Durante este desafio, foi possível exercitar a criação de uma API REST funcional utilizando Spring Boot do zero, estruturando camadas (Model, Repository, Service, Controller), tratando exceções de negócio personalizadas e integrando persistência em memória com H2.